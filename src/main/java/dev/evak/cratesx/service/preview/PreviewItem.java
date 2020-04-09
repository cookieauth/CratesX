package dev.evak.cratesx.service.preview;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@AllArgsConstructor
@Data
public class PreviewItem {

     private String itemName;
     private boolean isEnabled, isGlowing;
     private int slot;
     private ItemStack previewItem;
     private List<String> lore;

     public PreviewItem(ConfigurationSection section) {
          itemName = section.getString("name");
          isEnabled = section.getBoolean("enabled");
          isGlowing= section.getBoolean("glowing");
          slot = section.getInt("slot");
          previewItem = new ItemStack(Material.valueOf(section.getString("item")));
          lore = section.getStringList("lore");
     }

}
