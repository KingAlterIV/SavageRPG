package net.prosavage.yarpg.builders.entities;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import net.prosavage.yarpg.utils.Color;
import net.prosavage.yarpg.utils.INumber;
import net.prosavage.yarpg.utils.Placeholders;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import java.util.List;

public class YEntities {

    INumber INumber = new INumber();
    Color Color = new Color();
    Placeholders Placeholders = new Placeholders();

    private Mob entity;
    private EntityType entityType;
    private String name;
    private int level = 1;
    private double health = 20.0;
    private double minimumHealth = 20;
    private double maximumHealth = 20;
    private double exp = 0.0;
    private double minimumExp = 0.0;
    private double maximumExp = 0.0;
    private double damage = 0.0;
    private double minimumDamage = 0.0;
    private double maximumDamage = 0.0;
    private double protection = 0.0;
    private double minimumProtection = 0.0;
    private double maximumProtection = 0.0;
    private ItemStack heldItem = new ItemStack(Material.AIR);
    private ItemStack helmet = new ItemStack(Material.AIR);
    private ItemStack chestplate = new ItemStack(Material.AIR);
    private ItemStack leggings = new ItemStack(Material.AIR);
    private ItemStack boots = new ItemStack(Material.AIR);
    private List<String> pluginDrops;
    private List<ItemStack> minecraftDrops;
    private boolean spawned;

    public YEntities(Entity entity, String name) {
        if (entity instanceof Mob) {
            this.entity = (Mob) entity;
        }
        this.name = name;
    }

    public YEntities(String entityType, String name) {
        this.entityType = EntityType.valueOf(entityType.toUpperCase());
        this.name = name;
    }

