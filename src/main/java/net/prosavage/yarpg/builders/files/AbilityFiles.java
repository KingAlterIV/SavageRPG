package net.prosavage.yarpg.builders.files;

import net.prosavage.yarpg.YaRPG;
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
        this.abilityFile = new File(YaRPG.getInstance().getAbilityFolder() + File.separator + this.name + ".yml");
        this.abilityConfiguration = YamlConfiguration.loadConfiguration(this.abilityFile);
    }

    public AbilityFiles setName(String name) {
        String path = YaRPG.getInstance().getAbilityFolder() + File.separator + name + ".yml";
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
        this.getAbilityConfiguration().set("ability_mana_cost", manaCost);
        return this;
    }

    public AbilityFiles setCooldown(double cooldown) {
        this.getAbilityConfiguration().set("ability_cooldown", cooldown);
        return this;
    }

    public AbilityFiles setDescription(List<String> description) {
        this.getAbilityConfiguration().set("ability_description", description);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public double getManaCost() {
        return this.getAbilityConfiguration().getDouble("ability_mana_cost");
    }

    public double getCooldown() {
        return this.getAbilityConfiguration().getDouble("ability_cooldown");
    }

    public List<String> getDescription() {
        return this.getAbilityConfiguration().getStringList("ability_description");
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
        return this.getAbilityConfiguration().getBoolean("ability_leftclick_action");
    }

    public boolean isRightClickAction(){
        return this.getAbilityConfiguration().getBoolean("ability_rightclick_action");
    }

    public boolean isDroppableAction(){
        return this.getAbilityConfiguration().getBoolean("ability_drop_action");
    }
}