package net.prosavage.yarpg.api.entities;

import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class YEntity {

    Entity entity;
    PersistentDataContainer persistentDataContainer;

    public YEntity(Entity entity) {
        this.entity = entity;
        this.persistentDataContainer = entity.getPersistentDataContainer();
    }

    public String getName(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, entity.getType().toString());
    }

    public int getLevel(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public String getRegion(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_REGION, PersistentDataType.STRING, "null");
    }

    public double getHealth(){
        if (entity instanceof Damageable){
            Damageable damageable = (Damageable) entity;
            return damageable.getHealth();
        }
        return 20.0;
    }

    public double getMinimumHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 1.0);
    }

    public double getEXP(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumEXP(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumEXP(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumProtection(Entity entity) {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

}


