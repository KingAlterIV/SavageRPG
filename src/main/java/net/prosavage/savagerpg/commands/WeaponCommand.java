package net.prosavage.savagerpg.commands;

import net.prosavage.savagerpg.api.SFiles;
import net.prosavage.savagerpg.chatmenu.WeaponItemEditor;
import net.prosavage.savagerpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WeaponCommand implements CommandExecutor {

    net.prosavage.savagerpg.api.SFiles SFiles = new SFiles();
    Color Color = new Color();
    WeaponItemEditor WeaponItemEditor = new WeaponItemEditor();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("&dTotal (yaml) weapons loaded: " + SFiles.getWeaponAmount()));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("&d/weapon edit (allows you to create an ingame item)"));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify(""));
            }
            else {
                if (args[0].equalsIgnoreCase("edit")) {
                    WeaponItemEditor.getWeaponCreateMenu(player, 1);
                }
                return true;
            }

        }
        return false;
    }

}
