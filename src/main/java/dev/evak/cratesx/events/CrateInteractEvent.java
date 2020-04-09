package dev.evak.cratesx.events;

import dev.evak.cratesx.CratesX;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CrateInteractEvent implements Listener {

    @Getter(AccessLevel.PRIVATE) private static CratesX instance = CratesX.getInstance();

    @EventHandler
    public void InteractEvent(PlayerInteractEvent event) {

        Location loc = event.getClickedBlock().getLocation();
        //loc.distance()

        //CrateOpenEvent crateOpenEvent = new CrateOpenEvent(event.getPlayer(), instance.getCrateHandler().get);
        //Bukkit.getPluginManager().callEvent(crateOpenEvent);
        //if(!crateOpenEvent.isCancelled()){

        //}
    }

}
