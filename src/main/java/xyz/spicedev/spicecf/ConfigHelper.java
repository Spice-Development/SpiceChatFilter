package xyz.spicedev.spicecf;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConfigHelper {
    public static HashMap<Player, Long> delay = new HashMap();

    // Come on this is pretty obvious, it's literally helping get the config info

    public static boolean enableSCF = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getBoolean("EnableSCF");
    static int AntiSpamTimer = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getInt("AntiSpamTimer");
}
