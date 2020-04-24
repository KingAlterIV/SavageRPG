package net.prosavage.yarpg.api;

import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class YCreator {

    private Player player;

    public YCreator(Player player) {
        this.player = player;
    }

    public String getPersistentWeaponFileName() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponRarityName() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_RARITY,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_MATERIAL_TYPE,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentWeaponBackgroundMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_MATERIAL_TYPE,
                PersistentDataType.STRING, "null");
    }

    public Integer getPersistentWeaponLevelInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_LEVEL,
                PersistentDataType.INTEGER, 0);
    }

    public Double getPersistentWeaponMinimumDamageInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_MINIMUM_DAMAGE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentWeaponMaximumDamageInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_MAXIMUM_DAMAGE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentWeaponCooldownInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_ATTACK_COOLDOWN,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Integer getPersistentWeaponScrollAmountInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_SCROLL_AMOUNT,
                PersistentDataType.INTEGER, 0);
    }

    public Integer getPersistentWeaponGemAmountInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_GEM_AMOUNT,
                PersistentDataType.INTEGER, 0);
    }

    public String getPersistentWeaponAbilityNameInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_ABILITY_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreOneInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_1,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreTwoInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_2,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreThreeInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_3,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreFourInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_4,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreFiveInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_5,
                PersistentDataType.STRING, "null");
    }

    public Byte getPersistentWeaponGiveItem() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_GIVE_ITEM,
                PersistentDataType.BYTE, (byte) 0);
    }

    // Armors

    public String getPersistentWeaponPlayerUUID() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_WEAPON_PLAYER,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorFileName() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorRarityName() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_RARITY,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MATERIAL_TYPE,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentArmorBackgroundMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_MATERIAL_TYPE,
                PersistentDataType.STRING, "null");
    }

    public Integer getPersistentArmorLevelInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_LEVEL,
                PersistentDataType.INTEGER, 0);
    }

    public Double getPersistentArmorMinimumProtectionInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_PROTECTION,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentArmorMaximumProtectionInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_PROTECTION,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentArmorMinimumHealthInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_HEALTH,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentArmorMaximumHealthInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_HEALTH,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentArmorMinimumRegenInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_REGEN,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Double getPersistentArmorMaximumRegenInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_REGEN,
                PersistentDataType.DOUBLE, 0.0);
    }

    public Integer getPersistentArmorScrollAmountInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_SCROLL_AMOUNT,
                PersistentDataType.INTEGER, 0);
    }

    public Integer getPersistentArmorGemAmountInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_GEM_AMOUNT,
                PersistentDataType.INTEGER, 0);
    }

    public String getPersistentArmorBackgroundLoreOneInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_1,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreTwoInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_2,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreThreeInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_3,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreFourInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_4,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreFiveInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_5,
                PersistentDataType.STRING, "null");
    }

    public Byte getPersistentArmorGiveItemInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_GIVE_ITEM,
                PersistentDataType.BYTE, (byte) 0);
    }

    public String getPersistentArmorPlayerUUIDInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ARMOR_PLAYER,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentEntityTypeInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_TYPE,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentEntityRegionInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_REGION,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentEntityNameInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_NAME,
                PersistentDataType.STRING, "null");
    }

    public double getPersistentEntityHealthInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_HEALTH,
                PersistentDataType.DOUBLE, 0.0);
    }

    public int getPersistentEntityLevelInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_LEVEL,
                PersistentDataType.INTEGER, 0);
    }

    public double getPersistentEntityMinimumEXPInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_EXPERIENCE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public double getPersistentEntityMaximumEXPInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_EXPERIENCE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public double getPersistentEntityMinimumDamageInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_DAMAGE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public double getPersistentEntityMaximumDamageInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_DAMAGE,
                PersistentDataType.DOUBLE, 0.0);
    }

    public double getPersistentEntityMinimumProtectionInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_PROTECTION,
                PersistentDataType.DOUBLE, 0.0);
    }

    public double getPersistentEntityMaximumProtectionInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_PROTECTION,
                PersistentDataType.DOUBLE, 0.0);
    }

    public String getPersistentEntityHeldItemInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_HELD_ITEM,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentEntityHelmetInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_HELMET,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentEntityChestplateInput() {
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_CHESTPLATE,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentEntityLeggingsInput(){
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_LEGGINGS,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentEntityBootsInput(){
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_BOOTS,
                PersistentDataType.STRING, "AIR");
    }

    public byte getPersistentEntitySpawnInput(){
        return this.player.getPersistentDataContainer().getOrDefault(YNamespacedKeys.CREATOR_ENTITY_SPAWN_ENTITY,
                PersistentDataType.BYTE, (byte) 0);
    }
}

