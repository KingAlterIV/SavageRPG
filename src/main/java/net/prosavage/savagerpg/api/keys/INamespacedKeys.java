package net.prosavage.savagerpg.api.keys;

import org.bukkit.NamespacedKey;

public final class INamespacedKeys {

    private static final net.prosavage.savagerpg.SavageRPG PLUGIN = net.prosavage.savagerpg.SavageRPG.getInstance();

<<<<<<< HEAD
    public static final NamespacedKey ITEM_NAME = create("item_name");
    public static final NamespacedKey ITEM_MATERIAL = create("item_material");
    public static final NamespacedKey ITEM_RARITY = create("item_rarity");
    public static final NamespacedKey ITEM_CHANCE = create("item_chance");
    public static final NamespacedKey ITEM_LORE = create("item_lore");
    public static final NamespacedKey ITEM_LEVEL = create("item_level");
    public static final NamespacedKey ITEM_MAX_DAMAGE = create("item_max_damage");
    public static final NamespacedKey ITEM_MIN_DAMAGE = create("item_min_damage");
    public static final NamespacedKey ITEM_GEM = create("item_gem");
    public static final NamespacedKey ITEM_SCROLL = create("item_scroll");
    public static final NamespacedKey ITEM_ABIILTY_COOLDOWN = create("item_ability_cooldown");
    public static final NamespacedKey ITEM_ABIILTY_NAME = create("item_ability_name");
    public static final NamespacedKey ITEM_ABIILTY_DESCRIPTION = create("item_ability_description");
    public static final NamespacedKey ITEM_ABIILTY_IS_LEFT_ACTION = create("item_ability_is_left_action");
    public static final NamespacedKey ITEM_ABIILTY_IS_RIGHT_ACTION = create("item_ability_is_right_action");
    public static final NamespacedKey ITEM_ABIILTY_IS_DROP_ACTION = create("item_ability_is_droppable_action");
    public static final NamespacedKey ITEM_ABIILTY_MANA_COST = create("item_ability_mana_cost");

    public static final NamespacedKey CREATOR_ITEM_WEAPON_FILE_NAME = create("creator_weapon_file_name");
    public static final NamespacedKey CREATOR_ITEM_MATERIAL_TYPE = create("creator_material_type");
    public static final NamespacedKey CREATOR_ITEM_MATERIAL_LORE_TYPE = create("creator_material_lore_type");
    public static final NamespacedKey CREATOR_ITEM_RARITY = create("creator_rarity_type");
    public static final NamespacedKey CREATOR_ITEM_LEVEL = create("creator_level");
    public static final NamespacedKey CREATOR_ITEM_MINIMUM_DAMAGE = create("creator_minimum_damage");
    public static final NamespacedKey CREATOR_ITEM_MAXIMUM_DAMAGE = create("creator_maximum_damage");
    public static final NamespacedKey CREATOR_ITEM_ATTACK_COOLDOWN = create("creator_attack_cooldown");
    public static final NamespacedKey CREATOR_ITEM_SCROLL_AMOUNT = create("creator_scroll_amount");
    public static final NamespacedKey CREATOR_ITEM_GEM_AMOUNT = create("creator_gem_amount");
    public static final NamespacedKey CREATOR_ITEM_ABILITY_NAME = create("creator_ability_name");
    public static final NamespacedKey CREATOR_ITEM_ABILITY_CAST_TYPE = create("creator_ability_cast_type");
    public static final NamespacedKey CREATOR_ITEM_ABILITY_ACTION_TYPE = create("creator_ability_action_type");
    public static final NamespacedKey CREATOR_ITEM_ABILITY_COOLDOWN = create("creator_ability_cooldown");
    public static final NamespacedKey CREATOR_ITEM_ABILITY_MANA_COST = create("creator_ability_mana_cost");
    public static final NamespacedKey CREATOR_ITEM_SAVE_TO_FILE = create("creator_save_to_file");
    public static final NamespacedKey CREATOR_ITEM_GIVE_ITEM = create("creator_give_item");
<<<<<<< HEAD
=======
    public static final NamespacedKey CREATOR_ITEM_PLAYER = create("creator_weapon_player");

