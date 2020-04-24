package net.prosavage.yarpg.builders.files;

import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class EntityFiles {

    private String name;
    private String region;
    private File[] regionFolders;
    private File entityFile;
    private YamlConfiguration entityConfiguration;

    public EntityFiles(String region, String name){
        this.region = region;
        this.name = name;
        this.regionFolders = new File(YaRPG.getInstance().getEntityFolder()).listFiles();
        this.entityFile = new File(YaRPG.getInstance().getEntityFolder() + File.separator + this.region + File.separator + this.name + ".yml");
        this.entityConfiguration = YamlConfiguration.loadConfiguration(this.entityFile);
    }

    public EntityFiles(String region){
        this.region = region;
        this.regionFolders = new File(YaRPG.getInstance().getEntityFolder()).listFiles();
    }

    public EntityFiles setName(String name) {
        String path = YaRPG.getInstance().getEntityFolder() + File.separator + this.region + File.separator + name + ".yml";
        boolean rename = getEntityFile().renameTo(new File(path));
        if (rename){
            this.name = name;
            this.entityFile = new File(path);
            this.entityConfiguration = YamlConfiguration.loadConfiguration(this.entityFile);
            try {
                entityConfiguration.save(this.entityFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public EntityFiles setRegion(String region) {
        String path = YaRPG.getInstance().getEntityFolder() + File.separator + region + File.separator + this.name + ".yml";
        File oldFolderFile = new File(YaRPG.getInstance().getEntityFolder() + File.separator + this.region);
        File newFolderFile = new File(YaRPG.getInstance().getEntityFolder() + File.separator + region);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getEntityFile().renameTo(new File(path));
        net.prosavage.yarpg.YaRPG.getInstance().sendConsole(oldFolderFile.listFiles().length);
        if (oldFolderFile.listFiles().length == 0){
            boolean deletedFile = oldFolderFile.delete();
        }
        if (rename) {
            this.region = region;
            this.entityFile = new File(path);
            this.entityConfiguration = YamlConfiguration.loadConfiguration(this.entityFile);
            try {
                entityConfiguration.save(this.entityFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public EntityFiles setMinimumLevel(int minimumLevel) {
        this.getEntityConfiguration().set("entity_minimum_level", minimumLevel);
        return this;
    }

    public EntityFiles setMaximumLevel(int maximumLevel) {
        this.getEntityConfiguration().set("entity_maximum_level", maximumLevel);
        return this;
    }

    public EntityFiles setMinimumProtection(double minimumProtection) {
        this.getEntityConfiguration().set("entity_minimum_protection", minimumProtection);
        return this;
    }

    public EntityFiles setMaximumProtection(double maximumProtection) {
        this.getEntityConfiguration().set("entity_maximum_protection", maximumProtection);
        return this;
    }

    public EntityFiles setMinimumHealth(double minimumHealth) {
        this.getEntityConfiguration().set("entity_minimum_protection", minimumHealth);
        return this;
    }

    public EntityFiles setMaximumHealth(double maximumHealth) {
        this.getEntityConfiguration().set("entity_maximum_health", maximumHealth);
        return this;
    }

    public EntityFiles addDropAndChances(List<String> drops, List<String> chances) {
        List<String> configurationDrops = getEntityConfiguration().getStringList("entity_drops");
        List<String> configurationDropChances = getEntityConfiguration().getStringList("entity_drop_chances");
        configurationDrops.addAll(drops);
        configurationDropChances.addAll(chances);
        this.getEntityConfiguration().set("entity_drops", configurationDrops);
        this.getEntityConfiguration().set("entity_drop_chances", configurationDropChances);
        return this;
    }

    public EntityFiles addDrops(List<String> drops) {
        List<String> configurationDrops = getEntityConfiguration().getStringList("entity_drops");
        configurationDrops.addAll(drops);
        this.getEntityConfiguration().set("entity_drops", configurationDrops);
        return this;
    }

    public EntityFiles addDropChances(List<String> chances) {
        List<String> configurationDropChances = getEntityConfiguration().getStringList("entity_drop_chances");
        configurationDropChances.addAll(chances);
        this.getEntityConfiguration().set("entity_drop_chances", configurationDropChances);
        return this;
    }

    public EntityFiles setDropAndChances(List<String> drops, List<String> chances) {
        this.getEntityConfiguration().set("entity_drops", drops);
        this.getEntityConfiguration().set("entity_drop_chances", chances);
        return this;
    }

    public EntityFiles setDrops(List<String> drops) {
        this.getEntityConfiguration().set("entity_drops", drops);
        return this;
    }

    public EntityFiles setDropChances(List<String> chances) {
        this.getEntityConfiguration().set("entity_drop_chances", chances);
        return this;
    }

    public void setEntityFile(File entityFile) {
        this.entityFile = entityFile;
    }

    public void setEntityConfiguration(YamlConfiguration entityConfiguration) {
        this.entityConfiguration = entityConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public String getRegion() {
        return this.region;
    }

    public String getActualMaterial() {
        return this.getEntityConfiguration().getString("entity_actual_material");
    }

    public String getCosmeticMaterial() {
        return this.getEntityConfiguration().getString("entity_cosmetic_material");
    }

    public List<String> getBackgroundLore() {
        return this.getEntityConfiguration().getStringList("entity_background_lore");
    }

    public int getMinimumLevel() {
        return this.getEntityConfiguration().getInt("entity_minimum_level");
    }

    public double getMaximumLevel() {
        return this.getEntityConfiguration().getInt("entity_maximum_level");
    }

    public double getMinimumProtection() {
        return this.getEntityConfiguration().getDouble("entity_minimum_protection");
    }

    public double getMaximumProtection() {
        return this.getEntityConfiguration().getDouble("entity_maximum_protection");
    }

    public double getMinimumHealth() {
        return this.getEntityConfiguration().getDouble("entity_minimum_protection");
    }

    public double getMaximumHealth() {
        return this.getEntityConfiguration().getDouble("entity_maximum_health");
    }

    public EntityFiles getDrops(List<String> drops) {
        this.getEntityConfiguration().getStringList("entity_drops");
        return this;
    }

    public EntityFiles getDropChances(List<String> chances) {
        this.getEntityConfiguration().getStringList("entity_drop_chances");
        return this;
    }

    public File[] getRegionFolders() {
        return this.regionFolders;
    }

    public File getEntityFile() {
        return this.entityFile;
    }

    public int getRegionFoldersAmount(){
        return this.regionFolders.length;
    }

    public int getEntityFilesAmount(){
        return Objects.requireNonNull(this.entityFile.list()).length;
    }

    private YamlConfiguration getEntityConfiguration() {
        return entityConfiguration;
    }

    public void save(){
        try {
            getEntityConfiguration().save(this.entityFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