    public YEntities(EntityType entityType, String name) {
        this.entityType = entityType;
        this.name = name;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public YEntities setName(String name) {
        this.name = name;
        return this;
    }

    public YEntities setLevel(int level){
        this.level = level;
        return this;
    }

    public YEntities setHealth(double health, boolean random){
        if (random) {
            this.health = INumber.getDouble(this.minimumHealth, this.maximumHealth);
        }else{
            this.health = health;
        }
        return this;
    }

    public YEntities setMinimumHealth(double minimumHealth) {
        this.minimumHealth = minimumHealth;
        return this;
    }

    public YEntities setMaximumHealth(double maximumHealth) {
        this.maximumHealth = maximumHealth;
        return this;
    }

    public YEntities setExp(double exp, boolean random) {
        if (random){
            this.exp = INumber.getDouble(this.minimumExp, this.maximumExp);
        }else{
            this.exp = exp;
        }
        return this;
    }

    public YEntities setMinimumExp(double minimumExp) {
        this.minimumExp = minimumExp;
        return this;
    }

    public YEntities setMaximumExp(double maximumExp) {
        this.maximumExp = maximumExp;
        return this;
    }

    public YEntities setDamage(double damage, boolean random) {
        if (random){
            this.damage = INumber.getDouble(this.minimumDamage, this.maximumDamage);
        }else{
            this.damage = damage;
        }
        return this;
    }

    public YEntities setMinimumDamage(double minimumDamage) {
        this.minimumDamage = minimumDamage;
        return this;
    }

    public YEntities setMaximumDamage(double maximumDamage) {
        this.maximumDamage = maximumDamage;
        return this;
    }

    public YEntities setProtection(double protection, boolean random) {
        if (random){
            this.protection = INumber.getDouble(this.minimumProtection, this.maximumProtection);
        }else{
            this.protection = protection;
        }
        return this;
    }

    public YEntities setMinimumProtection(double minimumProtection) {
        this.minimumProtection = minimumProtection;
        return this;
    }

    public YEntities setMaximumProtection(double maximumProtection) {
        this.maximumProtection = maximumProtection;
        return this;
    }

    public YEntities setHeldItem(String heldItem) {
        this.heldItem = new ItemStack(Material.valueOf(heldItem.toUpperCase()));
        return this;
    }

    public YEntities setHelmet(String helmet) {
        this.helmet = new ItemStack(Material.valueOf(helmet.toUpperCase()));
        return this;
    }

    public YEntities setChestplate(String chestplate) {
        this.chestplate = new ItemStack(Material.valueOf(chestplate.toUpperCase()));
        return this;
    }

    public YEntities setLeggings(String leggings) {
        this.leggings = new ItemStack(Material.valueOf(leggings.toUpperCase()));
        return this;
    }

    public YEntities setBoots(String boots) {
        this.boots = new ItemStack(Material.valueOf(boots.toUpperCase()));
        return this;
    }

    public YEntities setHeldItem(ItemStack heldItem) {
        this.heldItem = heldItem;
        return this;
    }

    public YEntities setHelmet(ItemStack helmet) {
        this.helmet = helmet;
        return this;
    }

    public YEntities setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public YEntities setLeggings(ItemStack leggings) {
        this.leggings = leggings;
        return this;
    }

    public YEntities setBoots(ItemStack boots) {
        this.boots = boots;
        return this;
    }

    public YEntities setPluginDrops(List<String> pluginDrops) {
        this.pluginDrops = pluginDrops;
        return this;
    }

    public YEntities setMinecraftDrops(List<ItemStack> minecraftDrops) {
        this.minecraftDrops = minecraftDrops;
        return this;
    }

    public YEntities setPersistentDataContainers(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        persistentDataContainer.set(YNamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, this.name);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_HEALTH, PersistentDataType.DOUBLE, this.health);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, this.minimumHealth);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, this.maximumHealth);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE, this.exp);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MINIMUM_EXPERIENCE, PersistentDataType.DOUBLE, this.minimumExp);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, this.maximumExp);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, this.minimumDamage);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, this.maximumDamage);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, this.protection);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, this.minimumProtection);
        persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, this.maximumProtection);
        return this;
    }

    public EntityType getEntityType() {
        return this.entityType;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public double getHealth() {
        return this.health;
    }

    public double getMinimumHealth() {
        return this.minimumHealth;
    }

    public double getMaximumHealth() {
        return this.maximumHealth;
    }

    public double getExp() {
        return this.exp;
    }

    public double getMinimumExp() {
        return this.minimumExp;
    }

    public double getMaximumExp() {
        return this.maximumExp;
    }

    public double getDamage() {
        return this.damage;
    }

    public double getMinimumDamage() {
        return this.minimumDamage;
    }

    public double getMaximumDamage() {
        return this.maximumDamage;
    }

    public double getProtection() {
        return this.protection;
    }

    public double getMinimumProtection() {
        return this.minimumProtection;
    }

    public double getMaximumProtection() {
        return this.maximumProtection;
    }

    public ItemStack getHeldItem() {
        return this.heldItem;
    }

    public ItemStack getHelmet() {
        return this.helmet;
    }

    public ItemStack getChestplate() {
        return this.chestplate;
    }

    public ItemStack getLeggings() {
        return this.leggings;
    }

    public ItemStack getBoots() {
        return this.boots;
    }

    public List<String> getPluginDrops() {
        return this.pluginDrops;
    }

    public List<ItemStack> getMinecraftDrops(){
        return this.minecraftDrops;
    }

    public YEntities spawn(Location location, boolean randomEverything) {
        if (randomEverything){
            setHealth(0.0, true);
            setDamage(0.0, true);
            setExp(0.0, true);
            setProtection(0.0, true);
        }
        World world = location.getWorld();
        if (entityType != null) {
            if (!spawned) {
                world.spawn(location, entityType.getEntityClass(), consumer -> {
                    if (consumer instanceof Mob) {
                        Mob consumerLiving = (Mob) consumer;
                        consumerLiving.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(this.health);
                        consumerLiving.setHealth(this.health);
                        consumerLiving.setCustomName(this.name);
                        consumerLiving.setCustomNameVisible(true);
                        consumerLiving.getEquipment().setItemInMainHand(this.heldItem);
                        consumerLiving.getEquipment().setHelmet(this.helmet);
                        consumerLiving.getEquipment().setChestplate(this.chestplate);
                        consumerLiving.getEquipment().setLeggings(this.leggings);
                        consumerLiving.getEquipment().setBoots(this.boots);
                        consumerLiving.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.damage);
                        consumerLiving.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(this.protection);
                        setPersistentDataContainers(consumerLiving);
                        consumerLiving.setCustomName(Color.ify(Placeholders.forEntities(consumerLiving, YaRPG.getInstance().getConfig().getString("format.entity_names"))));
                    }
                });
                spawned = true;
                return this;
            }
        }else if (entity != null){
            entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(this.health);
            entity.setHealth(this.health);
            entity.setCustomName(this.name);
            entity.setCustomNameVisible(true);
            entity.getEquipment().setItemInMainHand(this.heldItem);
            entity.getEquipment().setHelmet(this.helmet);
            entity.getEquipment().setChestplate(this.chestplate);
            entity.getEquipment().setLeggings(this.leggings);
            entity.getEquipment().setBoots(this.boots);
            if (entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE) != null) {
                entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(this.damage);
            }
            if (entity.getAttribute(Attribute.GENERIC_ARMOR) != null) {
                entity.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(this.protection);
            }
            setPersistentDataContainers(entity);
            entity.setCustomName(Color.ify(Placeholders.forEntities(entity, YaRPG.getInstance().getConfig().getString("format.entity_names"))));
            return this;
        }
        return this;
    }

}