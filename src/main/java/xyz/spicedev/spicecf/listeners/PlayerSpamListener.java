package xyz.spicedev.spicecf.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import xyz.spicedev.spicecf.ConfigHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PlayerSpamListener implements Listener {

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }


    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        if (ConfigHelper.enableSCF) {
            Player player = event.getPlayer();
            if (!player.isOp() || !player.hasPermission("scf.bypass.spam")) {
                int AntiSpamTimer = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getInt("AntiSpamTimer");
                if (!ConfigHelper.delay.containsKey(player)) {
                    ConfigHelper.delay.put(player, System.currentTimeMillis());
                } else if (System.currentTimeMillis() - (Long)ConfigHelper.delay.get(player) >= (long)(AntiSpamTimer * 1000)) {
                    ConfigHelper.delay.remove(player);
                } else {
                    player.sendMessage(translate("&cSpiceCF &7/ &fPlease wait &e" + AntiSpamTimer + " second(s) &fbefore sending another message."));
                    Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

                    while(true) {
                        Player p;
                        do {
                            if (!var5.hasNext()) {
                                event.setCancelled(true);
                                return;
                            }

                            p = (Player)var5.next();
                        } while(!p.isOp() && !p.hasPermission("scf.staff"));

                        p.sendMessage(translate("&cSpiceCF &7/ &fThe player &e'" + player.getDisplayName() + "' &fhas been flagged as a potential spammer."));
                    }
                }
            }
        }

    }
}