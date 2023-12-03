package work.saladbowl.mc.locatefilter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class IPData {
    static final String baseHost = "cc.wariate.jp"; // see http://cc.wariate.jp/

    public static Boolean getCountry(String IPAddr) throws UnknownHostException {
        FileConfiguration config = LocateFilter.plugin.getConfig();

        if (config.getStringList("blockIPArr").contains(IPAddr)) {
            return false;
        } else if (config.getStringList("allowIPArr").contains(IPAddr)) {
            return true;
        } else {
            // This Codes reference to https://qiita.com/oyahiroki/items/4d3dc6c8b49415896e03
            // And this API use this http://cc.wariate.jp.
            // If blockIPArr or allowIPArr does not match ip address.
            String addr = "";
            for (byte digit: InetAddress.getByName(IPAddr).getAddress()) {
                addr = (digit < 0 ? digit + 256 : digit) + "." + addr;
            }
            List<String> locales = config.getStringList("allowCountry");
            for (String locale: locales) {
                String lookupHost = addr + locale.toLowerCase() + "." + baseHost;
                try {
                    InetAddress.getByName(lookupHost);
                    return true;
                } catch (UnknownHostException e) {
                    Bukkit.getLogger().info("[Locate Filter ERROR] " + e);
                }
            }
            return false;
        }
    }
}
