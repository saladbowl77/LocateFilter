日本語 / [Enlgish](/README_EN.md)
# Locate Filter
これは Spigot / Paper 向けの特定の国のIPアドレスをキックするプラグインです。

## 設定方法
設定するにはconfig.ymlを変更してください

| name | type | detail |
|---|---|---|
| kickMessage | String | プレイヤーをキックする際のメッセージを入力してください。 |
| allowCountry | Array | 許可する国を入力してください。 |
| blockIPArr | Array | 特定のIPをブロックする際はここに入力してください。 |
| allowIPArr | Array | 特定のIPを許可する際はここに入力してください。 |

Example
```yml
kickMessage: "あなたの国からのアクセスは許可されていません。"
allowCountry:
 - JP
 - US
blockIPArr:
 - 192.168.0.10
allowIPArr:
 - 127.0.0.1
```