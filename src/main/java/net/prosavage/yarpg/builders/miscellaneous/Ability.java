package net.prosavage.yarpg.builders.miscellaneous;

import net.prosavage.yarpg.utils.Config;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ability {

    private final String name;
    private final double mana;
    private final double cooldown;
    private List<String> description;
    private Consumer<PlayerInteractEvent> leftAction;
    private Consumer<PlayerInteractEvent> rightAction;
    private Consumer<PlayerDropItemEvent> dropAction;
    private boolean hasLeftAction = false;
    private boolean hasRightAction = false;
    private boolean hasDropAction = false;

    public Ability(String name, double mana, double cooldown, String description){
        this.name = name;
        this.mana = mana;
        this.cooldown = cooldown;
        this.description = Arrays.asList(description.split("\\|\\|"));
    }

    public String getName() {
        return name;
    }

    public double getMana() {
        return mana;
    }

    public double getCooldown() {
        return cooldown;
    }

    public Consumer<PlayerInteractEvent> getLeftAction() {
        return this.leftAction;
    }

    public Ability addLeftClickInteraction(Consumer<PlayerInteractEvent> action){
        this.leftAction = action;
        this.hasLeftAction = true;
        return this;
    }

    public Consumer<PlayerInteractEvent> getRightAction() {
        return this.rightAction;
    }

    public Ability addRightClickInteraction(Consumer<PlayerInteractEvent> action){
        this.rightAction = action;
        this.hasRightAction = true;
        return this;
    }

    public Consumer<PlayerInteractEvent> getDropAction() {
        return this.leftAction;
    }

    public Ability addItemDropInteraction(Consumer<PlayerDropItemEvent> action){
        this.dropAction = action;
        this.hasDropAction = true;
        return this;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public Ability build(){
        File file = new File(net.prosavage.yarpg.YaRPG.getInstance().getDataFolder(), "abilities\\" + name + ".yml");
        if (!(file.exists())){
            Config config = new Config(net.prosavage.yarpg.YaRPG.getInstance(), "abilities\\" + name + ".yml");
            config.set("ability_name", this.name);
            config.set("ability_mana_cost", this.mana);
            config.set("ability_cooldown", this.cooldown);
            config.set("ability_description", this.description);
            config.set("ability_left_click_action", this.hasLeftAction);
            config.set("ability_right_click_action", this.hasRightAction);
            config.set("ability_drop_action", this.hasDropAction);
            config.saveFile();
        }
        if (this.hasLeftAction){
            net.prosavage.yarpg.YaRPG.getInstance().getLeftClickInteractions().put(name, leftAction);
        }
        if (this.hasRightAction){
            net.prosavage.yarpg.YaRPG.getInstance().getRightClickInteractions().put(name, rightAction);
        }
        if (this.hasDropAction){
            net.prosavage.yarpg.YaRPG.getInstance().getItemDropInteractions().put(name, dropAction);
        }
        return this;
    }

}
