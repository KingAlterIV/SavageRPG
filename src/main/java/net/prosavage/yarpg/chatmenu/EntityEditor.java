package net.prosavage.yarpg.chatmenu;

import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.ChatMenu;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.BooleanElement;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.ButtonElement;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.InputElement;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.TextElement;
import net.prosavage.yarpg.api.YCreator;
import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import net.prosavage.yarpg.builders.entities.YEntities;
import net.prosavage.yarpg.utils.Color;
import net.prosavage.yarpg.utils.INumber;
import net.prosavage.yarpg.utils.NullValues;
import net.prosavage.yarpg.utils.chatmenu.MenuElements;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class EntityEditor {

    private net.prosavage.yarpg.utils.INumber INumber = new INumber();
    private net.prosavage.yarpg.utils.Color Color = new Color();
    private net.prosavage.yarpg.utils.NullValues NullValues = new NullValues();

    public void openMenu(Player player) {
        ChatMenu menu = new ChatMenu().pauseChat();
        menu = setMenuContent(menu, player, 1);
        menu.openFor(player);
    }

    private ButtonElement setPageMenuContent(ChatMenu menu, Player player, int x, int y, String text, int page){
        return new ButtonElement(x, y, ChatColor.GREEN + text, player1 -> {
            new MenuElements(player, menu).clear();
            setMenuContent(menu, player, page);
            menu.refresh();
        });
    }

    public ChatMenu setMenuContent(ChatMenu menu, Player player, int page) {
        YCreator yCreator = new YCreator(player);
        MenuElements menuElements = new MenuElements(player, menu);
        menu.setAutoUnregister(true);
        menu.add(menuElements.addElement(player, closeDefaultMenu(menu, player)));
        menu.add(menuElements.addElement(player, new TextElement(0, 16, "Spawn entity? ")));
        menu.add(menuElements.addElement(player, spawnEntity(player)));
        if (page <= 1) {
            menu.add(menuElements.addElement(player, new TextElement(0, 6, "Entity type: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 8, "Entity name: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 10, "Entity region: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Entity max health: ")));
            menu.add(menuElements.addElement(player, entityTypeInput(player, Color.ify((String) NullValues.replaceNullValues(yCreator.getPersistentEntityTypeInput())))));
            menu.add(menuElements.addElement(player, entityNameInput(player, Color.ify((String) NullValues.replaceNullValues(yCreator.getPersistentEntityNameInput())))));
            menu.add(menuElements.addElement(player, entityRegionInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityRegionInput()))));
            menu.add(menuElements.addElement(player, entityHealthInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityHealthInput())))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 200, 18, "»", page + 1)));
        }
        if (page == 2) {
            menu.add(menuElements.addElement(player, new TextElement(0, 0, "Level: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 2, "Minimum exp: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 4, "Maximum exp: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 6, "Minimum damage: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 8, "Maximum damage: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 10, "Minimum protection: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Maximum protection: ")));
            menu.add(menuElements.addElement(player, entityLevelInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityLevelInput())))));
            menu.add(menuElements.addElement(player, entityMinimumEXPInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMinimumEXPInput())))));
            menu.add(menuElements.addElement(player, entityMaximumEXPInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMaximumEXPInput())))));
            menu.add(menuElements.addElement(player, entityMinimumDamageInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMinimumDamageInput())))));
            menu.add(menuElements.addElement(player, entityMaximumDamageInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMaximumDamageInput())))));
            menu.add(menuElements.addElement(player, entityMinimumProtectionInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMinimumProtectionInput())))));
            menu.add(menuElements.addElement(player, entityMaximumProtectionInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentEntityMaximumProtectionInput())))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 200, 18, "»", page + 1)));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 0, 18, "«", page - 1)));
        }
        if (page == 3) {
            menu.add(menuElements.addElement(player, new TextElement(0, 4, "Main hand: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 6, "Helmet: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 8, "Chestplate: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 10, "Leggings: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Boots: ")));
            menu.add(menuElements.addElement(player, entityHeldItemInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityHeldItemInput()))));
            menu.add(menuElements.addElement(player, entityHelmetInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityHelmetInput()))));
            menu.add(menuElements.addElement(player, entityChestplateInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityChestplateInput()))));
            menu.add(menuElements.addElement(player, entityLeggingsInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityLeggingsInput()))));
            menu.add(menuElements.addElement(player, entityBootsInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentEntityBootsInput()))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 0, 18, "«", page - 1)));
        }
        return menu;
    }

    private ButtonElement closeDefaultMenu(ChatMenu menu, Player player) {
        return new ButtonElement(100, 18, ChatColor.RED + "[Close]", player1 -> {
            menu.setPauseChat(false);
            menu.close(player);
            YCreator yCreator = new YCreator(player);
            if (yCreator.getPersistentEntitySpawnInput() == (byte) 1) {
                YEntities mob = new YEntities(yCreator.getPersistentEntityTypeInput(), yCreator.getPersistentEntityNameInput())
                        .setMaximumHealth(yCreator.getPersistentEntityHealthInput())
                        .setMinimumExp(yCreator.getPersistentEntityMinimumEXPInput())
                        .setMaximumExp(yCreator.getPersistentEntityMaximumEXPInput())
                        .setMinimumDamage(yCreator.getPersistentEntityMinimumDamageInput())
                        .setMaximumDamage(yCreator.getPersistentEntityMaximumDamageInput())
                        .setMinimumProtection(yCreator.getPersistentEntityMinimumProtectionInput())
                        .setMaximumProtection(yCreator.getPersistentEntityMaximumProtectionInput())
                        .setHeldItem(yCreator.getPersistentEntityHeldItemInput())
                        .setHelmet(yCreator.getPersistentEntityHelmetInput())
                        .setChestplate(yCreator.getPersistentEntityChestplateInput())
                        .setLeggings(yCreator.getPersistentEntityLeggingsInput())
                        .setBoots(yCreator.getPersistentEntityBootsInput())
                        .setHealth(0.0, true)
                        .setExp(0.0, true)
                        .setDamage(0.0, true)
                        .setProtection(0.0, true);
                mob.spawn(player.getLocation(), false);
            }
            player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_SPAWN_ENTITY, PersistentDataType.BYTE, (byte) 0);
        });
    }

    private BooleanElement spawnEntity(Player player) {
        BooleanElement entitySpawnEntityInput = new BooleanElement(75, 16, false);
        entitySpawnEntityInput.value.setChangeCallback(state -> {
            byte byteValue = 0;
            Boolean currentValue = state.getCurrent();
            if (currentValue == Boolean.TRUE) {
                byteValue = 1;
            }
            player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_SPAWN_ENTITY, PersistentDataType.BYTE, byteValue);
        });
        return entitySpawnEntityInput;
    }

    private InputElement entityTypeInput(Player player, String value) {
        InputElement entityTypeInput = new InputElement(100, 6, 200, value);
        entityTypeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return entityTypeInput;
    }

    private InputElement entityNameInput(Player player, String value) {
        InputElement entityNameInput = new InputElement(100, 8, 200, value);
        entityNameInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_NAME, PersistentDataType.STRING, currentValue);
            }
        });
        return entityNameInput;
    }

    private InputElement entityRegionInput(Player player, String value) {
        InputElement entityRegionInput = new InputElement(100, 10, 200, value);
        entityRegionInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_REGION, PersistentDataType.STRING, currentValue);
            }
        });
        return entityRegionInput;
    }

    private InputElement entityHealthInput(Player player, String value) {
        InputElement entityHealthInput = new InputElement(100, 12, 200, value);
        entityHealthInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_HEALTH, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityHealthInput;
    }

    private InputElement entityLevelInput(Player player, String value) {
        InputElement entityLevelInput = new InputElement(100, 0, 100, value);
        entityLevelInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_LEVEL, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return entityLevelInput;
    }

    private InputElement entityMinimumEXPInput(Player player, String value) {
        InputElement entityMaximumDamageInput = new InputElement(100, 2, 100, value);
        entityMaximumDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_EXPERIENCE, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMaximumDamageInput;
    }

    private InputElement entityMaximumEXPInput(Player player, String value) {
        InputElement entityMaximumDamageInput = new InputElement(100, 4, 100, value);
        entityMaximumDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMaximumDamageInput;
    }

    private InputElement entityMinimumDamageInput(Player player, String value) {
        InputElement entityMinimumDamageInput = new InputElement(100, 6, 100, value);
        entityMinimumDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMinimumDamageInput;
    }

    private InputElement entityMaximumDamageInput(Player player, String value) {
        InputElement entityMaximumDamageInput = new InputElement(100, 8, 100, value);
        entityMaximumDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMaximumDamageInput;
    }

    private InputElement entityMinimumProtectionInput(Player player, String value) {
        InputElement entityMinimumProtectionInput = new InputElement(100, 10, 100, value);
        entityMinimumProtectionInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMinimumProtectionInput;
    }

    private InputElement entityMaximumProtectionInput(Player player, String value) {
        InputElement entityMaximumDamageInput = new InputElement(100, 12, 100, value);
        entityMaximumDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMaximumDamageInput;
    }

    private InputElement entityHeldItemInput(Player player, String value) {
        InputElement entityHeldItemInput = new InputElement(100, 4, 100, value);
        entityHeldItemInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_HELD_ITEM, PersistentDataType.STRING, currentValue);
            }
        });
        return entityHeldItemInput;
    }

    private InputElement entityHelmetInput(Player player, String value) {
        InputElement entityHelmetInput = new InputElement(100, 6, 100, value);
        entityHelmetInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_HELMET, PersistentDataType.STRING, currentValue);
            }
        });
        return entityHelmetInput;
    }

    private InputElement entityChestplateInput(Player player, String value) {
        InputElement entityChestplateInput = new InputElement(100, 8, 100, value);
        entityChestplateInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_CHESTPLATE, PersistentDataType.STRING, currentValue);
            }
        });
        return entityChestplateInput;
    }

    private InputElement entityLeggingsInput(Player player, String value) {
        InputElement entityLeggingsInput = new InputElement(100, 10, 100, value);
        entityLeggingsInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_LEGGINGS, PersistentDataType.STRING, currentValue);
            }
        });
        return entityLeggingsInput;
    }

    private InputElement entityBootsInput(Player player, String value) {
        InputElement entityBootsInput = new InputElement(100, 12, 100, value);
        entityBootsInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ENTITY_BOOTS, PersistentDataType.STRING, currentValue);
            }
        });
        return entityBootsInput;
    }
}

