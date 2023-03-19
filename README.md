# Waterfall VersionCheck
A simple waterfall plugin that shows players a custom message when joining with the wrong version of Minecraft.
## Config
- `config_version` - This field is set automatically and should not be changed. It's used to check if the plugin is on a newer version than the config on startup. If so, the config will be backed up and the plugin will add the newly added lines and remove unnecessary ones.
- `supportedProtocolVersions` - A list of all protocol versions that the server should be able to be joined with. A list of all protocol versions can be found at https://wiki.vg/Protocol_version_numbers
- `kickMessage` - The kick message shown when a player tries to join with a disallowed version. The message uses kyori adventure minimessage format. Documentation: https://docs.advntr.dev/minimessage/format.html
