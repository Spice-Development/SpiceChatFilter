package xyz.spicedev.spicecf.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;

import java.util.Locale;

import static org.bukkit.Bukkit.getServer;

public class PlayerSwearListener implements Listener {

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String message = event.getMessage();

        Player player = event.getPlayer();

        if (message.toLowerCase(Locale.ROOT).contains("fuck")) {
            event.setCancelled(true);
           //getServer().dispatchCommand(getServer().getConsoleSender(), "kick");
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("shit")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("nigga")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("nigger")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("bastard")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("fuckwit")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("dickhead")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("bitch")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("arsehole")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("asshole")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("cunt")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("tit")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("fanny")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("faggot")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("twat")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("pussy")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("cock")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("dick")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("motherfucker")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("wanker")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("bullshit")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dPlease do not use inappropriate language on this server."));
        }

        if (message.toLowerCase(Locale.ROOT).contains("ez")) {
            event.setCancelled(true);
            player.kickPlayer(translate("&cSpiceCF &7/ &dToxic behaviour can't be much fun now can it?"));
        }
    }
}
