package net.prosavage.savagerpg.builders.files;

import net.prosavage.savagerpg.SavageRPG;
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
        this.rarityFolders = new File(SavageRPG.getInstance().getWeaponFolder()).listFiles();
        this.weaponFile = new File(SavageRPG.getInstance().getWeaponFolder() + File.separator + this.rarity + File.separator + this.name + ".yml");
        this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
    }

    public WeaponFiles(String rarity){
        this.rarity = rarity;
        this.rarityFolders = new File(SavageRPG.getInstance().getWeaponFolder()).listFiles();
    }

    public WeaponFiles setName(String name) {
        String path = SavageRPG.getInstance().getWeaponFolder() + File.separator + this.rarity + File.separator + name + ".yml";
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
        String path = SavageRPG.getInstance().getWeaponFolder() + File.separator + rarity + File.separator + this.name + ".yml";
        File oldFolderFile = new File(SavageRPG.getInstance().getWeaponFolder() + File.separator + this.rarity);
        File newFolderFile = new File(SavageRPG.getInstance().getWeaponFolder() + File.separator + rarity);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getWeaponFile().renameTo(new File(path));
        net.prosavage.savagerpg.SavageRPG.getInstance().sendConsole(oldFolderFile.listFiles().length);
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
        this.getWeaponConfiguration().set("weaponActualMaterial", actualMaterial);
        return this;
    }

    public WeaponFiles setCosmeticMaterial(String cosmeticMaterial) {
        this.getWeaponConfiguration().set("weaponCosmeticMaterial", cosmeticMaterial);
        return this;
    }

    public WeaponFiles setBackgroundLore(List<String> backgroundLore) {
        this.getWeaponConfiguration().set("weaponBackgroundLore", backgroundLore);
        return this;
    }

    public WeaponFiles setMinimumLevel(int minimumLevel) {
        this.getWeaponConfiguration().set("weaponMinimumLevel", minimumLevel);
        return this;
    }

    public WeaponFiles setMaximumLevel(int maximumLevel) {
        this.getWeaponConfiguration().set("weaponMaximumLevel", maximumLevel);
        return this;
    }

    public WeaponFiles setMinimumDamage(double minimumDamage) {
        this.getWeaponConfiguration().set("weaponMinimumDamage", minimumDamage);
        return this;
    }

    public WeaponFiles setMaximumDamage(double maximumDamage) {
        this.getWeaponConfiguration().set("weaponMaximumDamage", maximumDamage);
        return this;
    }

    public WeaponFiles setAttackCooldown(double attackCooldown) {
        this.getWeaponConfiguration().set("weaponAttackCooldown", attackCooldown);
        return this;
    }

    public WeaponFiles setMinimumGem(int minimumGem) {
        this.getWeaponConfiguration().set("weaponMinimumGem", minimumGem);
        return this;
    }

    public WeaponFiles setMaximumGem(int maximumGem) {
        this.getWeaponConfiguration().set("weaponMaximumGem", maximumGem);
        return this;
    }

    public WeaponFiles setMinimumScroll(int minimumScroll) {
        this.getWeaponConfiguration().set("weaponMinimumScroll", minimumScroll);
        return this;
    }

    public WeaponFiles setMaximumScroll(int maximumScroll) {
        this.getWeaponConfiguration().set("weaponMaximumScroll", maximumScroll);
        return this;
    }

    public WeaponFiles setAbilityName(String abilityName) {
        this.getWeaponConfiguration().set("weaponAbilityName", abilityName);
        return this;
    }

    public WeaponFiles setAbilityDescription(List<String> abilityDescription) {
        this.getWeaponConfiguration().set("weaponAbilityDescription", abilityDescription);
        return this;
    }

    public WeaponFiles setAbilityCastType(String abilityCastType) {
        this.getWeaponConfiguration().set("weaponAbilityCastType", abilityCastType);
        return this;
    }

    public WeaponFiles setAbilityActionType(String abilityActionType) {
        this.getWeaponConfiguration().set("weaponAbilityActionType", abilityActionType);
        return this;
    }

    public WeaponFiles setAbilityCooldown(double abilityCooldown) {
        this.getWeaponConfiguration().set("weaponAbilityCooldown", abilityCooldown);
        return this;
    }

    public WeaponFiles setAbilityManaCost(double abilityManaCost) {
        this.getWeaponConfiguration().set("weaponAbilityManaCost", abilityManaCost);
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
        return this.getWeaponConfiguration().getString("weaponActualMaterial");
    }

    public String getCosmeticMaterial() {
        return this.getWeaponConfiguration().getString("weaponCosmeticMaterial");
    }

    public List<String> getBackgroundLore() {
        return this.getWeaponConfiguration().getStringList("weaponBackgroundLore");
    }

    public int getMinimumLevel() {
        return this.getWeaponConfiguration().getInt("weaponMinimumLevel");
    }

    public double getMaximumLevel() {
        return this.getWeaponConfiguration().getInt("weaponMaximumLevel");
    }

    public double getMinimumDamage() {
        return this.getWeaponConfiguration().getDouble("weaponMinimumDamage");
    }

    public double getMaximumDamage() {
        return this.getWeaponConfiguration().getDouble("weaponMaximumDamage");
    }

    public double getAttackCooldown() {
        return this.getWeaponConfiguration().getDouble("weaponAttackCooldown");
    }

    public int getMinimumGem() {
        return this.getWeaponConfiguration().getInt("weaponMinimumGem");
    }

    public int getMaximumGem() {
        return this.getWeaponConfiguration().getInt("weaponMaximumGem");
    }

    public int getMinimumScroll() {
        return this.getWeaponConfiguration().getInt("weaponMinimumScroll");
    }

    public int getMaximumScroll() {
        return this.getWeaponConfiguration().getInt("weaponMaximumScroll");
    }

    public String getAbilityName() {
        return this.getWeaponConfiguration().getString("weaponAbilityName");
    }

    public List<String> getAbilityDescription() {
        return this.getWeaponConfiguration().getStringList("weaponAbilityDescription");
    }

    public String getAbilityCastType() {
        return this.getWeaponConfiguration().getString("weaponAbilityCastType");
    }

    public String getAbilityActionType() {
        return this.getWeaponConfiguration().getString("weaponAbilityActionType");
    }

    public double getAbilityCooldown() {
        return this.getWeaponConfiguration().getDouble("weaponAbilityCooldown");
    }

    public double getAbilityManaCost() {
        return this.getWeaponConfiguration().getDouble("weaponAbilityManaCost");
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