    public static final NamespacedKey[] ALL_ITEM_NAME_SPACED_KEYS = {INamespacedKeys.ITEM_NAME, INamespacedKeys.ITEM_MATERIAL,
            INamespacedKeys.ITEM_RARITY, INamespacedKeys.ITEM_CHANCE, INamespacedKeys.ITEM_BACKGROUND_LORE, INamespacedKeys.ITEM_LEVEL,
            INamespacedKeys.ITEM_MAXIMUM_DAMAGE, INamespacedKeys.ITEM_MINIMUM_DAMAGE, INamespacedKeys.ITEM_SCROLL, INamespacedKeys.ITEM_GEM,
            INamespacedKeys.ITEM_ABIILTY_COOLDOWN, INamespacedKeys.ITEM_ABIILTY_NAME, INamespacedKeys.ITEM_ABIILTY_DESCRIPTION, INamespacedKeys.ITEM_ABIILTY_IS_LEFT_ACTION,
            INamespacedKeys.ITEM_ABIILTY_IS_RIGHT_ACTION, INamespacedKeys.ITEM_ABIILTY_IS_DROP_ACTION, INamespacedKeys.ITEM_ABIILTY_MANA_COST, INamespacedKeys.ITEM_IS_SPAWNED_IN, INamespacedKeys.CREATOR_ITEM_PLAYER};

    public static final PersistentDataType[] ALL_ITEM_DATA_TYPE = {PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.STRING, PersistentDataType.DOUBLE, PersistentDataType.STRING, PersistentDataType.INTEGER,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE, PersistentDataType.INTEGER, PersistentDataType.INTEGER,
            PersistentDataType.DOUBLE, PersistentDataType.STRING, PersistentDataType.STRING, PersistentDataType.BYTE,
            PersistentDataType.BYTE, PersistentDataType.BYTE, PersistentDataType.DOUBLE, PersistentDataType.BYTE, PersistentDataType.STRING};
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
=======
    public static final NamespacedKey WEAPON_NAME = create("weapon_name");
    public static final NamespacedKey WEAPON_MATERIAL = create("weapon_material");
    public static final NamespacedKey WEAPON_RARITY = create("weapon_rarity");
    public static final NamespacedKey WEAPON_CHANCE = create("weapon_chance");
    public static final NamespacedKey WEAPON_BACKGROUND_LORE = create("weapon_background_lore");
    public static final NamespacedKey WEAPON_LEVEL = create("weapon_level");
    public static final NamespacedKey WEAPON_MAXIMUM_DAMAGE = create("weapon_maximum_damage");
    public static final NamespacedKey WEAPON_MINIMUM_DAMAGE = create("weapon_minimum_damage");
    public static final NamespacedKey WEAPON_GEM = create("weapon_gem");
    public static final NamespacedKey WEAPON_SCROLL = create("weapon_scroll");
    public static final NamespacedKey WEAPON_ABIILTY_COOLDOWN = create("weapon_ability_cooldown");
    public static final NamespacedKey WEAPON_ABIILTY_NAME = create("weapon_ability_name");
    public static final NamespacedKey WEAPON_ABIILTY_DESCRIPTION = create("weapon_ability_description");
    public static final NamespacedKey WEAPON_ABIILTY_IS_LEFT_ACTION = create("weapon_ability_is_left_action");
    public static final NamespacedKey WEAPON_ABIILTY_IS_RIGHT_ACTION = create("weapon_ability_is_right_action");
    public static final NamespacedKey WEAPON_ABIILTY_IS_DROP_ACTION = create("weapon_ability_is_droppable_action");
    public static final NamespacedKey WEAPON_ABIILTY_MANA_COST = create("weapon_ability_mana_cost");
    public static final NamespacedKey WEAPON_IS_SPAWNED_IN = create("weapon_is_spawned_in");

