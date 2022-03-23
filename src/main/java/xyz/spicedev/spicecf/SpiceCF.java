package xyz.spicedev.spicecf;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.spicedev.spicecf.listeners.PlayerLinkListener;
import xyz.spicedev.spicecf.listeners.PlayerSpamListener;
import xyz.spicedev.spicecf.listeners.PlayerSwearListener;

public final class SpiceCF extends JavaPlugin implements Listener {
    public FileConfiguration globalConfig = this.getConfig();

    public static boolean toggled = true;

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("SpiceCF / Plugin enabled");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerSwearListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLinkListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerSpamListener(), this);

        if (this.getConfig().getName() != "config.yml") {
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }

        this.getCommand("scf").setExecutor(new SpiceCommand());
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("SpiceCF / Plugin disabled");
    }
    public static void registerEvents(Plugin plugin, Listener... listeners) {
        Listener[] var5 = listeners;
        int var4 = listeners.length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Listener listener = var5[var3];
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }

    }
}