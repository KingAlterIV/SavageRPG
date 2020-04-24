package net.prosavage.yarpg.utils;

import net.prosavage.yarpg.api.YPlayer;
import net.prosavage.yarpg.api.entities.YEntity;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class Placeholders {

    private DecimalFormat doubleFormat = new DecimalFormat("##.##");

    public String forPlayer(Player player, String string) {
        YPlayer yPlayer = new YPlayer(player);
        int level = yPlayer.getLevel();
        double exp = yPlayer.getExperience();
        double maximumExp = yPlayer.getMaximumExperience();
        double health = player.getHealth();
        double maximumHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        string = string.replaceAll("\\{PLAYER-LEVEL}", String.valueOf(level))
                .replaceAll("\\{PLAYER-EXPERIENCE}", String.valueOf(exp))
                .replaceAll("\\{PLAYER-MAXIMUM-EXPERIENCE}", String.valueOf(maximumExp))
                .replaceAll("\\{PLAYER-HEALTH}", String.valueOf(health))
                .replaceAll("\\{PLAYER-MAXIMUM-HEALTH}", String.valueOf(maximumHealth));
        return string;
    }

    public String forEntities(Entity entity, String string){
        Damageable damageable = (Damageable) entity;
        YEntity yEntity = new YEntity(entity);
        String customName = yEntity.getName();
        int level = yEntity.getLevel();
        String health = doubleFormat.format(damageable.getHealth());
        String maximumHealth = doubleFormat.format(yEntity.getHealth());
        string = string.replaceAll("\\{ENTITY-NAME}", customName)
                .replaceAll("\\{ENTITY-LEVEL}", String.valueOf(level))
                .replaceAll("\\{ENTITY-HEALTH}", health)
                .replaceAll("\\{ENTITY-MAXIMUM-HEALTH}", maximumHealth);
        return string;
    }

}
