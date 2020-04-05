package com.evak5.cratesx.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
    public String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String stripColor(String message) {
        return ChatColor.stripColor(message);
    }

    public void message( Player player, String message) { player.sendMessage(colorize(message)); }
    public void message(CommandSender sender, String message) { sender.sendMessage(colorize(message));}
}