    public static final NamespacedKey CREATOR_WEAPON_NAME = create("creator_weapon_name");
    public static final NamespacedKey CREATOR_WEAPON_MATERIAL_TYPE = create("creator_material_type");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_MATERIAL_TYPE = create("creator_background_material_type");
    public static final NamespacedKey CREATOR_WEAPON_RARITY = create("creator_rarity_type");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE = create("creator_weapon_background_lore");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE_1 = create("creator_weapon_background_lore_1");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE_2 = create("creator_weapon_background_lore_2");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE_3 = create("creator_weapon_background_lore_3");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE_4 = create("creator_weapon_background_lore_4");
    public static final NamespacedKey CREATOR_WEAPON_BACKGROUND_LORE_5 = create("creator_weapon_background_lore_5");
    public static final NamespacedKey CREATOR_WEAPON_LEVEL = create("creator_level");
    public static final NamespacedKey CREATOR_WEAPON_MINIMUM_DAMAGE = create("creator_minimum_damage");
    public static final NamespacedKey CREATOR_WEAPON_MAXIMUM_DAMAGE = create("creator_maximum_damage");
    public static final NamespacedKey CREATOR_WEAPON_ATTACK_COOLDOWN = create("creator_attack_cooldown");
    public static final NamespacedKey CREATOR_WEAPON_SCROLL_AMOUNT = create("creator_scroll_amount");
    public static final NamespacedKey CREATOR_WEAPON_GEM_AMOUNT = create("creator_gem_amount");
    public static final NamespacedKey CREATOR_WEAPON_ABILITY_NAME = create("creator_ability_name");
    public static final NamespacedKey CREATOR_WEAPON_GIVE_ITEM = create("creator_give_item");
    public static final NamespacedKey CREATOR_WEAPON_PLAYER = create("creator_weapon_player");

    public static final NamespacedKey ARMOR_NAME = create("armor_name");
    public static final NamespacedKey ARMOR_MATERIAL = create("armor_material");
    public static final NamespacedKey ARMOR_RARITY = create("armor_rarity");
    public static final NamespacedKey ARMOR_CHANCE = create("armor_chance");
    public static final NamespacedKey ARMOR_BACKGROUND_LORE = create("armor_background_lore");
    public static final NamespacedKey ARMOR_LEVEL = create("armor_level");
    public static final NamespacedKey ARMOR_MINIMUM_PROTECTION = create("armor_minimum_protection");
    public static final NamespacedKey ARMOR_MAXIMUM_PROTECTION = create("armor_maximum_protection");
    public static final NamespacedKey ARMOR_PROTECTION = create("armor_protection");
    public static final NamespacedKey ARMOR_MINIMUM_HEALTH = create("armor_minimum_health");
    public static final NamespacedKey ARMOR_MAXIMUM_HEALTH = create("armor_maximum_health");
    public static final NamespacedKey ARMOR_HEALTH = create("armor_health");
    public static final NamespacedKey ARMOR_MINIMUM_REGEN = create("armor_minimum_regen");
    public static final NamespacedKey ARMOR_MAXIMUM_REGEN = create("armor_maximum_regen");
    public static final NamespacedKey ARMOR_REGEN = create("armor_regen");
    public static final NamespacedKey ARMOR_GEM = create("armor_gem");
    public static final NamespacedKey ARMOR_SCROLL = create("armor_scroll");
    public static final NamespacedKey ARMOR_IS_SPAWNED_IN = create("armor_is_spawned_in");

