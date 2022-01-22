package xyz.spicedev.spicecf;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.spicedev.spicecf.listeners.PlayerSwearListener;

public final class SpiceCF extends JavaPlugin implements Listener {

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("SpiceCF > Plugin enabled");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerSwearListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("SpiceCF > Plugin disabled");
    }
}