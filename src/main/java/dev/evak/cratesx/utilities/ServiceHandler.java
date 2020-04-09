package dev.evak.cratesx.utilities;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.commands.XCommand;
import dev.evak.cratesx.events.CrateInteractEvent;
import dev.evak.cratesx.events.JoinServerEvent;
import dev.evak.cratesx.events.QuitServerEvent;
import dev.evak.cratesx.utilities.files.IFile;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class ServiceHandler {

    // Transfer load/register methods here if possible from main class

    public void registerCommand(CratesX cratesX) {
        Objects.requireNonNull(cratesX.getCommand("cratesx")).setExecutor(new XCommand());
    }

    public void registerEvent(CratesX cratesX) {
        getServer().getPluginManager().registerEvents(new CrateInteractEvent(), cratesX);
        getServer().getPluginManager().registerEvents(new JoinServerEvent(), cratesX);
        getServer().getPluginManager().registerEvents(new QuitServerEvent(), cratesX);
    }

    public void registerConfigs(CratesX cratesX) {
        cratesX.setMainConfig(new IFile("config.yml"));
        //messageConfig = new IFile(this, "messages.yml");
    }

    public void registerDB(CratesX cratesX) {

    }

    public void registerLiteDB(CratesX cratesX) {

    }
}
