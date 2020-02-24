package net.prosavage.savagerpg.commands;

import net.prosavage.savagerpg.chatmenu.EntityEditor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EntityCommand implements CommandExecutor {

    EntityEditor EntityEditor = new EntityEditor();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            EntityEditor.getEntityCreateMenu(player, 1);
        }
        return false;
    }

}
