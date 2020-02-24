package net.prosavage.savagerpg.builders.files;

import net.prosavage.savagerpg.SavageRPG;
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
        this.regionFolders = new File(SavageRPG.getInstance().getEntityFolder()).listFiles();
        this.entityFile = new File(SavageRPG.getInstance().getEntityFolder() + File.separator + this.region + File.separator + this.name + ".yml");
        this.entityConfiguration = YamlConfiguration.loadConfiguration(this.entityFile);
    }

    public EntityFiles(String region){
        this.region = region;
        this.regionFolders = new File(SavageRPG.getInstance().getEntityFolder()).listFiles();
    }

    public EntityFiles setName(String name) {
        String path = SavageRPG.getInstance().getEntityFolder() + File.separator + this.region + File.separator + name + ".yml";
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
        String path = SavageRPG.getInstance().getEntityFolder() + File.separator + region + File.separator + this.name + ".yml";
        File oldFolderFile = new File(SavageRPG.getInstance().getEntityFolder() + File.separator + this.region);
        File newFolderFile = new File(SavageRPG.getInstance().getEntityFolder() + File.separator + region);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getEntityFile().renameTo(new File(path));
        net.prosavage.savagerpg.SavageRPG.getInstance().sendConsole(oldFolderFile.listFiles().length);
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
        this.getEntityConfiguration().set("entityMinimumLevel", minimumLevel);
        return this;
    }

    public EntityFiles setMaximumLevel(int maximumLevel) {
        this.getEntityConfiguration().set("entityMaximumLevel", maximumLevel);
        return this;
    }

    public EntityFiles setMinimumProtection(double minimumProtection) {
        this.getEntityConfiguration().set("entityMinimumProtection", minimumProtection);
        return this;
    }

    public EntityFiles setMaximumProtection(double maximumProtection) {
        this.getEntityConfiguration().set("entityMaximumProtection", maximumProtection);
        return this;
    }

    public EntityFiles setMinimumHealth(double minimumHealth) {
        this.getEntityConfiguration().set("entityMinimumProtection", minimumHealth);
        return this;
    }

    public EntityFiles setMaximumHealth(double maximumHealth) {
        this.getEntityConfiguration().set("entityMaximumHealth", maximumHealth);
        return this;
    }

    public EntityFiles addDropAndChances(List<String> drops, List<String> chances) {
        List<String> configurationDrops = getEntityConfiguration().getStringList("entityDrops");
        List<String> configurationDropChances = getEntityConfiguration().getStringList("entityDropChances");
        configurationDrops.addAll(drops);
        configurationDropChances.addAll(chances);
        this.getEntityConfiguration().set("entityDrops", configurationDrops);
        this.getEntityConfiguration().set("entityDropChances", configurationDropChances);
        return this;
    }

    public EntityFiles addDrops(List<String> drops) {
        List<String> configurationDrops = getEntityConfiguration().getStringList("entityDrops");
        configurationDrops.addAll(drops);
        this.getEntityConfiguration().set("entityDrops", configurationDrops);
        return this;
    }

    public EntityFiles addDropChances(List<String> chances) {
        List<String> configurationDropChances = getEntityConfiguration().getStringList("entityDropChances");
        configurationDropChances.addAll(chances);
        this.getEntityConfiguration().set("entityDropChances", configurationDropChances);
        return this;
    }

    public EntityFiles setDropAndChances(List<String> drops, List<String> chances) {
        this.getEntityConfiguration().set("entityDrops", drops);
        this.getEntityConfiguration().set("entityDropChances", chances);
        return this;
    }

    public EntityFiles setDrops(List<String> drops) {
        this.getEntityConfiguration().set("entityDrops", drops);
        return this;
    }

    public EntityFiles setDropChances(List<String> chances) {
        this.getEntityConfiguration().set("entityDropChances", chances);
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
        return this.getEntityConfiguration().getString("entityActualMaterial");
    }

    public String getCosmeticMaterial() {
        return this.getEntityConfiguration().getString("entityCosmeticMaterial");
    }

    public List<String> getBackgroundLore() {
        return this.getEntityConfiguration().getStringList("entityBackgroundLore");
    }

    public int getMinimumLevel() {
        return this.getEntityConfiguration().getInt("entityMinimumLevel");
    }

    public double getMaximumLevel() {
        return this.getEntityConfiguration().getInt("entityMaximumLevel");
    }

    public double getMinimumProtection() {
        return this.getEntityConfiguration().getDouble("entityMinimumProtection");
    }

    public double getMaximumProtection() {
        return this.getEntityConfiguration().getDouble("entityMaximumProtection");
    }

    public double getMinimumHealth() {
        return this.getEntityConfiguration().getDouble("entityMinimumProtection");
    }

    public double getMaximumHealth() {
        return this.getEntityConfiguration().getDouble("entityMaximumHealth");
    }

    public EntityFiles getDrops(List<String> drops) {
        this.getEntityConfiguration().getStringList("entityDrops");
        return this;
    }

    public EntityFiles getDropChances(List<String> chances) {
        this.getEntityConfiguration().getStringList("entityDropChances");
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
