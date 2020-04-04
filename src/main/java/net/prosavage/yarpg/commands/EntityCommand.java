package net.prosavage.yarpg.commands;

import net.prosavage.yarpg.api.YFiles;
import net.prosavage.yarpg.chatmenu.EntityEditor;
import net.prosavage.yarpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EntityCommand implements CommandExecutor {

    EntityEditor EntityEditor = new EntityEditor();
    Color Color = new Color();
    YFiles YFiles = new YFiles();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify("&eTotal (yaml) entities loaded: &7" + YFiles.getEntityAmount()));
                player.sendMessage(Color.ify("&e/entity edit: &7Allows you to create & spawn an entity in."));
                player.sendMessage(Color.ify("------------------------------------------------"));
            }
            else {
                if (args[0].equalsIgnoreCase("edit")) {
                    EntityEditor.getEntityCreateMenu(player, 1);
                }
                return true;
            }
        }
        return false;
    }

}
