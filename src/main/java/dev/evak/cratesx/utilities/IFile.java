package dev.evak.cratesx.utilities;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class IFile {

    private File file;
    private FileConfiguration fileConfiguration;
    private String folder, fileName;
    private Plugin plugin;

    public IFile(File file, FileConfiguration fileConfiguration) {
        this.file = file;
        this.fileConfiguration = fileConfiguration;
    }

    public IFile(File file, FileConfiguration fileConfiguration, String folder) {
        this.fileName = file.getName();
        this.file = file;
        this.fileConfiguration = fileConfiguration;
        this.folder = folder;
    }

    public IFile(String fileName) {
        this.fileName = fileName;
        file = new File(plugin.getDataFolder(), fileName);
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        validate();
    }

    public IFile(String fileName, String folder) {
        this.fileName = fileName;
        file = new File(plugin.getDataFolder(), "/" + folder + "/" + fileName);
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        validate();
    }

    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            try {
                fileConfiguration.load(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (InvalidConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void validate() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (folder.isEmpty()) {
                plugin.saveResource(file.getName() + ".yml", false);
            } else {
                plugin.saveResource(getFolder() + "/" + file.getName() + ".yml", false);
            }
        }

        try {
            fileConfiguration.load(file);
            setFileConfiguration(fileConfiguration);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileConfiguration getConfig() {
        return fileConfiguration;
    }

    public void setFileConfiguration(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileNoExtension() {
        return fileName.replaceAll(".yml", "");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


}
