package net.prosavage.savagerpg.api.itemstacks;

import net.prosavage.savagerpg.api.keys.INamespacedKeys;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IArmor {

    public String getName(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.ARMOR_NAME, PersistentDataType.STRING);
        }
        return null;
    }

    public String getMaterial(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.ARMOR_MATERIAL, PersistentDataType.STRING);
        }
        return null;
    }

    public String getRarity(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.ARMOR_RARITY, PersistentDataType.STRING);
        }
        return null;
    }

    public double getChance(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_CHANCE, PersistentDataType.DOUBLE, 0.0);
    }

    public List<String> getItemBackgroundDescription(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return Arrays.asList(persistentDataContainer.get(INamespacedKeys.ARMOR_BACKGROUND_LORE, PersistentDataType.STRING).split("\\|\\|"));
        }
        return Collections.singletonList("");
    }

    public int getLevel(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_LEVEL, PersistentDataType.INTEGER, 0);
    }

    public double getMinimumProtection(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumProtection(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumHealth(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumHealth(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumRegen(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MINIMUM_REGEN, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumRegen(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_MAXIMUM_REGEN, PersistentDataType.DOUBLE, 0.0);
    }

    public int getGems(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_GEM, PersistentDataType.INTEGER, 0);
    }

    public int getScrolls(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_SCROLL, PersistentDataType.INTEGER, 0);
    }

    public boolean isSpawnedIn(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return false; }
        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
        return persistentDataContainer.getOrDefault(INamespacedKeys.ARMOR_IS_SPAWNED_IN, PersistentDataType.BYTE, (byte) 0) != 0;
    }

}
