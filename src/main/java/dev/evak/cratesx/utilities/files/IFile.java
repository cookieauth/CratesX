package dev.evak.cratesx.utilities.files;

import dev.evak.cratesx.CratesX;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

@Data
public class IFile {

    @Getter(AccessLevel.PRIVATE) private static CratesX instance = CratesX.getInstance();

    private File file;
    private FileConfiguration config;
    private String folder, fileName;

    public IFile(File file, FileConfiguration fileConfiguration) {
        this.file = file;
        this.config = fileConfiguration;
    }

    /*public IFile(File file, FileConfiguration fileConfiguration, String folder) {
        this.fileName = file.getName();
        this.file = file;
        this.fileConfiguration = fileConfiguration;
        this.folder = folder;
    }*/

    public IFile(String fileName) {
        this.fileName = fileName;
        file = new File(instance.getDataFolder(), fileName);
        config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        validate();
    }

    public IFile(String fileName, String folder) {
        this.fileName = fileName;
        file = new File(instance.getDataFolder(), "/" + folder + "/" + fileName);
        config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        validate();
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            try {
                config.load(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public void validate() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (folder.isEmpty()) {
                instance.saveResource(file.getName() + ".yml", false);
            } else {
                instance.saveResource(getFolder() + "/" + file.getName() + ".yml", false);
            }
        }
        config.load(file);
    }

    public String getFileNoExtension() {
        return fileName.replaceAll(".yml", "");
    }


}
