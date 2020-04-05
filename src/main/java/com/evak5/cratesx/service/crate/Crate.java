package com.evak5.cratesx.service.crate;

import com.evak5.cratesx.CratesX;
import com.evak5.cratesx.service.key.Key;
import com.evak5.cratesx.service.prize.Prize;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.util.ArrayList;

public class Crate {

    private File file;
    private FileConfiguration fileConfiguration;
    private String fileName, crateName;
    private Location location;
    private Key userKey;
    private CrateType crateType;
    private CratesX cratesX = CratesX.getInstance();
    private Inventory inventory;
    private ArrayList<Prize> prizeArrayList;
    private int inventorySlots;
    private Material block;



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCrateName() {
        return crateName;
    }

    public void setCrateName(String crateName) {
        this.crateName = crateName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CrateType getCrateType() {
        return crateType;
    }

    public void setCrateType(CrateType crateType) {
        this.crateType = crateType;
    }

    public int getInventorySlots() {
        return inventorySlots;
    }

    public void setInventorySlots(int inventorySlots) {
        this.inventorySlots = inventorySlots;
    }

    public CratesX getCratesX() {
        return cratesX;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    public void setFileConfiguration(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    public Key getUserKey() {
        return userKey;
    }

    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }

    public ArrayList<Prize> getPrizeArrayList() {
        return prizeArrayList;
    }

    public void setPrizeArrayList(ArrayList<Prize> prizeArrayList) {
        this.prizeArrayList = prizeArrayList;
    }

    public Material getBlock() {
        return block;
    }

    public void setBlock(Material block) {
        this.block = block;
    }
}