    public static final NamespacedKey CREATOR_ARMOR_NAME = create("creator_armor_name");
    public static final NamespacedKey CREATOR_ARMOR_MATERIAL_TYPE = create("creator_material_type");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_MATERIAL_TYPE = create("creator_background_material_type");
    public static final NamespacedKey CREATOR_ARMOR_RARITY = create("creator_rarity_type");
    public static final NamespacedKey CREATOR_ARMOR_LEVEL = create("creator_level");
    public static final NamespacedKey CREATOR_ARMOR_MINIMUM_PROTECTION = create("creator_armor_minimum_protection");
    public static final NamespacedKey CREATOR_ARMOR_MAXIMUM_PROTECTION = create("creator_armor_maximum_protection");
    public static final NamespacedKey CREATOR_ARMOR_MINIMUM_HEALTH = create("creator_armor_minimum_health");
    public static final NamespacedKey CREATOR_ARMOR_MAXIMUM_HEALTH = create("creator_armor_maximum_health");
    public static final NamespacedKey CREATOR_ARMOR_MINIMUM_REGEN = create("creator_armor_minimum_regen");
    public static final NamespacedKey CREATOR_ARMOR_MAXIMUM_REGEN = create("creator_armor_maximum_regen");
    public static final NamespacedKey CREATOR_ARMOR_SCROLL_AMOUNT = create("creator_scroll_amount");
    public static final NamespacedKey CREATOR_ARMOR_GEM_AMOUNT = create("creator_gem_amount");
    public static final NamespacedKey CREATOR_ARMOR_GIVE_ITEM = create("creator_give_armor");
    public static final NamespacedKey CREATOR_ARMOR_PLAYER = create("creator_armor_player");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE = create("creator_armor_background_lore");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE_1 = create("creator_armor_background_lore_1");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE_2 = create("creator_armor_background_lore_2");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE_3 = create("creator_armor_background_lore_3");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE_4 = create("creator_armor_background_lore_4");
    public static final NamespacedKey CREATOR_ARMOR_BACKGROUND_LORE_5 = create("creator_armor_background_lore_5");

    public static final NamespacedKey ENTITY_NAME = create("entity_name");
    public static final NamespacedKey ENTITY_LEVEL = create("entity_level");
    public static final NamespacedKey ENTITY_REGION = create("entity_health");
    public static final NamespacedKey ENTITY_HEALTH = create("entity_region");
    public static final NamespacedKey ENTITY_MINIMUM_HEALTH = create("entity_minimum_health");
    public static final NamespacedKey ENTITY_MAXIMUM_HEALTH = create("entity_maximum_health");
    public static final NamespacedKey ENTITY_EXP = create("entity_exp");
    public static final NamespacedKey ENTITY_MINIMUM_EXP = create("entity_minimum_exp");
    public static final NamespacedKey ENTITY_MAXIMUM_EXP = create("entity_maximum_exp");
    public static final NamespacedKey ENTITY_DAMAGE = create("entity_damage");
    public static final NamespacedKey ENTITY_MINIMUM_DAMAGE = create("entity_minimum_damage");
    public static final NamespacedKey ENTITY_MAXIMUM_DAMAGE = create("entity_maximum_damage");
    public static final NamespacedKey ENTITY_PROTECTION = create("entity_protection");
    public static final NamespacedKey ENTITY_MINIMUM_PROTECTION = create("entity_minimum_protection");
    public static final NamespacedKey ENTITY_MAXIMUM_PROTECTION = create("entity_maximum_protection");

    public static final NamespacedKey CREATOR_ENTITY_TYPE = create("creator_entity_type");
    public static final NamespacedKey CREATOR_ENTITY_NAME = create("creator_entity_name");
    public static final NamespacedKey CREATOR_ENTITY_LEVEL = create("creator_entity_level");
    public static final NamespacedKey CREATOR_ENTITY_REGION = create("creator_entity_region");
    public static final NamespacedKey CREATOR_ENTITY_HEALTH = create("creator_entity_health");
    public static final NamespacedKey CREATOR_ENTITY_MINIMUM_EXP = create("creator_entity_minimum_exp");
    public static final NamespacedKey CREATOR_ENTITY_MAXIMUM_EXP = create("creator_entity_maximum_exp");
    public static final NamespacedKey CREATOR_ENTITY_MINIMUM_DAMAGE = create("creator_entity_minimum_damage");
    public static final NamespacedKey CREATOR_ENTITY_MAXIMUM_DAMAGE = create("creator_entity_maximum_damage");
    public static final NamespacedKey CREATOR_ENTITY_MINIMUM_PROTECTION = create("creator_entity_minimum_protection");
    public static final NamespacedKey CREATOR_ENTITY_MAXIMUM_PROTECTION = create("creator_entity_maximum_protection");
    public static final NamespacedKey CREATOR_ENTITY_HELMET = create("creator_entity_helmet");
    public static final NamespacedKey CREATOR_ENTITY_CHESTPLATE = create("creator_entity_chestplate");
    public static final NamespacedKey CREATOR_ENTITY_LEGGINGS = create("creator_entity_leggings");
    public static final NamespacedKey CREATOR_ENTITY_BOOTS = create("creator_entity_boots");
    public static final NamespacedKey CREATOR_ENTITY_HELD_ITEM = create("creator_entity_held_item");
    public static final NamespacedKey CREATOR_ENTITY_SPAWN_ENTITY = create("creator_entity_spawn_entity");

