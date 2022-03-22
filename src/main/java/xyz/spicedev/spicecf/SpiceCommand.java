package xyz.spicedev.spicecf;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpiceCommand implements CommandExecutor {

    // A quick note before you read this...
    // My translation for colour codes doesn't work on here for some reason so, I've resorted to the "hard way".
    // If you're new to java and Minecraft plugin development, good luck reading this.

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("scf") && sender instanceof Player) {
            Player player = (Player)sender;
            if (!player.hasPermission("scf.staff")) {
                player.sendMessage("");
                player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "You need the permission " + ChatColor.YELLOW + "'scf.staff' " + ChatColor.WHITE + "to execute this command.");
                player.sendMessage("");
                return false;
            }

            if (args.length == 0) {
                player.sendMessage("");
                player.sendMessage(ChatColor.RED + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "A plugin made by " + ChatColor.RED + "Spice Development");
                player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "Use the command " + ChatColor.YELLOW + "'/scf help' " + ChatColor.WHITE + "for a command list.");
                player.sendMessage(ChatColor.RED + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage("");
                return true;
            }

            if (args[0].equalsIgnoreCase("reload") && player.hasPermission("scf.staff")) {
                SpamHelper.enableSCF = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getBoolean("EnableSCF");
                SpamHelper.AntiSpamTimer = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getInt("SpamSeconds");
                Bukkit.getPluginManager().getPlugin("SpiceCF").reloadConfig();
                player.sendMessage("");
                player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "The config was successfully reloaded.");
                player.sendMessage("");
                return true;
            }

            if (args[0].equalsIgnoreCase("settimer") && player.hasPermission("scf.staff")) {
                if (args.length == 2 && isIntParsable(args[1])) {
                    Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().set("AntiSpamTimer", Integer.parseInt(args[1]));
                    Bukkit.getPluginManager().getPlugin("SpiceCF").saveConfig();
                    player.sendMessage("");
                    player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "The antispam timer was successfully set to: " + ChatColor.YELLOW + "'" + args[1] + "' " + ChatColor.WHITE + "seconds.");
                    player.sendMessage("");
                    return true;
                }

                player.sendMessage("");
                player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.YELLOW + "Oops, something went wrong. " + ChatColor.WHITE + "Please use the time in seconds with no decimals.");
                player.sendMessage("");
                return false;
            }

            if (args[0].equalsIgnoreCase("setEnable") && player.hasPermission("AntiSpam.Admin")) {
                boolean isEnabled = Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().getBoolean("EnableSCF");
                if (args.length != 2) {
                    player.sendMessage("");
                    player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.YELLOW + "Oops, something went wrong. " + ChatColor.WHITE + "Please only use " + ChatColor.GREEN + "'true' " + ChatColor.WHITE + "or " + ChatColor.RED + "'false'" + ChatColor.WHITE + ".");
                    player.sendMessage("");
                    return false;
                }


                if (isBoolParsable(args[1])) {
                    if (Boolean.parseBoolean(args[1]) == isEnabled) {
                        player.sendMessage("");
                        player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "Spice Chat Filter is already enabled.");
                        player.sendMessage("");
                        return false;
                    }

                    Bukkit.getPluginManager().getPlugin("SpiceCF").getConfig().set("EnableSCF", Boolean.parseBoolean(args[1]));
                    Bukkit.getPluginManager().getPlugin("SpiceCF").saveConfig();
                    player.sendMessage("");
                    player.sendMessage(ChatColor.RED + "SpiceCF " + ChatColor.GRAY + "/ " + ChatColor.WHITE + "You have set the EnableSCF value to: " + ChatColor.YELLOW + args[1]);
                    player.sendMessage("");
                    return true;

                }
            }

            if (args[0].equalsIgnoreCase("help") && player.hasPermission("scf.staff")) {
                player.sendMessage("");
                player.sendMessage(ChatColor.RED + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
                player.sendMessage(ChatColor.YELLOW + "/scf " + ChatColor.WHITE + "- List plugin info");
                player.sendMessage(ChatColor.YELLOW + "/scf reload " + ChatColor.WHITE + "- Reload the plugin");
                player.sendMessage(ChatColor.YELLOW + "/scf settime <seconds> " + ChatColor.WHITE + "- Change antispam timer");
                player.sendMessage(ChatColor.YELLOW + "/scf setenable <" + ChatColor.GREEN + "true " + ChatColor.YELLOW + "/ " + ChatColor.RED + "false" + ChatColor.YELLOW + "> " + ChatColor.WHITE + "- Enable or disable plugin");
                player.sendMessage(ChatColor.RED + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
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

