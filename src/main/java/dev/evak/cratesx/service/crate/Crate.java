package dev.evak.cratesx.service.crate;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.key.Key;
import dev.evak.cratesx.service.preview.PreviewItem;
import dev.evak.cratesx.service.prize.Prize;

import dev.evak.cratesx.utilities.files.IFile;
import lombok.*;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
public class Crate {

    @Getter(AccessLevel.NONE)
    private static CratesX instance = CratesX.getInstance();

    private String crateName;
    private CrateType crateType;
    private Inventory inventory;
    private List<Prize> prizes;
    private Integer inventorySlots;
    private boolean isKnockback;
    private List<String> openCommands;
    private List<PreviewItem> prizeContentList;
    private PreviewItem previewItem;
    private Location location;
    private Key keyItem;

    @SneakyThrows
    public Crate(String crateName, FileConfiguration config) {
        this.crateName = crateName;
        this.openCommands = config.getStringList("Crate.open-commands");
        crateType = CrateType.valueOf(config.getString("Crate.type"));
        if (!config.isSet("Crate.preview-menu")) {
            config.set("Crate.preview-menu.enabled", true);
            config.set("Crate.preview-menu.glowing", true);
            config.set("Crate.preview-menu.slot", 0);
            config.set("Crate.preview-menu.item", "minecraft:barrier");
            config.set("Crate.preview-menu.name", "&cPlease edit the preview!");
            config.set("Crate.preview-menu.lore", Arrays.asList("Line 1", "Line 2"));

            IFile iFile = instance.getFileHandler().getIFile(crateName);
            iFile.setConfig(config);
            iFile.save();
        }
        previewItem = new PreviewItem(config.getConfigurationSection("Crate.preview-menu"));

        if (!config.isSet("Crate.key-settings")) {
            config.set("Crate.key-settings.glowing", true);
            config.set("Crate.key-settings.item", "minecraft:barrier");
            config.set("Crate.key-settings.name", "Error Building Key");
            config.set("Crate.key-settings.lore", Arrays.asList("Please edit this keys'", "Settings. We couldn't find any to load."));

            IFile iFile = instance.getFileHandler().getIFile(crateName);
            iFile.setConfig(config);
            iFile.save();
        }

        keyItem = new Key(crateName, config.getConfigurationSection("Crate.key-settings"));

        prizes = new ArrayList<>();

        for(String key: config.getConfigurationSection("Crate.prizes").getKeys(true)) {
            ConfigurationSection section = config.getConfigurationSection("Crate.prizes." + key);
            Prize temp = new Prize(section);
        }

    }



}
