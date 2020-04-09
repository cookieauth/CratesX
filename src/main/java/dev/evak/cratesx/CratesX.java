package dev.evak.cratesx;

import dev.evak.cratesx.service.crate.Crate;
import dev.evak.cratesx.service.crate.CrateHandler;
import dev.evak.cratesx.utilities.*;
import dev.evak.cratesx.utilities.files.FileHandler;
import dev.evak.cratesx.utilities.files.IFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class CratesX extends JavaPlugin {

    private CrateHandler crateHandler;
    private FileHandler fileHandler;

    private Utils utils;
    private static CratesX JCrate;
    
    private IFile mainConfig;

    public ArrayList<Crate> crates = new ArrayList<>();

    @Override
    public void onEnable() {

        JCrate = this;
        ServiceHandler serviceHandler = new ServiceHandler();
        crateHandler = new CrateHandler();
        fileHandler = new FileHandler();
        utils = new Utils();
        crateHandler.loadLocations();
        crateHandler.loadCrates();
        serviceHandler.registerConfigs(this);
        serviceHandler.registerCommand(this);
        serviceHandler.registerEvent(this);
        serviceHandler.registerDB(this);
        serviceHandler.registerLiteDB(this);
    }

    @Override
    public void onDisable() {

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

    public void setMainConfig(IFile mainConfig) {
        this.mainConfig = mainConfig;
    }

    public ArrayList<Crate> getCrates() {
        return crates;
    }

    public CrateHandler getCrateHandler() {
        return crateHandler;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }
}
