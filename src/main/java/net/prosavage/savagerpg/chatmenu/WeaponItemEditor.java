package net.prosavage.savagerpg.chatmenu;

import me.tom.sparse.spigot.chat.menu.ChatMenu;
import me.tom.sparse.spigot.chat.menu.element.BooleanElement;
import me.tom.sparse.spigot.chat.menu.element.ButtonElement;
import me.tom.sparse.spigot.chat.menu.element.InputElement;
import me.tom.sparse.spigot.chat.menu.element.TextElement;
<<<<<<< HEAD:src/main/java/net/prosavage/illyriarpg/chatmenu/WeaponItemEditor.java
import net.prosavage.illyriarpg.IllyriaRPG;
import net.prosavage.illyriarpg.api.ICreator;
import net.prosavage.illyriarpg.api.files.IAbilityFiles;
import net.prosavage.illyriarpg.api.keys.INamespacedKeys;
import net.prosavage.illyriarpg.builder.Weapon;
import net.prosavage.illyriarpg.utils.Color;
import net.prosavage.illyriarpg.utils.Number;
=======
import net.prosavage.savagerpg.api.ICreator;
import net.prosavage.savagerpg.api.keys.INamespacedKeys;
import net.prosavage.savagerpg.builders.files.AbilityFiles;
import net.prosavage.savagerpg.builders.itemstacks.Weapon;
import net.prosavage.savagerpg.utils.NullValues;
import net.prosavage.savagerpg.utils.Color;
import net.prosavage.savagerpg.utils.INumber;
>>>>>>> 71fac37... Renamed things back, new & better files manager, more stuff fixed.:src/main/java/net/prosavage/savagerpg/chatmenu/WeaponItemEditor.java
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class WeaponItemEditor {
<<<<<<< HEAD:src/main/java/net/prosavage/illyriarpg/chatmenu/WeaponItemEditor.java
    private net.prosavage.illyriarpg.utils.Number Number = new Number();
    private net.prosavage.illyriarpg.utils.Color Color = new Color();
<<<<<<< HEAD
=======
    private NullValues NullValues = new NullValues();
    private IAbilityFiles IAbilityFiles = new IAbilityFiles();
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
=======

    private INumber INumber = new INumber();
    private Color Color = new Color();
    private NullValues NullValues = new NullValues();
>>>>>>> 71fac37... Renamed things back, new & better files manager, more stuff fixed.:src/main/java/net/prosavage/savagerpg/chatmenu/WeaponItemEditor.java

    private ButtonElement goToWeaponCreateMenu(ChatMenu menu, Player player, int x, int y, String text, int page){
        return new ButtonElement(x, y, ChatColor.GREEN + text, player1 -> {
            menu.setPauseChat(false);
            menu.close(player);
            new BukkitRunnable(){
                @Override
                public void run() {
                    getWeaponCreateMenu(player, page);
                }
            }.runTaskLater(net.prosavage.savagerpg.SavageRPG.getInstance(), 1L);
        });
    }

    public void getWeaponCreateMenu(Player player, int page){
        ICreator iCreator = new ICreator(player, true);
        ChatMenu chatMenu = new ChatMenu();
        chatMenu.add(closeDefaultMenu(chatMenu, player));
        chatMenu.add(new TextElement(0, 16, "Give item? "));
        chatMenu.add(giveItem(player));
        if (page <= 1) {
<<<<<<< HEAD
            chatMenu.add(new TextElement(0, 10, "Weapon name: "));
            chatMenu.add(new TextElement(0, 12, "Item rarity: "));
            chatMenu.add(new TextElement(0, 14, "Actual item type: "));
            chatMenu.add(weaponFileNameInput(player, Color.ify(iCreator.getPersistentFileName())));
            chatMenu.add(weaponRarityInput(player, iCreator.getPersistentRarityName()));
            chatMenu.add(weaponMaterialTypeInput(player, iCreator.getPersistentMaterialType()));
=======
            chatMenu.add(new TextElement(0, 8, "Weapon name: "));
            chatMenu.add(new TextElement(0, 10, "Item rarity: "));
            chatMenu.add(new TextElement(0, 12, "Actual item type: "));
            chatMenu.add(new TextElement(0, 14, "Display item type: "));
            chatMenu.add(weaponFileNameInput(player, Color.ify((String) NullValues.replaceNullValues(iCreator.getPersistentWeaponFileName()))));
            chatMenu.add(weaponRarityInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponRarityName())));
            chatMenu.add(weaponMaterialTypeInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponMaterialType())));
            chatMenu.add(weaponDisplayMaterialTypeInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundMaterialType())));
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 200, 18, "»", page + 1));
        }
        if (page == 2){
            chatMenu.add(new TextElement(0, 8, "Level input: "));
            chatMenu.add(new TextElement(0, 10, "Minimum damage: "));
            chatMenu.add(new TextElement(0, 12, "Maximum damage: "));
            chatMenu.add(new TextElement(0, 14, "Cooldown: "));
<<<<<<< HEAD
            chatMenu.add(weaponLevelInput(player, String.valueOf(iCreator.getPersistentLevelInput())));
            chatMenu.add(minimumWeaponDamageInput(player, String.valueOf(iCreator.getPersistentMinimumDamageInput())));
            chatMenu.add(maximumWeaponDamageInput(player, String.valueOf(iCreator.getPersistentMaximumDamageInput())));
            chatMenu.add(weaponAttackCooldown(player, String.valueOf(iCreator.getPersistentCooldownInput())));
=======
            chatMenu.add(weaponLevelInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponLevelInput()))));
            chatMenu.add(minimumWeaponDamageInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponMinimumDamageInput()))));
            chatMenu.add(maximumWeaponDamageInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponMaximumDamageInput()))));
            chatMenu.add(weaponAttackCooldown(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponCooldownInput()))));
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 200, 18, "»", page + 1));
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 0, 18, "«", page - 1));
        }
        if (page == 3){
<<<<<<< HEAD
            chatMenu.add(new TextElement(0, 6, "Ability name: "));
            chatMenu.add(new TextElement(0, 8, "Ability cast-type: "));
            chatMenu.add(new TextElement(0, 10, "Ability action type: "));
            chatMenu.add(new TextElement(0, 12, "Ability cooldown: "));
            chatMenu.add(new TextElement(0, 14, "Ability mana cost: "));
            chatMenu.add(abilityNameInput(player, iCreator.getPersistentAbilityNameInput()));
            chatMenu.add(abilityCastTypeInput(player, iCreator.getPersistentAbilityCastTypeInput()));
            chatMenu.add(abilityActionTypeInput(player, iCreator.getPersistentAbilityActionTypeInput()));
            chatMenu.add(abilityCooldownInput(player, "" + iCreator.getPersistentAbilityCooldownInput()));
            chatMenu.add(abilityManaCostInput(player, "" + iCreator.getPersistentAbilityManaCostInput()));
=======
            chatMenu.add(new TextElement(0, 10, "Gem(s): "));
            chatMenu.add(new TextElement(0, 12, "Scroll(s): "));
            chatMenu.add(new TextElement(0, 14, "Ability name: "));
            chatMenu.add(abilityNameInput(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponAbilityNameInput())));
            chatMenu.add(gemAmountInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponGemAmountInput()))));
            chatMenu.add(scrollAmountInput(player, String.valueOf(NullValues.replaceNullValues(iCreator.getPersistentWeaponScrollAmountInput()))));
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 200, 18, "»", page + 1));
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 0, 18, "«", page - 1));
        }
        if (page == 4){
            chatMenu.add(new TextElement(0, 2, "Lore description"));
            chatMenu.add(new TextElement(0, 4, "Use || to for new lines i.e. a||b"));
<<<<<<< HEAD
            chatMenu.add(itemBackgroundLoreOne(player, (String) NullValues.replaceNullValues(iCreator.getPersistentBackgroundLoreOneInput())));
            chatMenu.add(itemBackgroundLoreTwo(player, (String) NullValues.replaceNullValues(iCreator.getPersistentBackgroundLoreTwoInput())));
            chatMenu.add(itemBackgroundLoreThree(player, (String) NullValues.replaceNullValues(iCreator.getPersistentBackgroundLoreThreeInput())));
            chatMenu.add(itemBackgroundLoreFour(player, (String) NullValues.replaceNullValues(iCreator.getPersistentBackgroundLoreFourInput())));
            chatMenu.add(itemBackgroundLoreFive(player, (String) NullValues.replaceNullValues(iCreator.getPersistentBackgroundLoreFiveInput())));
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
=======
            chatMenu.add(itemBackgroundLoreOne(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreOneInput())));
            chatMenu.add(itemBackgroundLoreTwo(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreTwoInput())));
            chatMenu.add(itemBackgroundLoreThree(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreThreeInput())));
            chatMenu.add(itemBackgroundLoreFour(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreFourInput())));
            chatMenu.add(itemBackgroundLoreFive(player, (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreFiveInput())));
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
            chatMenu.add(goToWeaponCreateMenu(chatMenu, player, 0, 18, "«", page - 1));
        }
        chatMenu.setPauseChat(true);
        chatMenu.openFor(player);
    }

    private ButtonElement closeDefaultMenu(ChatMenu menu, Player player){
        return new ButtonElement(100, 18, ChatColor.RED + "[Close]", player1 -> {
            menu.setPauseChat(false);
            menu.close(player);
<<<<<<< HEAD
            ICreator iCreator = new ICreator(player, false);
            if (iCreator.getPersistentGiveItem() == (byte) 1){
                Weapon weapon = new Weapon(new ItemStack(Material.valueOf(iCreator.getPersistentMaterialType())))
                        .setName(Color.ify(iCreator.getPersistentFileName()))
                        .setRarity(iCreator.getPersistentRarityName())
                        .setLevel(iCreator.getPersistentLevelInput())
                        .setMaterial(iCreator.getPersistentMaterialLoreType())
                        .setMinimumDamage(iCreator.getPersistentMinimumDamageInput())
                        .setMaximumDamage(iCreator.getPersistentMaximumDamageInput())
                        .setAttackCooldown(iCreator.getPersistentCooldownInput());
                if (iCreator.getPersistentScrollAmountInput() > 0){
                    weapon.setScrolls(iCreator.getPersistentScrollAmountInput());
=======
            player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_PLAYER, PersistentDataType.STRING, player.getUniqueId().toString());
            ICreator iCreator = new ICreator(player);
            if (iCreator.getPersistentWeaponGiveItem() == (byte) 1){
                Weapon weapon = new Weapon(new ItemStack(Material.valueOf(iCreator.getPersistentWeaponMaterialType())))
                        .setName(Color.ify(iCreator.getPersistentWeaponFileName()))
                        .setRarity(iCreator.getPersistentWeaponRarityName())
                        .setLevel(iCreator.getPersistentWeaponLevelInput())
                        .setMaterial(iCreator.getPersistentWeaponBackgroundMaterialType())
                        .setMinimumDamage(iCreator.getPersistentWeaponMinimumDamageInput())
                        .setMaximumDamage(iCreator.getPersistentWeaponMaximumDamageInput())
                        .setAttackCooldown(iCreator.getPersistentWeaponCooldownInput());
                if (iCreator.getPersistentWeaponScrollAmountInput() > 0){
                    weapon.setScrolls(iCreator.getPersistentWeaponScrollAmountInput());
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
                }
                if (iCreator.getPersistentWeaponGemAmountInput() > 0){
                    weapon.setGems(iCreator.getPersistentWeaponGemAmountInput());
                }
<<<<<<< HEAD
<<<<<<< HEAD
                if (iCreator.getPersistentAbilityNameInput() != null){
                    weapon.setAbility(iCreator.getPersistentAbilityNameInput())
                            .setAbilityCastType(iCreator.getPersistentAbilityCastTypeInput())
                            .setAbilityActionType(iCreator.getPersistentAbilityActionTypeInput())
                            .setAbilityCooldown(iCreator.getPersistentAbilityCooldownInput())
                            .setAbilityManaCost(iCreator.getPersistentAbilityManaCostInput());
=======
                if (!NullValues.checkForNullValues(iCreator.getPersistentAbilityNameInput())){
                    String abilityName = IAbilityFiles.getAbilityName(iCreator.getPersistentAbilityNameInput());
=======
                if (!NullValues.checkForNullValues(iCreator.getPersistentWeaponAbilityNameInput())){
<<<<<<< HEAD:src/main/java/net/prosavage/illyriarpg/chatmenu/WeaponItemEditor.java
                    String abilityName = IAbilityFiles.getAbilityName(iCreator.getPersistentWeaponAbilityNameInput());
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
                    if (abilityName != null) {
                        weapon.setAbility(abilityName);
                    }
=======
                    AbilityFiles abilityName = new AbilityFiles(iCreator.getPersistentWeaponAbilityNameInput());
                    weapon.setAbility(abilityName.getName());
>>>>>>> 71fac37... Renamed things back, new & better files manager, more stuff fixed.:src/main/java/net/prosavage/savagerpg/chatmenu/WeaponItemEditor.java
                }
                if (!(NullValues.checkForNullValues(iCreator.getPersistentWeaponBackgroundLoreOneInput())
                        || NullValues.checkForNullValues(iCreator.getPersistentWeaponBackgroundLoreTwoInput())
                        || NullValues.checkForNullValues(iCreator.getPersistentWeaponBackgroundLoreThreeInput())
                        || NullValues.checkForNullValues(iCreator.getPersistentWeaponBackgroundLoreFourInput())
                        || NullValues.checkForNullValues(iCreator.getPersistentWeaponBackgroundLoreFiveInput()))) {
                    String lineOne = (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreOneInput());
                    String lineTwo = (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreTwoInput());
                    String lineThree = (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreThreeInput());
                    String lineFour = (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreFourInput());
                    String lineFive = (String) NullValues.replaceNullValues(iCreator.getPersistentWeaponBackgroundLoreFiveInput());
                    String description = (lineOne + "||" + lineTwo + "||" + lineThree + "||" + lineFour + "||" + lineFive).replaceAll("\\|\\| \\|\\|", "");
                    weapon.setBackgroundLore(description);
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
                }
                ItemStack itemStack = weapon.build();
                player.getInventory().addItem(itemStack);
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_GIVE_ITEM, PersistentDataType.BYTE, (byte)0);
            }
            for (int i = 0; i < 200; i++){
                player.sendMessage("\n");
            }
        });
    }

    private BooleanElement giveItem(Player player) {
        BooleanElement weaponGiveItemInput = new BooleanElement(75, 16, false);
        weaponGiveItemInput.value.setChangeCallback(state -> {
            byte byteValue = 0;
            Boolean currentValue = state.getCurrent();
            if (currentValue == Boolean.TRUE) {
                byteValue = 1;
            }
            player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_GIVE_ITEM, PersistentDataType.BYTE, byteValue);
        });
        return weaponGiveItemInput;
    }

    private InputElement weaponFileNameInput(Player player, String value) {
<<<<<<< HEAD
        InputElement weaponFile = new InputElement(100, 10, 100, value);
=======
        InputElement weaponFile = new InputElement(100, 8, 200, value);
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        weaponFile.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_NAME, PersistentDataType.STRING, currentValue);
            }
        });
        return weaponFile;
    }

    private InputElement weaponMaterialTypeInput(Player player, String value) {
        InputElement weaponMaterialInput = new InputElement(100, 12, 200, value);
        weaponMaterialInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_MATERIAL_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return weaponMaterialInput;
    }

