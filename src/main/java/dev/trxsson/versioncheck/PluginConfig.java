package dev.trxsson.versioncheck;

import dev.trxsson.simpleconfigs.Config;

public class PluginConfig extends Config {
    public Integer[] supportedProtocolVersions = {
            759, 760, 761
    };
    public String kickMessage = "<red><bold>Unsupported Version<reset><br>" +
            "<br>" +
            "<gray>The version of Minecraft you're currently<br>" +
            "<gray>playing is not supported by this server.<br>" +
            "<br>" +
            "<red>Please use any version from <yellow>1.19 <red>up to <yellow>1.19.2<red>!";
}
