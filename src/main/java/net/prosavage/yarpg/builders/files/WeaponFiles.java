package net.prosavage.yarpg.builders.files;

import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WeaponFiles {

    private String name;
    private String rarity;
    private File[] rarityFolders;
    private File weaponFile;
    private YamlConfiguration weaponConfiguration;

    public WeaponFiles(String rarity, String name){
        this.rarity = rarity;
        this.name = name;
        this.rarityFolders = new File(YaRPG.getInstance().getWeaponFolder()).listFiles();
        this.weaponFile = new File(YaRPG.getInstance().getWeaponFolder() + File.separator + this.rarity + File.separator + this.name + ".yml");
        this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
    }

    public WeaponFiles(String rarity){
        this.rarity = rarity;
        this.rarityFolders = new File(YaRPG.getInstance().getWeaponFolder()).listFiles();
    }

    public WeaponFiles setName(String name) {
        String path = YaRPG.getInstance().getWeaponFolder() + File.separator + this.rarity + File.separator + name + ".yml";
        boolean rename = getWeaponFile().renameTo(new File(path));
        if (rename){
            this.name = name;
            this.weaponFile = new File(path);
            this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
            try {
                weaponConfiguration.save(this.weaponFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public WeaponFiles setRarity(String rarity) {
        String path = YaRPG.getInstance().getWeaponFolder() + File.separator + rarity + File.separator + this.name + ".yml";
        File oldFolderFile = new File(YaRPG.getInstance().getWeaponFolder() + File.separator + this.rarity);
        File newFolderFile = new File(YaRPG.getInstance().getWeaponFolder() + File.separator + rarity);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getWeaponFile().renameTo(new File(path));
        net.prosavage.yarpg.YaRPG.getInstance().sendConsole(oldFolderFile.listFiles().length);
        if (oldFolderFile.listFiles().length == 0){
            boolean deletedFile = oldFolderFile.delete();
        }
        if (rename) {
            this.rarity = rarity;
            this.weaponFile = new File(path);
            this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
            try {
                weaponConfiguration.save(this.weaponFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public WeaponFiles setActualMaterial(String actualMaterial) {
        this.getWeaponConfiguration().set("weapon_actual_material", actualMaterial);
        return this;
    }

    public WeaponFiles setCosmeticMaterial(String cosmeticMaterial) {
        this.getWeaponConfiguration().set("weapon_cosmetic_material", cosmeticMaterial);
        return this;
    }

    public WeaponFiles setBackgroundLore(List<String> backgroundLore) {
        this.getWeaponConfiguration().set("weapon_background_lore", backgroundLore);
        return this;
    }

    public WeaponFiles setMinimumLevel(int minimumLevel) {
        this.getWeaponConfiguration().set("weapon_minimum_level", minimumLevel);
        return this;
    }

    public WeaponFiles setMaximumLevel(int maximumLevel) {
        this.getWeaponConfiguration().set("weapon_maximum_level", maximumLevel);
        return this;
    }

    public WeaponFiles setMinimumDamage(double minimumDamage) {
        this.getWeaponConfiguration().set("weapon_minimum_damage", minimumDamage);
        return this;
    }

    public WeaponFiles setMaximumDamage(double maximumDamage) {
        this.getWeaponConfiguration().set("weapon_maximum_damage", maximumDamage);
        return this;
    }

    public WeaponFiles setAttackCooldown(double attackCooldown) {
        this.getWeaponConfiguration().set("weapon_attack_cooldown", attackCooldown);
        return this;
    }

    public WeaponFiles setMinimumGem(int minimumGem) {
        this.getWeaponConfiguration().set("weapon_minimum_gem", minimumGem);
        return this;
    }

    public WeaponFiles setMaximumGem(int maximumGem) {
        this.getWeaponConfiguration().set("weapon_maximum_gem", maximumGem);
        return this;
    }

    public WeaponFiles setMinimumScroll(int minimumScroll) {
        this.getWeaponConfiguration().set("weapon_minimum_dcroll", minimumScroll);
        return this;
    }

    public WeaponFiles setMaximumScroll(int maximumScroll) {
        this.getWeaponConfiguration().set("weapon_maximum_scroll", maximumScroll);
        return this;
    }

    public WeaponFiles setAbilityName(String abilityName) {
        this.getWeaponConfiguration().set("weapon_ability_name", abilityName);
        return this;
    }

    public WeaponFiles setAbilityDescription(List<String> abilityDescription) {
        this.getWeaponConfiguration().set("weapon_ability_description", abilityDescription);
        return this;
    }

    public WeaponFiles setAbilityCastType(String abilityCastType) {
        this.getWeaponConfiguration().set("weapon_ability_cast_type", abilityCastType);
        return this;
    }

    public WeaponFiles setAbilityActionType(String abilityActionType) {
        this.getWeaponConfiguration().set("weapon_ability_action_type", abilityActionType);
        return this;
    }

    public WeaponFiles setAbilityCooldown(double abilityCooldown) {
        this.getWeaponConfiguration().set("weapon_ability_cooldown", abilityCooldown);
        return this;
    }

    public WeaponFiles setAbilityManaCost(double abilityManaCost) {
        this.getWeaponConfiguration().set("weapon_ability_mana_cost", abilityManaCost);
        return this;
    }

    public void setWeaponFile(File weaponFile) {
        this.weaponFile = weaponFile;
    }

    public void setWeaponConfiguration(YamlConfiguration weaponConfiguration) {
        this.weaponConfiguration = weaponConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity;
    }

    public String getActualMaterial() {
        return this.getWeaponConfiguration().getString("weapon_actual_material");
    }

    public String getCosmeticMaterial() {
        return this.getWeaponConfiguration().getString("weapon_cosmetic_material");
    }

    public List<String> getBackgroundLore() {
        return this.getWeaponConfiguration().getStringList("weapon_background_lore");
    }

    public int getMinimumLevel() {
        return this.getWeaponConfiguration().getInt("weapon_minimum_level");
    }

    public double getMaximumLevel() {
        return this.getWeaponConfiguration().getInt("weapon_maximum_level");
    }

    public double getMinimumDamage() {
        return this.getWeaponConfiguration().getDouble("weapon_minimum_damage");
    }

    public double getMaximumDamage() {
        return this.getWeaponConfiguration().getDouble("weapon_maximum_damage");
    }

    public double getAttackCooldown() {
        return this.getWeaponConfiguration().getDouble("weapon_attack_cooldown");
    }

    public int getMinimumGem() {
        return this.getWeaponConfiguration().getInt("weapon_minimum_gem");
    }

    public int getMaximumGem() {
        return this.getWeaponConfiguration().getInt("weapon_maximum_gem");
    }

    public int getMinimumScroll() {
        return this.getWeaponConfiguration().getInt("weapon_minimum_dcroll");
    }

    public int getMaximumScroll() {
        return this.getWeaponConfiguration().getInt("weapon_maximum_scroll");
    }

    public String getAbilityName() {
        return this.getWeaponConfiguration().getString("weapon_ability_name");
    }

    public List<String> getAbilityDescription() {
        return this.getWeaponConfiguration().getStringList("weapon_ability_description");
    }

    public String getAbilityCastType() {
        return this.getWeaponConfiguration().getString("weapon_ability_cast_type");
    }

    public String getAbilityActionType() {
        return this.getWeaponConfiguration().getString("weapon_ability_action_type");
    }

    public double getAbilityCooldown() {
        return this.getWeaponConfiguration().getDouble("weapon_ability_cooldown");
    }

    public double getAbilityManaCost() {
        return this.getWeaponConfiguration().getDouble("weapon_ability_mana_cost");
    }

    public File[] getRarityFolders() {
        return this.rarityFolders;
    }

    public File getWeaponFile() {
        return this.weaponFile;
    }

    public int getRarityFoldersAmount(){
        return this.rarityFolders.length;
    }

    public int getWeaponFilesAmount(){
        return Objects.requireNonNull(this.weaponFile.list()).length;
    }

    private YamlConfiguration getWeaponConfiguration() {
        return weaponConfiguration;
    }

    public void save(){
        try {
            getWeaponConfiguration().save(this.weaponFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getExample() {
        setActualMaterial("STONE_SWORD");
        setCosmeticMaterial("Example");
        setBackgroundLore(Arrays.asList("This is an example item", "forged from the depths of", "the plugin...."));
        setMinimumLevel(1);
        setMaximumLevel(100);
        setMinimumDamage(0.5);
        setMaximumDamage(1.25);
        setAttackCooldown(1.5);
        setMinimumGem(1);
        setMaximumGem(2);
        setMinimumScroll(1);
        setMaximumScroll(2);
        setAbilityName("Example");
        setAbilityDescription(Arrays.asList("This is a very good ability...", "Known to scare of everyone", "because of how powerful it is!"));
        setAbilityCastType("MOB");
        setAbilityActionType("RIGHT_CLICK");
        setAbilityCooldown(1.0);
        setAbilityManaCost(50.0);
        save();
    }

}
