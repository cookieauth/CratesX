package dev.evak.cratesx.events.custom;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.crate.Crate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CrateOpenEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean isCancelled, skipAnimation;

    private Player player;
    private Crate crate;

    public CrateOpenEvent(Player player, Crate crate) {
        this.player = player;
        this.crate = crate;
        isCancelled = false;
        skipAnimation = false;
    }

    public CrateOpenEvent(Player player, Crate crate, boolean skipAnimation) {
        this.player = player;
        this.crate = crate;
        isCancelled = false;
        this.skipAnimation = skipAnimation;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public Boolean getSkipAnimation() {
        return skipAnimation;
    }

    public void setSkipAnimation(boolean skipAnimation) {
        this.skipAnimation = skipAnimation;
    }



}
