package net.prosavage.yarpg.builders.files;

import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArmorFiles {

    private String name;
    private String rarity;
    private File[] rarityFolders;
    private File armorFile;
    private YamlConfiguration armorConfiguration;

    public ArmorFiles(String rarity, String name){
        this.rarity = rarity;
        this.name = name;
        this.rarityFolders = new File(YaRPG.getInstance().getArmorFolder()).listFiles();
        this.armorFile = new File(YaRPG.getInstance().getArmorFolder() + File.separator + this.rarity + File.separator + this.name + ".yml");
        this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
    }

    public ArmorFiles(String rarity){
        this.rarity = rarity;
        this.rarityFolders = new File(YaRPG.getInstance().getArmorFolder()).listFiles();
    }

    public ArmorFiles setName(String name) {
        String path = YaRPG.getInstance().getArmorFolder() + File.separator + this.rarity + File.separator + name + ".yml";
        boolean rename = getArmorFile().renameTo(new File(path));
        if (rename){
            this.name = name;
            this.armorFile = new File(path);
            this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
            try {
                armorConfiguration.save(this.armorFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ArmorFiles setRarity(String rarity) {
        String path = YaRPG.getInstance().getArmorFolder() + File.separator + rarity + File.separator + this.name + ".yml";
        File oldFolderFile = new File(YaRPG.getInstance().getArmorFolder() + File.separator + this.rarity);
        File newFolderFile = new File(YaRPG.getInstance().getArmorFolder() + File.separator + rarity);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getArmorFile().renameTo(new File(path));
        net.prosavage.yarpg.YaRPG.getInstance().sendConsole(oldFolderFile.listFiles().length);
        if (oldFolderFile.listFiles().length == 0){
            boolean deletedFile = oldFolderFile.delete();
        }
        if (rename) {
            this.rarity = rarity;
            this.armorFile = new File(path);
            this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
            try {
                armorConfiguration.save(this.armorFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ArmorFiles setActualMaterial(String actualMaterial) {
        this.getArmorConfiguration().set("armor_actual_material", actualMaterial);
        return this;
    }

    public ArmorFiles setCosmeticMaterial(String cosmeticMaterial) {
        this.getArmorConfiguration().set("armor_cosmetic_material", cosmeticMaterial);
        return this;
    }

    public ArmorFiles setBackgroundLore(List<String> backgroundLore) {
        this.getArmorConfiguration().set("armor_background_lore", backgroundLore);
        return this;
    }

    public ArmorFiles setMinimumLevel(int minimumLevel) {
        this.getArmorConfiguration().set("armor_minimum_level", minimumLevel);
        return this;
    }

    public ArmorFiles setMaximumLevel(int maximumLevel) {
        this.getArmorConfiguration().set("armor_maximum_level", maximumLevel);
        return this;
    }

    public ArmorFiles setMinimumProtection(double minimumProtection) {
        this.getArmorConfiguration().set("armor_minimum_protection", minimumProtection);
        return this;
    }

    public ArmorFiles setMaximumProtection(double maximumProtection) {
        this.getArmorConfiguration().set("armor_maximum_protection", maximumProtection);
        return this;
    }

    public ArmorFiles setMinimumHealth(double minimumHealth) {
        this.getArmorConfiguration().set("armor_minimum_protection", minimumHealth);
        return this;
    }

    public ArmorFiles setMaximumHealth(double maximumHealth) {
        this.getArmorConfiguration().set("armor_maximum_health", maximumHealth);
        return this;
    }

    public ArmorFiles setMinimumRegen(double minimumRegen) {
        this.getArmorConfiguration().set("armor_minimum_regen", minimumRegen);
        return this;
    }

    public ArmorFiles setMaximumRegen(double maximumRegen) {
        this.getArmorConfiguration().set("armor_maximum_regen", maximumRegen);
        return this;
    }

    public ArmorFiles setMinimumGem(int minimumGem) {
        this.getArmorConfiguration().set("armor_minimum_gem", minimumGem);
        return this;
    }

    public ArmorFiles setMaximumGem(int maximumGem) {
        this.getArmorConfiguration().set("armor_maximum_gem", maximumGem);
        return this;
    }

    public ArmorFiles setMinimumScroll(int minimumScroll) {
        this.getArmorConfiguration().set("armor_minimum_scroll", minimumScroll);
        return this;
    }

    public ArmorFiles setMaximumScroll(int maximumScroll) {
        this.getArmorConfiguration().set("armor_maximum_scroll", maximumScroll);
        return this;
    }

    public void setArmorFile(File armorFile) {
        this.armorFile = armorFile;
    }

    public void setArmorConfiguration(YamlConfiguration armorConfiguration) {
        this.armorConfiguration = armorConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity;
    }

    public String getActualMaterial() {
        return this.getArmorConfiguration().getString("armor_actual_material");
    }

    public String getCosmeticMaterial() {
        return this.getArmorConfiguration().getString("armor_cosmetic_material");
    }

    public List<String> getBackgroundLore() {
        return this.getArmorConfiguration().getStringList("armor_background_lore");
    }

    public int getMinimumLevel() {
        return this.getArmorConfiguration().getInt("armor_minimum_level");
    }

    public double getMaximumLevel() {
        return this.getArmorConfiguration().getInt("armor_maximum_level");
    }

    public double getMinimumProtection() {
        return this.getArmorConfiguration().getDouble("armor_minimum_protection");
    }

    public double getMaximumProtection() {
        return this.getArmorConfiguration().getDouble("armor_maximum_protection");
    }

    public double getMinimumHealth() {
        return this.getArmorConfiguration().getDouble("armor_minimum_health");
    }

    public double getMaximumHealth() {
        return this.getArmorConfiguration().getDouble("armor_maximum_health");
    }

    public double getMinimumRegen() {
        return this.getArmorConfiguration().getDouble("armor_minimum_regen");
    }

    public double getMaximumRegen() {
        return this.getArmorConfiguration().getDouble("armor_maximum_regen");
    }

    public int getMinimumGem() {
        return this.getArmorConfiguration().getInt("armor_minimum_gem");
    }

    public int getMaximumGem() {
        return this.getArmorConfiguration().getInt("armor_maximum_gem");
    }

    public int getMinimumScroll() {
        return this.getArmorConfiguration().getInt("armor_minimum_scroll");
    }

    public int getMaximumScroll() {
        return this.getArmorConfiguration().getInt("armor_maximum_scroll");
    }

    public File[] getRarityFolders() {
        return this.rarityFolders;
    }

    public File getArmorFile() {
        return this.armorFile;
    }

    public int getRarityFoldersAmount(){
        return this.rarityFolders.length;
    }

    public int getArmorFilesAmount(){
        return Objects.requireNonNull(this.armorFile.list()).length;
    }

    private YamlConfiguration getArmorConfiguration() {
        return armorConfiguration;
    }

    public void save(){
        try {
            getArmorConfiguration().save(this.armorFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getExample(){
        setActualMaterial("LEATHER_HELMET");
        setCosmeticMaterial("Example");
        setBackgroundLore(Arrays.asList("Where's the rest of the armor set?", "They seem to be somewhere..."));
        setMinimumLevel(1);
        setMaximumLevel(100);
        setMinimumProtection(1.025671);
        setMaximumProtection(2.2325862);
        setMinimumHealth(1.25829035);
        setMaximumHealth(2.6829032);
        setMinimumRegen(0.235890235);
        setMaximumRegen(2.2358902);
        setMinimumGem(1);
        setMaximumGem(2);
        setMinimumScroll(1);
        setMaximumScroll(2);
        save();
    }

}
