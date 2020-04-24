package net.prosavage.yarpg.api;

import com.udojava.evalex.Expression;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import net.prosavage.yarpg.utils.Placeholders;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.math.BigDecimal;

public class YPlayer {

    Placeholders Placeholders = new Placeholders();

    Player player;
    PersistentDataContainer persistentDataContainer;

    public YPlayer(Player player){
        this.player = player;
        this.persistentDataContainer = this.player.getPersistentDataContainer();
    }

    public YPlayer(Player player, int level, double experience){
        this.player = player;
        this.persistentDataContainer = this.player.getPersistentDataContainer();
        persistentDataContainer.set(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, level);
        persistentDataContainer.set(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, experience);
    }

    public YPlayer setLevel(int level) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, level);
        return this;
    }

    public YPlayer setExperience(double experience) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, experience);
        return this;
    }

    private YPlayer setMaximumExp(double maximumExp) {
        if (maximumExp == 0.0) {
            BigDecimal result;
            YaRPG.getInstance().sendConsole(YaRPG.getInstance().getConfig().getString("formulas.maximum-experience"));
            YaRPG.getInstance().sendConsole(Placeholders.forPlayer(this.player, YaRPG.getInstance().getConfig().getString("formulas.maximum_experience")));
            Expression expression = new Expression(Placeholders.forPlayer(this.player, YaRPG.getInstance().getConfig().getString("formulas.maximum_experience"))).setPrecision(2);
            result = expression.eval();
            this.persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, result.doubleValue());
        }else{
            this.persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, maximumExp);
        }
        return this;
    }

    public void setDefault(){
        setLevel(1);
        setExperience(0.0);
        setMaximumExp(0.0);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getLevel() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public double getExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public boolean hasData(){
        return persistentDataContainer.has(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER) ||
                persistentDataContainer.has(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.INTEGER) ||
                persistentDataContainer.has(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.INTEGER);
    }

}
