package net.prosavage.savagerpg.builders.entities;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import net.prosavage.savagerpg.api.keys.INamespacedKeys;
import net.prosavage.savagerpg.utils.INumber;
import net.prosavage.savagerpg.utils.Warnings;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import java.util.List;

/*

This class is named SEntity because Entity is taken by Spigot
and I did not want to mess that up.

*/

public class SEntity {

    INumber INumber = new INumber();

    private Player player;
    private EntityType entityType;
    private String name;
    private int level;
    private double health;
    private double minimumHealth = 20;
    private double maximumHealth = 20;
    private double exp;
    private double minimumExp;
    private double maximumExp;
    private double damage;
    private double minimumDamage;
    private double maximumDamage;
    private double protection;
    private double minimumProtection;
    private double maximumProtection;
    private ItemStack heldItem;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private List<String> pluginDrops;
    private List<ItemStack> minecraftDrops;
    private String region;
    private boolean spawned;
    private boolean errors;

    public SEntity(Player player, String entityType, String name) {
        try{
            this.player = player;
            this.entityType = EntityType.valueOf(entityType.toUpperCase());
        } catch (IllegalArgumentException ignored) {
            this.errors = true;
            new Warnings(this.player, "title", "&6&lEntity Type &fis invalid!");
        }
        this.name = name;
    }

