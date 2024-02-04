package xyz.spicedev.spicecf.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import xyz.spicedev.spicecf.ConfigHelper;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerSwearListener implements Listener {

    // This translates all the color codes into the normal &<number / letter>

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        if (ConfigHelper.enableSCF) {
            Player player = event.getPlayer();
            if (!player.hasPermission("scf.bypass.filter")) {

                // So if the chat filter is not toggled, it doesn't do anything

                String message = event.getMessage();
                player = event.getPlayer();

                // Yes I am making the whole process in a listener shut

                ArrayList<String> notgudwords = new ArrayList<String>();

                // All blocked words go here to all you people who want to use this in your own projects

                Collections.addAll(notgudwords, "fuck", "faggot", "fag", "nigga", "shet", "sheit", "shiet", "shit", "fanny", "penis", "nigger", "ez", "bitch", "dortware", "dick", "dickhead", "fuk", "cunt", "redesky", "intent store", "rise client", "aether client", "flux client", "moon client", "novoline client", "rose client", "dortware client", "vape client", "vape v4", "vapev4", "vape lite", "bastard", "fuckwit", "arsehole", "asshole", "tit", "twat", "pussy", "cock", "motherfucker", "mother fucker", "wanker", "niga", "fuk", "fuc", "stitch client", "primecraft", "prime craft", "ddos", "dos", "dox", "uterus", "testicles", "testies", "testicular", "whydidyoutypethis");
                for (String s : notgudwords) {
                    if (message.toLowerCase().contains(s)) {

                        // This is where the message gets cancelled and a message gets sent to the player

                        event.setCancelled(true);
                        player.sendMessage(translate("&cSpiceCF &7/ &fYour message &e'" + message + "' &fwas flagged as not appropriate for this server, it was not sent."));
                        break;
                    }
                }
            }
        }
    }
}
