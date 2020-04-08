package dev.evak.cratesx.commands;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.crate.Crate;
import dev.evak.cratesx.utilities.FileType;
import dev.evak.cratesx.utilities.Utils;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class XCommand implements CommandExecutor {
    private Utils utils = CratesX.getInstance().getUtils();
    private CratesX instance = CratesX.getInstance();
    private FileConfiguration config = instance.getFileHandler().get(FileType.CONFIG.getName()).getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!commandSender.hasPermission("cratesx.access")) {
            if (!config.getBoolean("settings.verbose.permission")) {
                utils.message(commandSender, "denied perm");
                return false;
            }
        }

        if (args.length == 0) {

        } else if (args.length == 2 && args[0].equalsIgnoreCase("set")) {
            if (!(commandSender instanceof Player)) {
                utils.message(commandSender, "&cYou must be a player to use this command!");
                return false;
            }
            Player player = (Player) commandSender;
            for (Crate crate : instance.getCrates()) {
                if (crate.getCrateName().equalsIgnoreCase(args[1])) {
                    Block targetCrate = player.getTargetBlock(null, 5);

                }
            }
        }

        return false;
    }
}