<<<<<<< HEAD
    private InputElement weaponRarityInput(Player player, String value) {
        InputElement weaponRarityInput = new InputElement(100, 14, 100, value);
=======
    private InputElement weaponDisplayMaterialTypeInput(Player player, String value) {
        InputElement weaponMaterialInput = new InputElement(100, 14, 200, value);
        weaponMaterialInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_MATERIAL_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return weaponMaterialInput;
    }

    private InputElement weaponRarityInput(Player player, String value) {
        InputElement weaponRarityInput = new InputElement(100, 10, 200, value);
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
        weaponRarityInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_RARITY, PersistentDataType.STRING, currentValue);
            }
        });
        return weaponRarityInput;
    }


    private InputElement weaponLevelInput(Player player, String value) {
        InputElement weaponLevelInput = new InputElement(100, 8, 100, value);
        weaponLevelInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && Number.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_LEVEL, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return weaponLevelInput;
    }

    private InputElement minimumWeaponDamageInput(Player player, String value) {
        InputElement weaponDamageInput = new InputElement(100, 10, 100, value);
        weaponDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return weaponDamageInput;
    }

    private InputElement maximumWeaponDamageInput(Player player, String value) {
        InputElement maximumWeaponDamageInput = new InputElement(100, 12, 100, value);
        maximumWeaponDamageInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return maximumWeaponDamageInput;
    }

    private InputElement weaponAttackCooldown(Player player, String value) {
        InputElement weaponAttackCooldownInput = new InputElement(100, 14, 100, value);
        weaponAttackCooldownInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && Number.isParsableAsDouble(currentValue)) {
                double currentValueDouble = Double.parseDouble(currentValue);
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_ATTACK_COOLDOWN, PersistentDataType.DOUBLE, currentValueDouble);
            }
        });
        return weaponAttackCooldownInput;
    }

    private InputElement gemAmountInput(Player player, String value) {
        InputElement gemAmountInput = new InputElement(100, 10, 100, value);
        gemAmountInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && Number.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_GEM_AMOUNT, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return gemAmountInput;
    }