    public static final NamespacedKey[] ALL_ITEM_NAME_SPACED_KEYS = {
            // This is for weapons

            INamespacedKeys.WEAPON_NAME, INamespacedKeys.WEAPON_MATERIAL
            , INamespacedKeys.WEAPON_RARITY, INamespacedKeys.WEAPON_CHANCE, INamespacedKeys.WEAPON_BACKGROUND_LORE
            , INamespacedKeys.WEAPON_LEVEL, INamespacedKeys.WEAPON_MAXIMUM_DAMAGE, INamespacedKeys.WEAPON_MINIMUM_DAMAGE,
            INamespacedKeys.WEAPON_GEM, INamespacedKeys.WEAPON_SCROLL, INamespacedKeys.WEAPON_ABIILTY_COOLDOWN,
            INamespacedKeys.WEAPON_ABIILTY_NAME, INamespacedKeys.WEAPON_ABIILTY_DESCRIPTION,
            INamespacedKeys.WEAPON_ABIILTY_IS_LEFT_ACTION, INamespacedKeys.WEAPON_ABIILTY_IS_RIGHT_ACTION,
            INamespacedKeys.WEAPON_ABIILTY_IS_DROP_ACTION, INamespacedKeys.WEAPON_ABIILTY_MANA_COST,
            INamespacedKeys.WEAPON_IS_SPAWNED_IN, INamespacedKeys.CREATOR_WEAPON_PLAYER,

            // This is for armors
            INamespacedKeys.ARMOR_NAME, INamespacedKeys.ARMOR_MATERIAL, INamespacedKeys.ARMOR_RARITY,
            INamespacedKeys.ARMOR_CHANCE, INamespacedKeys.ARMOR_BACKGROUND_LORE, INamespacedKeys.ARMOR_LEVEL,
            INamespacedKeys.ARMOR_MINIMUM_PROTECTION, INamespacedKeys.ARMOR_MAXIMUM_PROTECTION, INamespacedKeys.ARMOR_PROTECTION,
            INamespacedKeys.ARMOR_MINIMUM_HEALTH, INamespacedKeys.ARMOR_MAXIMUM_HEALTH, INamespacedKeys.ARMOR_HEALTH,
            INamespacedKeys.ARMOR_MINIMUM_REGEN, INamespacedKeys.ARMOR_MAXIMUM_REGEN, INamespacedKeys.ARMOR_REGEN,
            INamespacedKeys.ARMOR_GEM, INamespacedKeys.ARMOR_SCROLL, INamespacedKeys.ARMOR_IS_SPAWNED_IN,
            INamespacedKeys.CREATOR_ARMOR_PLAYER
    };

    public static final PersistentDataType[] ALL_ITEM_DATA_TYPE = {
            // This is for weapons
            PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.STRING, PersistentDataType.DOUBLE, PersistentDataType.STRING,
            PersistentDataType.INTEGER, PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.INTEGER, PersistentDataType.INTEGER, PersistentDataType.DOUBLE,
            PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.BYTE, PersistentDataType.BYTE,
            PersistentDataType.BYTE, PersistentDataType.DOUBLE,
            PersistentDataType.BYTE, PersistentDataType.STRING,

            // This is for armors
            PersistentDataType.STRING, PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.DOUBLE, PersistentDataType.STRING, PersistentDataType.INTEGER,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.INTEGER, PersistentDataType.INTEGER, PersistentDataType.BYTE,
            PersistentDataType.STRING
    };
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things

    private INamespacedKeys() { }

    private static NamespacedKey create(String path) {
        return new NamespacedKey(PLUGIN, "savagerpg_" + path);
    }

}