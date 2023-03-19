package dev.trxsson.versioncheck;

import dev.trxsson.simpleconfigs.init.ConfigLoader;
import dev.trxsson.versioncheck.events.PreLoginListener;
import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

public class VersionCheck extends Plugin {

    @Getter
    private PluginConfig config;

    @Getter
    private MiniMessage miniMessage;

    @Override
    public void onEnable() {
        ConfigLoader configLoader = new ConfigLoader(getLogger());
        config = (PluginConfig) configLoader.loadConfig(new File(getDataFolder(), "config.json"), PluginConfig.class, getDescription().getVersion());
        miniMessage = MiniMessage.miniMessage();
        getProxy().getPluginManager().registerListener(this, new PreLoginListener(this));
    }
}
