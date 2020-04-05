package com.evak5.cratesx.commands;

import com.evak5.cratesx.CratesX;
import com.evak5.cratesx.service.crate.Crate;
import com.evak5.cratesx.service.key.Key;
import com.evak5.cratesx.utilities.Utils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class XCommand implements CommandExecutor {

    private Configuration jConf = CratesX.getInstance().getConf().get();
    private Utils utils = CratesX.getInstance().getUtils();
    private CratesX cratesX = CratesX.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;
        if (!commandSender.hasPermission("cratesx.access")) {
            if (!jConf.getBoolean("settings.verbose.permission")) {
                utils.message(commandSender, "denied perm");
                return false;
            }
        }

        if (args.length == 0) {

        } else if (args.length == 1 && args[0].equalsIgnoreCase("test")) {
            utils.message(player, player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ());
            utils.message(player, player.getLocation().getX() + " " + player.getLocation().getY() + " " + player.getLocation().getZ());
            utils.message(player, "create new crate");
            Crate crate = cratesX.getTestCrate();

            utils.message(player, "Set crate name to test");
            crate.setCrateName("Test");
            utils.message(player, "set inventory slots to 27");
            crate.setInventorySlots(27);
            utils.message(player, "set location to players location");
            crate.setLocation(player.getLocation());
            utils.message(player, "set crate block type to chest");
            crate.setBlock(Material.CHEST);
            utils.message(player, "spawn chest in world at players location");
            player.getWorld().getBlockAt(player.getLocation()).setType(crate.getBlock());
            utils.message(player, "create and add to array list for lore");
            List<String> lore = new ArrayList<>();
            lore.add("MyLore");
            utils.message(player, "create key with name \"My Key\" and lore \"MyLore\", as a TRIPWIRE_HOOK with the amount of 1");
            Key key = new Key("My Key", lore, Material.TRIPWIRE_HOOK, 1);
            utils.message(player, "set the crate key to the created key");
            crate.setUserKey(key);
            utils.message(player, "add the crate key to users inventory");
            player.getInventory().addItem(key.getKeyItem());

            utils.message(player, crate.getLocation().getBlockX() + " " + crate.getLocation().getBlockY() + " " + crate.getLocation().getBlockZ());
            utils.message(player, crate.getLocation().getX() + " " + crate.getLocation().getY() + " " + crate.getLocation().getZ());
            utils.message(player, player.getLocation().getBlockX() + " " + player.getLocation().getBlockY() + " " + player.getLocation().getBlockZ());
            utils.message(player, player.getLocation().getX() + " " + player.getLocation().getY() + " " + player.getLocation().getZ());

        }

        return false;
    }
}
