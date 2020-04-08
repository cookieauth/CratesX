package dev.evak.cratesx.service.key;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Key {

    private ItemStack keyItem;
    private ItemMeta keyMeta;
    private String name;
    private List<String> lore;

    public Key(String name, List<String> lore, Material material, int amount) {
        this.name = name;
        this.lore = lore;
        this.keyItem = new ItemStack(material, amount);
    }

    public ItemStack getKeyItem() {
        return keyItem;
    }

    public void setKeyItem(ItemStack keyItem) {
        this.keyItem = keyItem;
    }

    public ItemMeta getKeyMeta() {
        return keyMeta;
    }

    public void setKeyMeta(ItemMeta keyMeta) {
        this.keyMeta = keyMeta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
