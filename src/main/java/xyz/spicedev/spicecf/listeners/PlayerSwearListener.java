package xyz.spicedev.spicecf.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;
import xyz.spicedev.spicecf.SpiceCF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static org.bukkit.Bukkit.getServer;

public class PlayerSwearListener implements Listener {

    // This translates all the color codes into the normal &<number / letter>

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        if (!SpiceCF.toggled)
            return;

        // So if the chat filter is not toggled, it doesn't do anything

        String message = event.getMessage();
        Player player = event.getPlayer();

        // Yes I am making the whole process in a listener shut

        ArrayList<String> notgudwords = new ArrayList<String>();

        // All blocked words go here to all you people who want to use this in your own projects

        Collections.addAll(notgudwords, "fuck", "nigga", "shit", "fanny", "penis", "nigger", "ez", "bitch", "5170", "dortware", "dick", "dickhead", "fuk", "cunt", "redesky", "intent.store", "intent store", "rise client", "aether client", "flux client", "moon client", "novoline client", "rose client", "dortware client", "vape client", "vape v4", "vapev4", "vape lite", "bastard", "fuckwit", "arsehole", "asshole", "tit", "twat", "pussy", "cock", "motherfucker", "mother fucker", "wanker");
        for (String s : notgudwords) {
            if (message.toLowerCase().contains(s)) {

                // This is where the message gets cancelled and a message gets sent to the player

                event.setCancelled(true);
                player.sendMessage(translate("&cSpiceCF &7/ &fYour message &a'"+ message +"' &fwas flagged as not appropriate for this server, it was not sent."));
                break;
            }
        }
    }
}