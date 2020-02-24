package net.prosavage.savagerpg.builders.files;

import net.prosavage.savagerpg.SavageRPG;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AbilityFiles {

    private String name;
    private File abilityFile;
    private YamlConfiguration abilityConfiguration;

    public AbilityFiles(String name){
        this.name = name;
        this.abilityFile = new File(SavageRPG.getInstance().getAbilityFolder() + File.separator + this.name + ".yml");
        this.abilityConfiguration = YamlConfiguration.loadConfiguration(this.abilityFile);
    }

    public AbilityFiles setName(String name) {
        String path = SavageRPG.getInstance().getAbilityFolder() + File.separator + name + ".yml";
        boolean rename = getAbilityFile().renameTo(new File(path));
        if (rename){
            this.name = name;
            this.abilityFile = new File(path);
            this.abilityConfiguration = YamlConfiguration.loadConfiguration(this.abilityFile);
            try {
                abilityConfiguration.save(this.abilityFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public AbilityFiles setManaCost(double manaCost) {
        this.getAbilityConfiguration().set("abilityManaCost", manaCost);
        return this;
    }

    public AbilityFiles setCooldown(double cooldown) {
        this.getAbilityConfiguration().set("abilityCooldown", cooldown);
        return this;
    }

    public AbilityFiles setDescription(List<String> description) {
        this.getAbilityConfiguration().set("abilityDescription", description);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public double getManaCost() {
        return this.getAbilityConfiguration().getDouble("abilityManaCost");
    }

    public double getCooldown() {
        return this.getAbilityConfiguration().getDouble("abilityCooldown");
    }

    public List<String> getDescription() {
        return this.getAbilityConfiguration().getStringList("abilityDescription");
    }

    public File getAbilityFile() {
        return this.abilityFile;
    }

    public int getAbilityFilesAmount(){
        return Objects.requireNonNull(this.abilityFile.list()).length;
    }

    private YamlConfiguration getAbilityConfiguration() {
        return abilityConfiguration;
    }

    public void save(){
        try {
            getAbilityConfiguration().save(this.abilityFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isLeftClickAction(){
        return this.getAbilityConfiguration().getBoolean("abilityLeftClickAction");
    }

    public boolean isRightClickAction(){
        return this.getAbilityConfiguration().getBoolean("abilityLeftClickAction");
    }

    public boolean isDroppableAction(){
        return this.getAbilityConfiguration().getBoolean("abilityLeftClickAction");
    }
}