package dev.evak.cratesx.events;

import dev.evak.cratesx.CratesX;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CrateInteractEvent implements Listener {

    CratesX instance = CratesX.getInstance();

    @EventHandler(ignoreCancelled = false)
    public void InteractEvent(PlayerInteractEvent event) {

        //CrateOpenEvent crateOpenEvent = new CrateOpenEvent(event.getPlayer(), instance.getCrateHandler().get);
        //Bukkit.getPluginManager().callEvent(crateOpenEvent);
        //if(!crateOpenEvent.isCancelled()){

        //}
    }

}
