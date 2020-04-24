package net.prosavage.yarpg.chatmenu;

import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.ChatMenu;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.*;
import net.prosavage.yarpg.api.YCreator;
import net.prosavage.yarpg.api.keys.YNamespacedKeys;
import net.prosavage.yarpg.builders.itemstacks.Armor;
import net.prosavage.yarpg.utils.Color;
import net.prosavage.yarpg.utils.INumber;
import net.prosavage.yarpg.utils.NullValues;
import net.prosavage.yarpg.utils.chatmenu.MenuElements;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class ArmorItemEditor {

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
        menu.add(menuElements.addElement(player, new TextElement(0, 16, "Give item? ")));
        menu.add(menuElements.addElement(player, giveItem(player)));
        if (page <= 1) {
            menu.add(menuElements.addElement(player, new TextElement(0, 8, "Armor name: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 10, "Item rarity: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Actual item type: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 14, "Display item type: ")));
            menu.add(menuElements.addElement(player, armorFileNameInput(player, Color.ify((String) NullValues.replaceNullValues(yCreator.getPersistentArmorFileName())))));
            menu.add(menuElements.addElement(player, armorRarityInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorRarityName()))));
            menu.add(menuElements.addElement(player, armorMaterialTypeInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorMaterialType()))));
            menu.add(menuElements.addElement(player, armorDisplayMaterialTypeInput(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundMaterialType()))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 200, 18, "»", page + 1)));
        }
        if (page == 2) {
            menu.add(menuElements.addElement(player, new TextElement(0, 2, "Level input: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 4, "Minimum protection: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 6, "Maximum protection: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 8, "Minimum health: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 10, "Maximum health: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Minimum regen: ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 14, "Maximum regen: ")));
            menu.add(menuElements.addElement(player, armorLevelInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorLevelInput())))));
            menu.add(menuElements.addElement(player, minimumArmorProtectionInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMinimumProtectionInput())))));
            menu.add(menuElements.addElement(player, maximumArmorProtectionInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMaximumProtectionInput())))));
            menu.add(menuElements.addElement(player, minimumArmorHealthInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMinimumHealthInput())))));
            menu.add(menuElements.addElement(player, maximumArmorHealthInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMaximumHealthInput())))));
            menu.add(menuElements.addElement(player, minimumArmorRegenInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMinimumRegenInput())))));
            menu.add(menuElements.addElement(player, maximumArmorRegenInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorMaximumRegenInput())))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 200, 18, "»", page + 1)));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 0, 18, "«", page - 1)));
        }
        if (page == 3) {
            menu.add(menuElements.addElement(player, new TextElement(0, 12, "Gem(s): ")));
            menu.add(menuElements.addElement(player, new TextElement(0, 14, "Scroll(s): ")));
            menu.add(menuElements.addElement(player, gemAmountInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorGemAmountInput())))));
            menu.add(menuElements.addElement(player, scrollAmountInput(player, String.valueOf(NullValues.replaceNullValues(yCreator.getPersistentArmorScrollAmountInput())))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 200, 18, "»", page + 1)));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 0, 18, "«", page - 1)));
        }
        if (page == 4) {
            menu.add(menuElements.addElement(player, new TextElement(0, 2, "Lore description")));
            menu.add(menuElements.addElement(player, new TextElement(0, 4, "Use || to for new lines i.e. a||b")));
            menu.add(menuElements.addElement(player, itemBackgroundLoreOne(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreOneInput()))));
            menu.add(menuElements.addElement(player, itemBackgroundLoreTwo(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreTwoInput()))));
            menu.add(menuElements.addElement(player, itemBackgroundLoreThree(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreThreeInput()))));
            menu.add(menuElements.addElement(player, itemBackgroundLoreFour(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreFourInput()))));
            menu.add(menuElements.addElement(player, itemBackgroundLoreFive(player, (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreFiveInput()))));
            menu.add(menuElements.addElement(player, setPageMenuContent(menu, player, 0, 18, "«", page - 1)));
        }
        return menu;
    }

    private ButtonElement closeDefaultMenu (ChatMenu menu, Player player){
        return new ButtonElement(100, 18, ChatColor.RED + "[Close]", player1 -> {
            new MenuElements(player, menu).clear();
            menu.setPauseChat(false);
            menu.close(player);
            player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_PLAYER, PersistentDataType.STRING, player.getUniqueId().toString());
            YCreator yCreator = new YCreator(player);
            if (yCreator.getPersistentArmorGiveItemInput() == (byte) 1) {
                Armor armor = new Armor(new ItemStack(Material.valueOf(yCreator.getPersistentArmorMaterialType())))
                        .setName(Color.ify(yCreator.getPersistentArmorFileName()))
                        .setRarity(yCreator.getPersistentArmorRarityName())
                        .setLevel(yCreator.getPersistentArmorLevelInput())
                        .setMaterial(yCreator.getPersistentArmorBackgroundMaterialType())
                        .setMinimumProtection(yCreator.getPersistentArmorMinimumProtectionInput())
                        .setMaximumProtection(yCreator.getPersistentArmorMaximumProtectionInput())
                        .setMinimumHealth(yCreator.getPersistentArmorMinimumHealthInput())
                        .setMaximumHealth(yCreator.getPersistentArmorMaximumHealthInput())
                        .setMinimumRegen(yCreator.getPersistentArmorMinimumRegenInput())
                        .setMaximumRegen(yCreator.getPersistentArmorMaximumRegenInput());
                if (yCreator.getPersistentArmorScrollAmountInput() > 0) {
                    armor.setScrolls(yCreator.getPersistentArmorScrollAmountInput());
                }
                if (yCreator.getPersistentArmorGemAmountInput() > 0) {
                    armor.setGems(yCreator.getPersistentArmorGemAmountInput());
                }
                if (!(NullValues.checkForNullValues(yCreator.getPersistentArmorBackgroundLoreOneInput())
                        || NullValues.checkForNullValues(yCreator.getPersistentArmorBackgroundLoreTwoInput())
                        || NullValues.checkForNullValues(yCreator.getPersistentArmorBackgroundLoreThreeInput())
                        || NullValues.checkForNullValues(yCreator.getPersistentArmorBackgroundLoreFourInput())
                        || NullValues.checkForNullValues(yCreator.getPersistentArmorBackgroundLoreFiveInput()))) {
                    String lineOne = (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreOneInput());
                    String lineTwo = (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreTwoInput());
                    String lineThree = (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreThreeInput());
                    String lineFour = (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreFourInput());
                    String lineFive = (String) NullValues.replaceNullValues(yCreator.getPersistentArmorBackgroundLoreFiveInput());
                    String description = (lineOne + "||" + lineTwo + "||" + lineThree + "||" + lineFour + "||" + lineFive).replaceAll("\\|\\| \\|\\|", "");
                    armor.setBackgroundLore(description);
                }
                armor.setSpawnedIn((byte) 1);
                armor.setItemCreator(String.valueOf(player.getUniqueId()));
                ItemStack itemStack = armor.build();
                player.getInventory().addItem(itemStack);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_GIVE_ITEM, PersistentDataType.BYTE, (byte) 0);
            }
        });
    }

    private BooleanElement giveItem (Player player){
        BooleanElement armorGiveItemInput = new BooleanElement(75, 16, false);
        armorGiveItemInput.value.setChangeCallback(state -> {
            byte byteValue = 0;
            Boolean currentValue = state.getCurrent();
            if (currentValue == Boolean.TRUE) {
                byteValue = 1;
            }
            player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_GIVE_ITEM, PersistentDataType.BYTE, byteValue);
        });
        return armorGiveItemInput;
    }

    private InputElement armorFileNameInput (Player player, String value){
        InputElement armorFile = new InputElement(100, 8, 200, value);
        armorFile.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_NAME, PersistentDataType.STRING, currentValue);
            }
        });
        return armorFile;
    }

    private InputElement armorMaterialTypeInput (Player player, String value){
        InputElement armorMaterialInput = new InputElement(100, 12, 200, value);
        armorMaterialInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MATERIAL_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return armorMaterialInput;
    }

    private InputElement armorDisplayMaterialTypeInput (Player player, String value){
        InputElement armorMaterialInput = new InputElement(100, 14, 200, value);
        armorMaterialInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_MATERIAL_TYPE, PersistentDataType.STRING, currentValue);
            }
        });
        return armorMaterialInput;
    }

    private InputElement armorRarityInput (Player player, String value){
        InputElement armorRarityInput = new InputElement(100, 10, 200, value);
        armorRarityInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_RARITY, PersistentDataType.STRING, currentValue);
            }
        });
        return armorRarityInput;
    }

    private InputElement armorLevelInput (Player player, String value){
        InputElement armorLevelInput = new InputElement(100, 2, 100, value);
        armorLevelInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_LEVEL, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return armorLevelInput;
    }

    private InputElement minimumArmorProtectionInput (Player player, String value){
        InputElement minimumArmorProtectionInput = new InputElement(100, 4, 100, value);
        minimumArmorProtectionInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return minimumArmorProtectionInput;
    }

    private InputElement maximumArmorProtectionInput (Player player, String value){
        InputElement maximumArmorProtectionInput = new InputElement(100, 6, 100, value);
        maximumArmorProtectionInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return maximumArmorProtectionInput;
    }

    private InputElement minimumArmorHealthInput (Player player, String value){
        InputElement minimumArmorHealthInput = new InputElement(100, 8, 100, value);
        minimumArmorHealthInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_HEALTH, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return minimumArmorHealthInput;
    }

    private InputElement maximumArmorHealthInput (Player player, String value){
        InputElement maximumArmorHealthInput = new InputElement(100, 10, 100, value);
        maximumArmorHealthInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return maximumArmorHealthInput;
    }

    private InputElement minimumArmorRegenInput (Player player, String value){
        InputElement minimumArmorRegenInput = new InputElement(100, 12, 100, value);
        minimumArmorRegenInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MINIMUM_REGEN, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return minimumArmorRegenInput;
    }

    private InputElement maximumArmorRegenInput (Player player, String value){
        InputElement maximumArmorRegenInput = new InputElement(100, 14, 100, value);
        maximumArmorRegenInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_MAXIMUM_REGEN, PersistentDataType.DOUBLE, Double.parseDouble(currentValue));
            }
        });
        return maximumArmorRegenInput;
    }

    private InputElement gemAmountInput (Player player, String value){
        InputElement gemAmountInput = new InputElement(100, 12, 100, value);
        gemAmountInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_GEM_AMOUNT, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return gemAmountInput;
    }

    private InputElement scrollAmountInput (Player player, String value){
        InputElement scrollAmountInput = new InputElement(100, 14, 100, value);
        scrollAmountInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if ((currentValue != null) && INumber.isParsableAsInt(currentValue)) {
                int currentValueInt = Integer.parseInt(currentValue);
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_SCROLL_AMOUNT, PersistentDataType.INTEGER, currentValueInt);
            }
        });
        return scrollAmountInput;
    }

    private InputElement itemBackgroundLoreOne (Player player, String value){
        InputElement itemBackgroundLoreOneInput = new InputElement(0, 6, 250, value);
        itemBackgroundLoreOneInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_1, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreOneInput;
    }

    private InputElement itemBackgroundLoreTwo (Player player, String value){
        InputElement itemBackgroundLoreTwoInput = new InputElement(0, 8, 250, value);
        itemBackgroundLoreTwoInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_2, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreTwoInput;
    }

    private InputElement itemBackgroundLoreThree (Player player, String value){
        InputElement itemBackgroundLoreThreeInput = new InputElement(0, 10, 250, value);
        itemBackgroundLoreThreeInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_3, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreThreeInput;
    }

    private InputElement itemBackgroundLoreFour (Player player, String value){
        InputElement itemBackgroundLoreFourInput = new InputElement(0, 12, 250, value);
        itemBackgroundLoreFourInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_4, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreFourInput;
    }

    private InputElement itemBackgroundLoreFive (Player player, String value){
        InputElement itemBackgroundLoreFiveInput = new InputElement(0, 14, 250, value);
        itemBackgroundLoreFiveInput.value.setChangeCallback(state -> {
            String currentValue = state.getCurrent();
            if (currentValue != null) {
                player.getPersistentDataContainer().set(YNamespacedKeys.CREATOR_ARMOR_BACKGROUND_LORE_5, PersistentDataType.STRING, currentValue);
            }
        });
        return itemBackgroundLoreFiveInput;
    }

}