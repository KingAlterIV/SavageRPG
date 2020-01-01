package net.prosavage.illyriarpg.api.itemstacks;

import net.prosavage.illyriarpg.api.keys.INamespacedKeys;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IWeapon {

    public String getName(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_NAME, PersistentDataType.STRING);
        }
        return null;
    }

    public String getMaterial(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_MATERIAL, PersistentDataType.STRING);
        }
        return null;
    }

    public String getRarity(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_RARITY, PersistentDataType.STRING);
        }
        return null;
    }

    public double getChance(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
<<<<<<< HEAD
            return persistentDataContainer.get(INamespacedKeys.ITEM_CHANCE, PersistentDataType.DOUBLE);
=======
            if (persistentDataContainer.has(INamespacedKeys.WEAPON_CHANCE, PersistentDataType.DOUBLE)) {
                return persistentDataContainer.get(INamespacedKeys.WEAPON_CHANCE, PersistentDataType.DOUBLE);
            }
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        }
        return 0.0;
    }

    public List<String> getLore(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
<<<<<<< HEAD
            return Arrays.asList(persistentDataContainer.get(INamespacedKeys.ITEM_LORE, PersistentDataType.STRING).split("||"));
=======
            return Arrays.asList(persistentDataContainer.get(INamespacedKeys.WEAPON_BACKGROUND_LORE, PersistentDataType.STRING).split("\\|\\|"));
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        }
        return Collections.singletonList("");
    }

    public int getLevel(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_LEVEL, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public double getMaximumDamage(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
<<<<<<< HEAD
            return persistentDataContainer.get(INamespacedKeys.ITEM_MAX_DAMAGE, PersistentDataType.DOUBLE);
=======
            return persistentDataContainer.get(INamespacedKeys.WEAPON_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE);
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        }
        return 0.0;
    }

    public double getMinimumDamage(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
<<<<<<< HEAD
            return persistentDataContainer.get(INamespacedKeys.ITEM_MIN_DAMAGE, PersistentDataType.DOUBLE);
=======
            return persistentDataContainer.get(INamespacedKeys.WEAPON_MINIMUM_DAMAGE, PersistentDataType.DOUBLE);
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        }
        return 0.0;
    }

    public int getGems(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_GEM, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public int getScrolls(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_SCROLL, PersistentDataType.INTEGER);
        }
        return 0;
    }

    public double getAbilityCooldown(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_ABIILTY_COOLDOWN, PersistentDataType.DOUBLE);
        }
        return 0.0;
    }

    public String getAbilityName(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_ABIILTY_NAME, PersistentDataType.STRING);
        }
        return null;
    }

    public List<String> getAbilityDescription(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
<<<<<<< HEAD
            return Arrays.asList(Objects.requireNonNull(persistentDataContainer.get(INamespacedKeys.ITEM_ABIILTY_DESCRIPTION, PersistentDataType.STRING)).split("||"));
=======
            return Arrays.asList(Objects.requireNonNull(persistentDataContainer.get(INamespacedKeys.WEAPON_ABIILTY_DESCRIPTION, PersistentDataType.STRING)).split("\\|\\|"));
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        }
        return Collections.singletonList("");
    }

    public double getAbilityManaCost(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return -1.0; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.WEAPON_ABIILTY_MANA_COST, PersistentDataType.DOUBLE);
        }
        return 0.0;
    }

<<<<<<< HEAD
    public String getAbilityActionType(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return null; }
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            return persistentDataContainer.get(INamespacedKeys.ITEM_ABIILTY_ACTION_TYPE, PersistentDataType.STRING);
        }
        return null;
=======
    public boolean isSpawnedIn(ItemStack itemStack) {
        if (itemStack.getType() == Material.AIR){ return false; }
        byte isSpawnedIn = 0;
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            PersistentDataContainer persistentDataContainer = meta.getPersistentDataContainer();
            isSpawnedIn = persistentDataContainer.get(INamespacedKeys.WEAPON_IS_SPAWNED_IN, PersistentDataType.BYTE);
        }
        return isSpawnedIn != 0;
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
    }
}
