package net.prosavage.yarpg.commands;

import net.prosavage.yarpg.api.YFiles;
import net.prosavage.yarpg.chatmenu.ArmorItemEditor;
import net.prosavage.yarpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArmorCommand implements CommandExecutor {

    YFiles YFiles = new YFiles();
    Color Color = new Color();
    ArmorItemEditor ArmorItemEditor = new ArmorItemEditor();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify("&eTotal (yaml) armor loaded: &7" + YFiles.getArmorAmount()));
                player.sendMessage(Color.ify("&e/armor edit: &7Allows you to create an ingame armor item."));
                player.sendMessage(Color.ify("------------------------------------------------"));
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("edit")) {
                    ArmorItemEditor.openMenu(player);
                }
                if (args[0].equalsIgnoreCase("forloop")) {
                    for (int i = 0; i < 100; i++){
                        player.sendMessage(String.valueOf(i));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
