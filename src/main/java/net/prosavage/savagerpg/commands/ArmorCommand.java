package net.prosavage.savagerpg.commands;

import net.prosavage.savagerpg.api.SFiles;
import net.prosavage.savagerpg.chatmenu.ArmorItemEditor;
import net.prosavage.savagerpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArmorCommand implements CommandExecutor {

    SFiles SFiles = new SFiles();
    Color Color = new Color();
    ArmorItemEditor ArmorItemEditor = new ArmorItemEditor();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("&dTotal (yaml) armor loaded: " + SFiles.getArmorAmount()));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("&d/armor edit (allows you to create an ingame item)"));
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify(""));
            }
            if (args.length >= 1) {
                if (args[0].equals("edit")) {
                    ArmorItemEditor.getArmorCreateMenu(player, 1);
                }
                return true;
            }
        }
        return false;
    }
}
