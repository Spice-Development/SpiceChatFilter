package xyz.spicedev.spicecf;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

        System.out.println("SpiceCF / Plugin enabled");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerSwearListener(), this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Toggles the chat filter (/tscf)
        if (command.getName().equalsIgnoreCase("tscf")) {

            if (sender instanceof Player) {
                if (sender.hasPermission("scf.toggle")) {
                    Player player = (Player) sender;
                    player.sendMessage("&cSpiceCF &7/ &dSorry, this command is not yet available &e(WIP)");
                }

            }

        }
        return true;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("SpiceCF / Plugin disabled");
    }

}