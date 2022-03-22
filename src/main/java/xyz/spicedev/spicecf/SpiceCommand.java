package xyz.spicedev.spicecf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpiceCommand implements CommandExecutor {

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("scf") && sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("scf.staff")) {
                player.sendMessage("");
                player.sendMessage("&cSpiceCF &7/ &fYou need the permission &e'scf.staff' &fto execute this command.");
                player.sendMessage("");
                return false;
            }


            if (args.length == 0) {
                player.sendMessage("");
                player.sendMessage("&c- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage("&cSpiceCF &7/ &fA plugin made by &eSpice Development");
                player.sendMessage("&cSpiceCF &7/ &fUse the command &e'/scf help' &ffor a command list.");
                player.sendMessage("&c- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage("");
                return true;
            }

            if (args[0].equalsIgnoreCase("reload") && player.hasPermission("scf.staff")) {
                SpamHelper.enableSCF = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getBoolean("EnableSCF");
                SpamHelper.AntiSpamTimer = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getInt("SpamSeconds");
                Bukkit.getPluginManager().getPlugin("SpiceCF").reloadConfig();
                player.sendMessage("");
                player.sendMessage("&cSpiceCF &7/ &fThe config was successfully reloaded.");
                player.sendMessage("");
                return true;
            }

            if (args[0].equalsIgnoreCase("settimer") && player.hasPermission("scf.staff")) {
                if (args.length == 2 && isIntParsable(args[1])) {
                    Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().set("AntiSpamTimer", Integer.parseInt(args[1]));
                    Bukkit.getPluginManager().getPlugin("SpiceCF").saveConfig();
                    player.sendMessage("");
                    player.sendMessage("&cSpiceCF &7/ &fThe antispam timer was successfully set to: &e'" + args[1] + "' &fseconds.");
                    player.sendMessage("");
                    return true;
                }

                player.sendMessage("");
                player.sendMessage("&cSpiceCF &7/ &eOops, something went wrong. &fPlease use the time in seconds with no decimals.");
                player.sendMessage("");
                return false;
            }

            if (args[0].equalsIgnoreCase("setEnable") && player.hasPermission("AntiSpam.Admin")) {
                boolean isEnabled = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getBoolean("EnableSCF");
                if (args.length != 2) {
                    player.sendMessage("");
                    player.sendMessage("&cSpiceCF &7/ &eOops, something went wrong. &fPlease only use &a'true' &for &c'false'&f.");
                    player.sendMessage("");
                    return false;
                }


                if (isBoolParsable(args[1])) {
                    if (Boolean.parseBoolean(args[1]) == isEnabled) {
                        player.sendMessage("");
                        player.sendMessage("&cSpiceCF &7/ &fSpice Chat Filter is already enabled.");
                        player.sendMessage("");
                        return false;
                    }

                    Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().set("EnableSCF", Boolean.parseBoolean(args[1]));
                    Bukkit.getPluginManager().getPlugin("SpiceCF").saveConfig();
                    player.sendMessage("");
                    player.sendMessage("&cSpiceCF &7/ &fYou have set the EnableSCF value to: &e" + args[1]);
                    player.sendMessage("");
                    return true;

                }
            }

            if (args[0].equalsIgnoreCase("help") && player.hasPermission("scf.staff")) {
                player.sendMessage("");
                player.sendMessage("&c- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage("&e/scf &f- List plugin info");
                player.sendMessage("&e/scf reload &f- Reload the plugin");
                player.sendMessage("&e/scf settime <seconds> &f- Change antispam timer");
                player.sendMessage("&e/scf setenable <&atrue &e/ &cfalse&e> &f- Enable or disable plugin");
                player.sendMessage("&c- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage("");
                return true;
            }
        }

        return false;
    }

    public static boolean isIntParsable(String input) {
        boolean parsable = true;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException var3) {
            parsable = false;
        }

        return parsable;
    }

    public static boolean isBoolParsable(String input) {
        boolean parsable = true;

        try {
            Boolean.parseBoolean(input);
        } catch (Exception var3) {
            parsable = false;
        }

        return parsable;
    }
}

