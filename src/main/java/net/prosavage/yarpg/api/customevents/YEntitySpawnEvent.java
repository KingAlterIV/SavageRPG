package net.prosavage.yarpg.api.customevents;

import org.bukkit.entity.Mob;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class YEntitySpawnEvent extends Event implements Cancellable {

    private Mob entity;
    private boolean isCancelled;

    public YEntitySpawnEvent(Mob entity) {
        this.entity = entity;
        this.isCancelled = false;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Mob getEntity() {
        return this.entity;
    }

}