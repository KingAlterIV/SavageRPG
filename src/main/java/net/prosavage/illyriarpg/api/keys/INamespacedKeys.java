package net.prosavage.illyriarpg.api.keys;

import net.prosavage.illyriarpg.IllyriaRPG;
import org.bukkit.NamespacedKey;

public final class INamespacedKeys {

    private static final IllyriaRPG PLUGIN = IllyriaRPG.getInstance();

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

    private INamespacedKeys() { }

    private static NamespacedKey create(String path) {
        return new NamespacedKey(PLUGIN, "savagerpg_" + path);
    }

}