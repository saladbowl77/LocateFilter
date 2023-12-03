[日本語](/README.md) / English
# Locate Filter
This Spigot / Paper plugin is a filter of country by IP Address.
You can filter client user country.

## How to setting?
Please change the config.yml

| name | Type | detail |
|---|---|---|
| kickMessage | String  | Please type a message when kicking the server.|
| allowCountry | Array  | Please type country to allow.|
| blockIPArr | Array  | Please type disallow exceptional IP address.|
| allowIPArr | Array  | Please type allow exceptionally IP address.|

Example
```yml
kickMessage: "You don't have permission to access this server."
allowCountry:
 - JP
 - US
blockIPArr:
 - 192.168.0.10
allowIPArr:
 - 127.0.0.1
```