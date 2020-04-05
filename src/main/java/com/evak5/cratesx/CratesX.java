package com.evak5.cratesx;

import com.evak5.cratesx.commands.XCommand;
import com.evak5.cratesx.events.EPlayerInteract;
import com.evak5.cratesx.events.EPlayerJoin;
import com.evak5.cratesx.events.EPlayerQuit;
import com.evak5.cratesx.service.crate.Crate;
import com.evak5.cratesx.utilities.Utils;
import com.evak5.cratesx.utilities.IFile;
import org.bukkit.plugin.java.JavaPlugin;

public class CratesX extends JavaPlugin {

    private Utils utils;
    private static CratesX JCrate;

    private IFile mainConfig;

    private Crate testCrate;

    @Override
    public void onEnable() {

        JCrate = this;
        utils = new Utils();

        registerConfigs();
        registerCommand();
        registerEvent();
        registerDB();
        registerLiteDB();

        loadLocations();
        loadCrates();


        testCrate = new Crate();

    }

    @Override
    public void onDisable() {

    }

    private void loadLocations() {

    }

    private void loadCrates() {

    }

    private void registerCommand() {
        this.getCommand("cratesx").setExecutor(new XCommand());
    }

    private void registerEvent() {
        getServer().getPluginManager().registerEvents(new EPlayerInteract(), this);
        getServer().getPluginManager().registerEvents(new EPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new EPlayerQuit(), this);
    }

    private void registerConfigs() {
        mainConfig = new IFile(this, "config.yml");
        //messageConfig = new IFile(this, "messages.yml");
    }

    private void registerDB() {

    }

    private void registerLiteDB() {

    }

    public static CratesX getInstance() {
        return JCrate;
    }

    public void setInstance(CratesX cratesX) {
        JCrate = this;
    }

    public Utils getUtils() {
        return utils;
    }

    public IFile getConf() {
        return mainConfig;
    }

    public Crate getTestCrate() {
        return testCrate;
    }


}
