package net.prosavage.yarpg.events;

import net.prosavage.yarpg.api.customevents.YEntitySpawnEvent;
import net.prosavage.yarpg.builders.entities.YEntities;
import org.bukkit.Bukkit;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {

    @EventHandler
    public void entitySpawn(EntitySpawnEvent event){
        if (event.getEntity() instanceof Mob){
            Mob entity = (Mob) event.getEntity();
            YEntitySpawnEvent yEntitySpawnEvent = new YEntitySpawnEvent(entity);
            Bukkit.getPluginManager().callEvent(yEntitySpawnEvent);
            if (!yEntitySpawnEvent.isCancelled()) {
                YEntities YEntities = new YEntities(entity, event.getEntity().getType().name())
                        .setMinimumHealth(20).setMaximumHealth(50).setMinimumExp(0).setMaximumExp(2)
                        .setMinimumProtection(1).setMaximumProtection(5).setMinimumDamage(1).setMaximumDamage(5)
                        .spawn(event.getLocation(), true);
            }
        }
    }

}
