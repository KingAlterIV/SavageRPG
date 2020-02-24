package net.prosavage.savagerpg.api.entities;

import net.prosavage.savagerpg.api.keys.INamespacedKeys;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class IEntity {

    public String getName(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, entity.getType().toString());
    }

    public int getLevel(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public String getRegion(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_REGION, PersistentDataType.STRING, "null");
    }

    public double getHealth(Entity entity){
        if (entity instanceof Damageable){
            Damageable damageable = (Damageable) entity;
            return damageable.getHealth();
        }
        return 20.0;
    }

    public double getMinimumHealth(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumHealth(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 1.0);
    }

    public double getEXP(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_EXP, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumEXP(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MINIMUM_EXP, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumEXP(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MAXIMUM_EXP, PersistentDataType.DOUBLE, 1.0);
    }

    public double getDamage(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumDamage(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumDamage(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getProtection(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumProtection(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumProtection(Entity entity) {
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

}


