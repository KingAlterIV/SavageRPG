package net.prosavage.yarpg.commands;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.YFiles;
import net.prosavage.yarpg.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

public class YaRPGCommand implements CommandExecutor {

    Color Color = new Color();
    YFiles YFiles = new YFiles();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage(Color.ify(""));
                player.sendMessage(Color.ify("------------------------------------------------"));
                player.sendMessage(Color.ify("&e/yarpg reload: &7Reloads the config."));
                player.sendMessage(Color.ify("&e/yarpg amount: &7Shows the amount of files & such loaded."));
                player.sendMessage(Color.ify("------------------------------------------------"));
            }
            else {
                if (args[0].equalsIgnoreCase("amount")) {
                    player.sendMessage(Color.ify(""));
                    player.sendMessage(Color.ify("------------------------------------------------"));
                    player.sendMessage(Color.ify("&eTotal (YAML) weapon(s) loaded: &7" + YFiles.getWeaponAmount()));
                    player.sendMessage(Color.ify("&eTotal (YAML) armor(s) loaded: &7" + YFiles.getArmorAmount()));
                    player.sendMessage(Color.ify("&eTotal abilities loaded: &7" + YFiles.getAbilityAmount()));
                    player.sendMessage(Color.ify("&eTotal (YAML) entities loaded: &7" + YFiles.getEntityAmount()));
                    player.sendMessage(Color.ify("------------------------------------------------"));
                }else if (args[0].equalsIgnoreCase("reload")){
                    YaRPG.getInstance().reloadConfig();
                    player.sendMessage(Color.ify(""));
                    player.sendMessage(Color.ify("------------------------------------------------"));
                    player.sendMessage(Color.ify("&eThe configuration has been reloaded!"));
                    player.sendMessage(Color.ify("------------------------------------------------"));
                }
                return true;
            }
        }
        return false;
    }
}