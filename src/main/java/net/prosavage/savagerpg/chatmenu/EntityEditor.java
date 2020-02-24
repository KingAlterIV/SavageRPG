package net.prosavage.savagerpg.chatmenu;

import me.tom.sparse.spigot.chat.menu.ChatMenu;
import me.tom.sparse.spigot.chat.menu.element.BooleanElement;
import me.tom.sparse.spigot.chat.menu.element.ButtonElement;
import me.tom.sparse.spigot.chat.menu.element.InputElement;
import me.tom.sparse.spigot.chat.menu.element.TextElement;
import net.prosavage.savagerpg.api.ICreator;
import net.prosavage.savagerpg.api.keys.INamespacedKeys;
import net.prosavage.savagerpg.builders.entities.SEntity;
import net.prosavage.savagerpg.utils.Color;
import net.prosavage.savagerpg.utils.INumber;
import net.prosavage.savagerpg.utils.NullValues;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityEditor {

    private net.prosavage.savagerpg.utils.INumber INumber = new INumber();
    private net.prosavage.savagerpg.utils.Color Color = new Color();
    private net.prosavage.savagerpg.utils.NullValues NullValues = new NullValues();

    private ButtonElement goToEntityCreateMenu(ChatMenu menu, Player player, int x, int y, String text, int page){
        return new ButtonElement(x, y, ChatColor.GREEN + text, player1 -> {
            menu.setPauseChat(false);
            menu.close(player);
            new BukkitRunnable(){
                @Override
                public void run() {
                    getEntityCreateMenu(player, page);
                }
            }.runTaskLater(net.prosavage.savagerpg.SavageRPG.getInstance(), 1L);
        });
    }

    public void getEntityCreateMenu(Player player, int page){
        ICreator iCreator = new ICreator(player);
        ChatMenu chatMenu = new ChatMenu();
        chatMenu.add(closeDefaultMenu(chatMenu, player));
        chatMenu.add(new TextElement(0, 16, "Spawn entity? "));
        chatMenu.add(spawnEntity(player));
        if (page <= 1) {
            chatMenu.add(new TextElement(0, 6, "Entity type: "));
            chatMenu.add(new TextElement(0, 8, "Entity name: "));
            chatMenu.add(new TextElement(0, 10, "Entity region: "));
            chatMenu.add(new TextElement(0, 12, "Entity max health: "));
            chatMenu.add(entityTypeInput(player, Color.ify((String) NullValues.replaceNullValues(iCreator.getPersistentEntityTypeInput()))));
            chatMenu.add(entityNameInput(player, Color.ify((String) NullValues.replaceNullValues(iCreator.getPersistentEntityNameInput()))));
            chatMenu.add(entityRegionInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityRegionInput())));
            chatMenu.add(entityHealthInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityHealthInput()))));
            chatMenu.add(goToEntityCreateMenu(chatMenu, player, 200, 18, "»", page + 1));
        }
        if (page == 2) {
            chatMenu.add(new TextElement(0, 0, "Level: "));
            chatMenu.add(new TextElement(0, 2, "Minimum exp: "));
            chatMenu.add(new TextElement(0, 4, "Maximum exp: "));
            chatMenu.add(new TextElement(0, 6, "Minimum damage: "));
            chatMenu.add(new TextElement(0, 8, "Maximum damage: "));
            chatMenu.add(new TextElement(0, 10, "Minimum protection: "));
            chatMenu.add(new TextElement(0, 12, "Maximum protection: "));
            chatMenu.add(entityLevelInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityLevelInput()))));
            chatMenu.add(entityMinimumEXPInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMinimumEXPInput()))));
            chatMenu.add(entityMaximumEXPInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMaximumEXPInput()))));
            chatMenu.add(entityMinimumDamageInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMinimumDamageInput()))));
            chatMenu.add(entityMaximumDamageInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMaximumDamageInput()))));
            chatMenu.add(entityMinimumProtectionInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMinimumProtectionInput()))));
            chatMenu.add(entityMaximumProtectionInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentEntityMaximumProtectionInput()))));
            chatMenu.add(goToEntityCreateMenu(chatMenu, player, 200, 18, "»", page + 1));
            chatMenu.add(goToEntityCreateMenu(chatMenu, player, 0, 18, "«", page - 1));
        }
        if (page == 3) {
            chatMenu.add(new TextElement(0, 4, "Main hand: "));
            chatMenu.add(new TextElement(0, 6, "Helmet: "));
            chatMenu.add(new TextElement(0, 8, "Chestplate: "));
            chatMenu.add(new TextElement(0, 10, "Leggings: "));
            chatMenu.add(new TextElement(0, 12, "Boots: "));
            chatMenu.add(entityHeldItemInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityHeldItemInput())));
            chatMenu.add(entityHelmetInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityHelmetInput())));
            chatMenu.add(entityChestplateInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityChestplateInput())));
            chatMenu.add(entityLeggingsInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityLeggingsInput())));
            chatMenu.add(entityBootsInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentEntityBootsInput())));
            chatMenu.add(goToEntityCreateMenu(chatMenu, player, 0, 18, "«", page - 1));
        }
        chatMenu.setPauseChat(true);
        chatMenu.openFor(player);
    }

    private ButtonElement closeDefaultMenu(ChatMenu menu, Player player) {
        return new ButtonElement(100, 18, ChatColor.RED + "[Close]", player1 -> {
            menu.setPauseChat(false);
            menu.close(player);
            for (int i = 0; i < 200; i++) {
                player.sendMessage("\n");
            }
            ICreator iCreator = new ICreator(player);
            if (iCreator.getPersistentEntitySpawnInput() == (byte) 1) {
                SEntity mob = new SEntity(player, iCreator.getPersistentEntityTypeInput(), iCreator.getPersistentEntityNameInput())
                        .setMaximumHealth(iCreator.getPersistentEntityHealthInput())
                        .setMinimumExp(iCreator.getPersistentEntityMinimumEXPInput())
                        .setMaximumExp(iCreator.getPersistentEntityMaximumEXPInput())
                        .setMinimumDamage(iCreator.getPersistentEntityMinimumDamageInput())
                        .setMaximumDamage(iCreator.getPersistentEntityMaximumDamageInput())
                        .setMinimumProtection(iCreator.getPersistentEntityMinimumProtectionInput())
                        .setMaximumProtection(iCreator.getPersistentEntityMaximumProtectionInput())
                        .setHeldItem(iCreator.getPersistentEntityHeldItemInput())
                        .setHelmet(iCreator.getPersistentEntityHelmetInput())
                        .setChestplate(iCreator.getPersistentEntityChestplateInput())
                        .setLeggings(iCreator.getPersistentEntityLeggingsInput())
                        .setBoots(iCreator.getPersistentEntityBootsInput())
                        .setHealth(0.0, true)
                        .setExp(0.0, true)
                        .setDamage(0.0, true)
                        .setProtection(0.0, true);
                mob.spawn(player.getLocation(), false);
            }
            player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_SPAWN_ENTITY, PersistentDataType.BYTE, (byte) 0);
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
            player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_SPAWN_ENTITY, PersistentDataType.BYTE, byteValue);
        });
        return entitySpawnEntityInput;
    }

    private InputElement entityTypeInput(Player player, String value) {
        InputElement entityTypeInput = new InputElement(100, 6, 200, value);
        entityTypeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return entityTypeInput;
    }

    private InputElement entityNameInput(Player player, String value) {
        InputElement entityNameInput = new InputElement(100, 8, 200, value);
        entityNameInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_NAME, PersistentDataType.STRING, currentValue);
            }
        });
        return entityNameInput;
    }

    private InputElement entityRegionInput(Player player, String value) {
        InputElement entityRegionInput = new InputElement(100, 10, 200, value);
        entityRegionInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_REGION, PersistentDataType.STRING, currentValue);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_HEALTH, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_LEVEL, PersistentDataType.INTEGER, currentValueInt);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MINIMUM_EXP, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MAXIMUM_EXP, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, currentValueDouble);
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
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return entityMaximumDamageInput;
    }

    private InputElement entityHeldItemInput(Player player, String value) {
        InputElement entityHeldItemInput = new InputElement(100, 4, 100, value);
        entityHeldItemInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_HELD_ITEM, PersistentDataType.STRING, currentValue);
            }
        });
        return entityHeldItemInput;
    }

    private InputElement entityHelmetInput(Player player, String value) {
        InputElement entityHelmetInput = new InputElement(100, 6, 100, value);
        entityHelmetInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_HELMET, PersistentDataType.STRING, currentValue);
            }
        });
        return entityHelmetInput;
    }

    private InputElement entityChestplateInput(Player player, String value) {
        InputElement entityChestplateInput = new InputElement(100, 8, 100, value);
        entityChestplateInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_CHESTPLATE, PersistentDataType.STRING, currentValue);
            }
        });
        return entityChestplateInput;
    }

    private InputElement entityLeggingsInput(Player player, String value) {
        InputElement entityLeggingsInput = new InputElement(100, 10, 100, value);
        entityLeggingsInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_LEGGINGS, PersistentDataType.STRING, currentValue);
            }
        });
        return entityLeggingsInput;
    }

    private InputElement entityBootsInput(Player player, String value) {
        InputElement entityBootsInput = new InputElement(100, 12, 100, value);
        entityBootsInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ENTITY_BOOTS, PersistentDataType.STRING, currentValue);
            }
        });
        return entityBootsInput;
    }
}

