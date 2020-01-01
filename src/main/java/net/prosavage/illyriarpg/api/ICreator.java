package net.prosavage.illyriarpg.api;

import net.prosavage.illyriarpg.api.keys.INamespacedKeys;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class ICreator {

    private Player player;

    public ICreator(Player player){
        this.player = player;
    }

<<<<<<< HEAD
    public String getPersistentFileName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_WEAPON_FILE_NAME, PersistentDataType.STRING, "null");
    }

    public String getPersistentRarityName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_RARITY, PersistentDataType.STRING, "null");
    }

    public String getPersistentMaterialType(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_MATERIAL_TYPE, PersistentDataType.STRING, "AIR");
    }

    public String getPersistentBackgroundMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_MATERIAL_TYPE, PersistentDataType.STRING, "null");
    }

    public Integer getPersistentLevelInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_LEVEL, PersistentDataType.INTEGER, -1);
    }

    public Double getPersistentMinimumDamageInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentMaximumDamageInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentCooldownInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ATTACK_COOLDOWN, PersistentDataType.DOUBLE, -1.0);
    }

    public Integer getPersistentScrollAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_SCROLL_AMOUNT, PersistentDataType.INTEGER, -1);
    }

    public Integer getPersistentGemAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_GEM_AMOUNT, PersistentDataType.INTEGER, -1);
    }

    public String getPersistentAbilityNameInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_NAME, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityCastTypeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_CAST_TYPE, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityActionTypeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_ACTION_TYPE, PersistentDataType.STRING, "null");
    }

    public Double getPersistentAbilityCooldownInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_COOLDOWN, PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentAbilityManaCostInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_MANA_COST, PersistentDataType.DOUBLE, -1.0);
    }

    public String getPersistentAbilityDescriptionInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityDescriptionOneInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION_1, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityDescriptionTwoInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION_2, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityDescriptionThreeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION_3, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityDescriptionFourInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION_4, PersistentDataType.STRING, "null");
    }

    public String getPersistentAbilityDescriptionFiveInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_ABILITY_DESCRIPTION_5, PersistentDataType.STRING, "null");
    }

    public String getPersistentBackgroundLoreOneInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_LORE_1, PersistentDataType.STRING, "null");
    }

    public String getPersistentBackgroundLoreTwoInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_LORE_2, PersistentDataType.STRING, "null");
    }

    public String getPersistentBackgroundLoreThreeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_LORE_3, PersistentDataType.STRING, "null");
    }

    public String getPersistentBackgroundLoreFourInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_LORE_4, PersistentDataType.STRING, "null");
    }

    public String getPersistentBackgroundLoreFiveInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_BACKGROUND_LORE_5, PersistentDataType.STRING, "null");
    }

    public Byte getPersistentGiveItem(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_GIVE_ITEM, PersistentDataType.BYTE, (byte)0);
    }

    public String getPersistentPlayerUUID(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ITEM_PLAYER, PersistentDataType.STRING, "null");
=======
    public String getPersistentWeaponFileName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponRarityName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_RARITY,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponMaterialType(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_MATERIAL_TYPE,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentWeaponBackgroundMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_MATERIAL_TYPE,
                PersistentDataType.STRING, "null");
    }

    public Integer getPersistentWeaponLevelInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_LEVEL,
                PersistentDataType.INTEGER, -1);
    }

    public Double getPersistentWeaponMinimumDamageInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_MINIMUM_DAMAGE,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentWeaponMaximumDamageInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_MAXIMUM_DAMAGE,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentWeaponCooldownInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_ATTACK_COOLDOWN,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Integer getPersistentWeaponScrollAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_SCROLL_AMOUNT,
                PersistentDataType.INTEGER, -1);
    }

    public Integer getPersistentWeaponGemAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_GEM_AMOUNT,
                PersistentDataType.INTEGER, -1);
    }

    public String getPersistentWeaponAbilityNameInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_ABILITY_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreOneInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_1,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreTwoInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_2,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreThreeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_3,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreFourInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_4,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentWeaponBackgroundLoreFiveInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_5,
                PersistentDataType.STRING, "null");
    }

    public Byte getPersistentWeaponGiveItem(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_GIVE_ITEM,
                PersistentDataType.BYTE, (byte)0);
    }

    // Armors

    public String getPersistentWeaponPlayerUUID(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_WEAPON_PLAYER,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorFileName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_NAME,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorRarityName() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_RARITY,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorMaterialType(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MATERIAL_TYPE,
                PersistentDataType.STRING, "AIR");
    }

    public String getPersistentArmorBackgroundMaterialType() {
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_MATERIAL_TYPE,
                PersistentDataType.STRING, "null");
    }

    public Integer getPersistentArmorLevelInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_LEVEL,
                PersistentDataType.INTEGER, -1);
    }

    public Double getPersistentArmorMinimumProtectionInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MINIMUM_PROTECTION,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentArmorMaximumProtectionInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MAXIMUM_PROTECTION,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentArmorMinimumHealthInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MINIMUM_HEALTH,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentArmorMaximumHealthInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MAXIMUM_HEALTH,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentArmorMinimumRegenInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MINIMUM_REGEN,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Double getPersistentArmorMaximumRegenInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_MAXIMUM_REGEN,
                PersistentDataType.DOUBLE, -1.0);
    }

    public Integer getPersistentArmorScrollAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_SCROLL_AMOUNT,
                PersistentDataType.INTEGER, -1);
    }

    public Integer getPersistentArmorGemAmountInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_GEM_AMOUNT,
                PersistentDataType.INTEGER, -1);
    }

    public String getPersistentArmorBackgroundLoreOneInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_1,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreTwoInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_2,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreThreeInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_3,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreFourInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_4,
                PersistentDataType.STRING, "null");
    }

    public String getPersistentArmorBackgroundLoreFiveInput(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_5,
                PersistentDataType.STRING, "null");
    }

    public Byte getPersistentArmorGiveItem(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_GIVE_ITEM,
                PersistentDataType.BYTE, (byte)0);
    }

    public String getPersistentArmorPlayerUUID(){
        return this.player.getPersistentDataContainer().getOrDefault(INamespacedKeys.CREATOR_ARMOR_PLAYER,
                PersistentDataType.STRING, "null");
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
    }

}
