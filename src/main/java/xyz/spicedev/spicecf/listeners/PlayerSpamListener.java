package xyz.spicedev.spicecf.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.spicedev.spicecf.SpamHelper;
import java.util.Iterator;

public class PlayerSpamListener implements Listener {
    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent event) {
        if (SpamHelper.enableSCF) {
            Player player = event.getPlayer();
            if (!player.hasPermission("scf.staff")) {

                // If it is enabled and the player hasn't got the exempt permission

                int AntiSpamTimer = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getInt("AntiSpamTimer");
                if (!SpamHelper.delay.containsKey(player)) {
                    SpamHelper.delay.put(player, System.currentTimeMillis());
                } else if (System.currentTimeMillis() - (Long)SpamHelper.delay.get(player) >= (long)(AntiSpamTimer * 1000)) {
                    SpamHelper.delay.remove(player);
                } else {
                    player.sendMessage(translate("&cSpiceCF &7/ &fPlease wait &e'"+ AntiSpamTimer +"' &fbefore sending another message."));
                    Iterator var5 = Bukkit.getServer().getOnlinePlayers().iterator();

                    // If the player sends a message, it puts them on a timer for however long the user of the plugin specifies in the config.yml

                    while(true) {
                        Player p;
                        do {
                            if (!var5.hasNext()) {
                                event.setCancelled(true);
                                return;
                            }

                            // While the player is on a timer / delay it will prevent any further messages being sent

                            p = (Player)var5.next();
                        } while(!p.isOp() && !p.hasPermission("scf.staff"));

                        player.sendMessage(translate("&cSpiceCF &7/ &fThe player &e'"+ player +"' &fwas flagged for spamming."));
                        break;

                        // It will notify any staff online with the permission or OP that the player who is trying to spam has been prevented from doing so

                    }
                }
            }
        }

    }
}
