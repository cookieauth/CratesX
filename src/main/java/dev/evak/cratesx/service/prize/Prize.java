package dev.evak.cratesx.service.prize;

import lombok.Data;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Data
public class Prize {

    private String previewName;
    private ItemStack previewItem;
    private int prizeAmount, previewAmount, prizeSlot, previewSlot, percentage, maxRange;
    private List<String> prizeLore, previewLore, itemList, commandList;
    private boolean previewGlowing;

    public Prize(ConfigurationSection section) {
        // Preview Settings
        ConfigurationSection preview = section.getConfigurationSection("preview");
        previewName = preview.getString("displayname");
        previewAmount = preview.getInt("amount");
        previewItem = new ItemStack(Material.valueOf(preview.getString("item")));
        previewGlowing  = preview.getBoolean("glowing");
        previewLore = preview.getStringList("lore");
        previewSlot = preview.getInt("slot");

        // Chance Settings
        percentage = section.getInt("chance.percentage");
        maxRange = section.getInt("chance.max-range");

        // Item Loading/Building

        // Command Loading

        for(String command : section.getStringList("commands")) {
            command = command.startsWith("/") ? command.replace("/", "") : command;
            commandList.add(command);
        }

    }
}