<<<<<<< HEAD
    private InputElement gemAmountInput(Player player, String value) {
        InputElement gemAmountInput = new InputElement(100, 16, 100, value);
        gemAmountInput.value.setChangeCallback(state -> {
=======
    private InputElement scrollAmountInput(Player player, String value) {
        InputElement scrollAmountInput = new InputElement(100, 12, 100, value);
        scrollAmountInput.value.setChangeCallback(state -> {
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
            String currentValue = state.getCurrent();
            if ((currentValue != null) && Number.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_SCROLL_AMOUNT, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return scrollAmountInput;
    }

    private InputElement abilityNameInput(Player player, String value) {
        InputElement abilityNameInput = new InputElement(100, 14, 100, value);
        abilityNameInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_ABILITY_NAME, PersistentDataType.STRING, currentValue);
            }
        });
        return abilityNameInput;
    }

<<<<<<< HEAD
    private InputElement abilityCastTypeInput(Player player, String value) {
        InputElement abilityCastTypeInput = new InputElement(100, 8, 100, value);
        abilityCastTypeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ITEM_ABILITY_CAST_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return abilityCastTypeInput;
    }

    private InputElement abilityActionTypeInput(Player player, String value) {
        InputElement abilityActionTypeInput = new InputElement(100, 10, 100, value);
        abilityActionTypeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ITEM_ABILITY_ACTION_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return abilityActionTypeInput;
    }

    private InputElement abilityCooldownInput(Player player, String value) {
        InputElement abilityCooldownInput = new InputElement(100, 12, 100, value);
        abilityCooldownInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ITEM_ABILITY_COOLDOWN, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return abilityCooldownInput;
    }

    private InputElement abilityManaCostInput(Player player, String value) {
        InputElement abilityManaCostInput = new InputElement(100, 14, 100, value);
        abilityManaCostInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_ITEM_ABILITY_MANA_COST, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return abilityManaCostInput;
=======
    private InputElement itemBackgroundLoreOne(Player player, String value) {
        InputElement itemBackgroundLoreOneInput = new InputElement(0, 6, 250, value);
        itemBackgroundLoreOneInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_1, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreOneInput;
    }

    private InputElement itemBackgroundLoreTwo(Player player, String value) {
        InputElement itemBackgroundLoreTwoInput = new InputElement(0, 8, 250, value);
        itemBackgroundLoreTwoInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_2, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreTwoInput;
    }

    private InputElement itemBackgroundLoreThree(Player player, String value) {
        InputElement itemBackgroundLoreThreeInput = new InputElement(0, 10, 250, value);
        itemBackgroundLoreThreeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_3, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreThreeInput;
    }

    private InputElement itemBackgroundLoreFour(Player player, String value) {
        InputElement itemBackgroundLoreFourInput = new InputElement(0, 12, 250, value);
        itemBackgroundLoreFourInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_4, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreFourInput;
    }

    private InputElement itemBackgroundLoreFive(Player player, String value) {
        InputElement itemBackgroundLoreFiveInput = new InputElement(0, 14, 250, value);
        itemBackgroundLoreFiveInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(INamespacedKeys.CREATOR_WEAPON_BACKGROUND_LORE_5, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreFiveInput;
>>>>>>> 5f1ac2f... Removed ingame file editor, added in more ability things including 3 new handlers which are left click, right click, and drop item.
    }

}
