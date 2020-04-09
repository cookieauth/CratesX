package dev.evak.cratesx.service.key;

import de.tr7zw.changeme.nbtapi.*;
import dev.evak.cratesx.CratesX;
import lombok.*;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Key {

    @Getter(AccessLevel.NONE) private static CratesX cratesX = CratesX.getInstance();


    @NonNull private String itemName, crateName;
    @NonNull private ItemStack keyItem;

    @Setter(AccessLevel.NONE) private List<String> lore = new ArrayList<>();
    private boolean isGlowing = false;

    public Key(String crateName, ConfigurationSection section) {
        itemName = section.getString("name");
        isGlowing= section.getBoolean("glowing");
        lore = section.getStringList("lore");
        keyItem = new ItemStack(Material.valueOf(section.getString("item")));
        injectNBT();
    }

    public void appendToLore(String line) {
        lore.add(line);
    }

    public void injectNBT() {
        final NBTItem nbt = new NBTItem(getKeyItem());
        nbt.setString("keyName", getCrateName());
        setKeyItem(nbt.getItem());
    }



}
