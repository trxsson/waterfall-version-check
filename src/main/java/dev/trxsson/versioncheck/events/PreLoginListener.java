package dev.trxsson.versioncheck.events;

import dev.trxsson.versioncheck.VersionCheck;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import java.util.Arrays;

public class PreLoginListener implements Listener {

    private final VersionCheck versionCheck;
    private final BaseComponent[] kickMessage;

    public PreLoginListener(VersionCheck versionCheck) {
        this.versionCheck = versionCheck;
        LegacyComponentSerializer serializer = LegacyComponentSerializer.legacySection();
        this.kickMessage = new ComponentBuilder(
                serializer.serialize(versionCheck.getMiniMessage().deserialize(versionCheck.getConfig().kickMessage))
        ).create();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPreLogin(PreLoginEvent event) {
        if (Arrays.stream(versionCheck.getConfig().supportedProtocolVersions).noneMatch(integer -> integer.equals(event.getConnection().getVersion()))) {
            event.setCancelled(true);
            event.setCancelReason(kickMessage);
        }
    }

}