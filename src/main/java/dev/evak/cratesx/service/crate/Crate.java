package dev.evak.cratesx.service.crate;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.key.Key;
import dev.evak.cratesx.service.prize.Prize;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.util.ArrayList;

public class Crate {

    private FileConfiguration crateConfiguration;
    private String fileName, crateName, previewName;
    private Key key;
    private CrateType crateType;
    private CratesX cratesX = CratesX.getInstance();
    private Inventory inventory;
    private ArrayList<Prize> prizeArrayList;
    private Integer inventorySlots;

    public Crate(String crateName, String previewName, CrateType crateType, ArrayList<Prize> prizeArrayList, FileConfiguration crateConfiguration, Integer inventorySlots, Key userKey) {
        this.crateName = crateName;
        this.previewName = previewName;
        this.crateType = crateType;
        this.prizeArrayList = prizeArrayList;
        this.crateConfiguration = crateConfiguration;
        this.inventorySlots = inventorySlots > 53 ? 54 : inventorySlots;
        this.key = userKey;
    }

    public FileConfiguration getCrateConfiguration() {
        return crateConfiguration;
    }

    public void setCrateConfiguration(FileConfiguration crateConfiguration) {
        this.crateConfiguration = crateConfiguration;
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

    public String getPreviewName() {
        return previewName;
    }

    public void setPreviewName(String previewName) {
        this.previewName = previewName;
    }



    public void setCratesX(CratesX cratesX) {
        this.cratesX = cratesX;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setInventorySlots(Integer inventorySlots) {
        this.inventorySlots = inventorySlots;
    }

    public ArrayList<Prize> getPrizeArrayList() {
        return prizeArrayList;
    }

    public void setPrizeArrayList(ArrayList<Prize> prizeArrayList) {
        this.prizeArrayList = prizeArrayList;
    }
}