    public SEntity(Player player, EntityType entityType, String name) {
        this.entityType = entityType;
        this.name = name;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public SEntity setName(String name) {
        this.name = name;
        return this;
    }

    public SEntity setLevel(int level){
        this.level = level;
        return this;
    }

    public SEntity setHealth(double health, boolean random){
        if (random) {
            this.health = INumber.getDouble(this.minimumHealth, this.maximumHealth);
        }else{
            this.health = health;
        }
        return this;
    }

    public SEntity setMinimumHealth(double minimumHealth) {
        this.minimumHealth = minimumHealth;
        return this;
    }

    public SEntity setMaximumHealth(double maximumHealth) {
        this.maximumHealth = maximumHealth;
        return this;
    }

    public SEntity setExp(double exp, boolean random) {
        if (random){
            this.exp = INumber.getDouble(this.minimumExp, this.maximumExp);
        }else{
            this.exp = exp;
        }
        return this;
    }

    public SEntity setMinimumExp(double minimumExp) {
        this.minimumExp = minimumExp;
        return this;
    }

    public SEntity setMaximumExp(double maximumExp) {
        this.maximumExp = maximumExp;
        return this;
    }

    public SEntity setDamage(double damage, boolean random) {
        if (random){
            this.damage = INumber.getDouble(this.minimumDamage, this.maximumDamage);
        }else{
            this.damage = damage;
        }
        return this;
    }

    public SEntity setMinimumDamage(double minimumDamage) {
        this.minimumDamage = minimumDamage;
        return this;
    }

    public SEntity setMaximumDamage(double maximumDamage) {
        this.maximumDamage = maximumDamage;
        return this;
    }

    public SEntity setProtection(double protection, boolean random) {
        if (random){
            this.protection = INumber.getDouble(this.minimumProtection, this.maximumProtection);
        }else{
            this.protection = protection;
        }
        return this;
    }

    public SEntity setMinimumProtection(double minimumProtection) {
        this.minimumProtection = minimumProtection;
        return this;
    }

    public SEntity setMaximumProtection(double maximumProtection) {
        this.maximumProtection = maximumProtection;
        return this;
    }

    public SEntity setHeldItem(String heldItem) {
        try{
            this.heldItem = new ItemStack(Material.valueOf(heldItem.toUpperCase()));
        } catch (IllegalArgumentException ignored) {
            new Warnings(this.player, "title", "&6&lHeld Item Type &fis invalid!");
        }
        return this;
    }

    public SEntity setHelmet(String helmet) {
        try{
            this.helmet = new ItemStack(Material.valueOf(helmet.toUpperCase()));
        } catch (IllegalArgumentException ignored) {
            this.errors = true;
            new Warnings(this.player, "title", "&6&lHelmet Item Type &fis invalid!");
        }
        return this;
    }

    public SEntity setChestplate(String chestplate) {
        try{
            this.chestplate = new ItemStack(Material.valueOf(chestplate.toUpperCase()));
        } catch (IllegalArgumentException ignored) {
            this.errors = true;
            new Warnings(this.player, "title", "&6&lChestplate Item Type &fis invalid!");
        }
        return this;
    }

    public SEntity setLeggings(String leggings) {
        try{
            this.leggings = new ItemStack(Material.valueOf(leggings.toUpperCase()));
        } catch (IllegalArgumentException ignored) {
            this.errors = true;
            new Warnings(this.player, "title", "&6&lLeggings Item Type &fis invalid!");
        }
        return this;
    }

    public SEntity setBoots(String boots) {
        try{
            this.boots = new ItemStack(Material.valueOf(boots.toUpperCase()));
        } catch (IllegalArgumentException ignored) {
            this.errors = true;
            new Warnings(this.player, "title", "&6&lBoots Item Type &fis invalid!");
        }
        return this;
    }

    public SEntity setHeldItem(ItemStack heldItem) {
        this.heldItem = heldItem;
        return this;
    }

    public SEntity setHelmet(ItemStack helmet) {
        this.helmet = helmet;
        return this;
    }

    public SEntity setChestplate(ItemStack chestplate) {
        this.chestplate = chestplate;
        return this;
    }

    public SEntity setLeggings(ItemStack leggings) {
        this.leggings = leggings;
        return this;
    }

    public SEntity setBoots(ItemStack boots) {
        this.boots = boots;
        return this;
    }

    public SEntity setPluginDrops(List<String> pluginDrops) {
        this.pluginDrops = pluginDrops;
        return this;
    }

    public SEntity setMinecraftDrops(List<ItemStack> minecraftDrops) {
        this.minecraftDrops = minecraftDrops;
        return this;
    }

    public SEntity setRegion(String region) {
        this.region = region;
        return this;
    }

    public SEntity setPersistentDataContainers(Entity entity){
        PersistentDataContainer persistentDataContainer = entity.getPersistentDataContainer();
        persistentDataContainer.set(INamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, this.minimumHealth);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, this.maximumHealth);
        persistentDataContainer.set(INamespacedKeys.ENTITY_EXP, PersistentDataType.DOUBLE, this.exp);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MINIMUM_EXP, PersistentDataType.DOUBLE, this.minimumExp);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MAXIMUM_EXP, PersistentDataType.DOUBLE, this.maximumExp);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, this.minimumDamage);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, this.maximumDamage);
        persistentDataContainer.set(INamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, this.protection);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, this.minimumProtection);
        persistentDataContainer.set(INamespacedKeys.ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, this.maximumProtection);
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

    public String getRegion() {
        return region;
    }

    public SEntity spawn(Location location, boolean randomEverything) {
        if (randomEverything){
            setHealth(0.0, true);
            setDamage(0.0, true);
            setExp(0.0, true);
            setProtection(0.0, true);
        }
        World world = location.getWorld();
        assert entityType.getEntityClass() != null;
        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = regionContainer.createQuery();
        ApplicableRegionSet regions = query.getApplicableRegions(BukkitAdapter.adapt(location));
        if (!(errors)) {
            if (this.region != null) {
                for (ProtectedRegion region : regions) {
                    if (region.getId().equals(this.region)) {
                        if (!spawned) {
                            world.spawn(location, entityType.getEntityClass(), consumer -> {
                                if (consumer instanceof LivingEntity) {
                                    LivingEntity consumerLiving = (LivingEntity) consumer;
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
                                }
                            });
                            spawned = true;
                        }
                    }
                }
                return this;
            }
            world.spawn(location, entityType.getEntityClass(), consumer -> {
                if (consumer instanceof LivingEntity) {
                    LivingEntity consumerLiving = (LivingEntity) consumer;
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
                }
            });
        }
        return this;
    }

}