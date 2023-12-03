package work.saladbowl.mc.locatefilter;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class LocateFilter extends JavaPlugin implements Listener {
    public static LocateFilter plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        // Register event listener
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerPreLogin(AsyncPlayerPreLoginEvent e) throws Exception {
        String ipAddress = e.getAddress().getHostAddress();

        Bukkit.getLogger().info("Player " + e.getName() + " has IP address: " + ipAddress);

        if (!IPData.getCountry(ipAddress)) e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, getConfig().getString("kickMessage"));
    }
}
