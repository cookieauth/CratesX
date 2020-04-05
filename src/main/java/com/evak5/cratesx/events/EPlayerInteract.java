package com.evak5.cratesx.events;

import com.evak5.cratesx.CratesX;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class EPlayerInteract implements Listener {


    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent interactEvent) {
        /*for (Crate crate : CratesX.getInstance().getCrateArrayList()) {
        }*/

        if (!interactEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            interactEvent.getPlayer().sendMessage("0");
            CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), interactEvent.getClickedBlock().getLocation().getBlockX() + " " + interactEvent.getClickedBlock().getLocation().getBlockY() + " " + interactEvent.getClickedBlock().getLocation().getBlockZ());
            return;
        }

        if (interactEvent.getClickedBlock() == null) {
            CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), "Null location");
            return;
        }

        if (!interactEvent.getClickedBlock().getLocation().equals(CratesX.getInstance().getTestCrate().getLocation())) {
            interactEvent.getPlayer().sendMessage("1");
            CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), interactEvent.getClickedBlock().getLocation().getBlockX() + " " + interactEvent.getClickedBlock().getLocation().getBlockY() + " " + interactEvent.getClickedBlock().getLocation().getBlockZ());
            return;
        }

        if (interactEvent.getItem() == null || interactEvent.getItem().getType().equals(Material.AIR)) {
            interactEvent.getPlayer().sendMessage("3");
            CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), interactEvent.getClickedBlock().getLocation().getBlockX() + " " + interactEvent.getClickedBlock().getLocation().getBlockY() + " " + interactEvent.getClickedBlock().getLocation().getBlockZ());
            return;
        }

        if (interactEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), interactEvent.getClickedBlock().getLocation().getBlockX() + " " + interactEvent.getClickedBlock().getLocation().getBlockY() + " " + interactEvent.getClickedBlock().getLocation().getBlockZ());
            interactEvent.getPlayer().sendMessage("4");
            if (interactEvent.getItem().equals(CratesX.getInstance().getTestCrate().getUserKey().getKeyItem())) {
                interactEvent.getPlayer().sendMessage("5");
                CratesX.getInstance().getUtils().message(interactEvent.getPlayer(), "it worked!");
            }
        }
    }
}
