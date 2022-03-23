package xyz.spicedev.spicecf.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import xyz.spicedev.spicecf.ConfigHelper;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerLinkListener implements Listener {

    // This translates all the color codes into the normal &<number / letter>

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        if (ConfigHelper.enableSCF) {
            Player player = event.getPlayer();
            if (!player.hasPermission("scf.bypass.links")) {

                // So if the chat filter is not toggled, it doesn't do anything

                String message = event.getMessage();
                player = event.getPlayer();

                // Yes I am making the whole process in a listener shut

                ArrayList<String> notgudwords = new ArrayList<String>();

                // All blocked words go here to all you people who want to use this in your own projects

                Collections.addAll(notgudwords, ".com", ".net", ".org", ".xyz", ".live", ".store", ".host", ".web", ".monday", ".tuesday", ".wednesday", ".thursday", ".friday", ".saturday", ".sunday", ".cool", ".pog", ".games", ".pl", ".ml", ".cf", ".uk", ".gov", ".co", ".hub", ".ua", ".be", ".ro", ".edu", ".get", ".help", ".info");
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