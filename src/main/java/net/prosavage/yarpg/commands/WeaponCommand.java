package net.prosavage.yarpg.commands;

import net.prosavage.yarpg.api.YFiles;
import net.prosavage.yarpg.builders.files.WeaponFiles;
import net.prosavage.yarpg.chatmenu.WeaponItemEditor;
import net.prosavage.yarpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class WeaponCommand implements CommandExecutor {

    YFiles YFiles = new YFiles();
    Color Color = new Color();
    WeaponItemEditor WeaponItemEditor = new WeaponItemEditor();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify("&eTotal (yaml) weapons loaded: &7" + YFiles.getWeaponAmount()));
                player.sendMessage(Color.ify("&e/weapon edit: &7Allows you to create an ingame weapon item."));
                player.sendMessage(Color.ify("&e/weapon yaml example: &7Put's an example into the yaml file."));
                player.sendMessage(Color.ify("------------------------------------------------"));
            }
            else {
                if (args[0].equalsIgnoreCase("edit")) {
                    WeaponItemEditor.getWeaponCreateMenu(player, 1);
                }else if (args[0].equalsIgnoreCase("yaml")){
                    if (args[1].equalsIgnoreCase("example")) {
                        new WeaponFiles("example", "example").setActualMaterial("STONE_SWORD").getExample();
                    }
                }
                return true;
            }
        }
        return false;
    }

}
