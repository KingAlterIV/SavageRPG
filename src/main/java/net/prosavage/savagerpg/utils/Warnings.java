package net.prosavage.savagerpg.utils;

import org.bukkit.entity.Player;

public class Warnings {

    Color Color = new Color();

    public Warnings(Player player, String type, String message){
        if (type.equals("title")){
            player.sendTitle(Color.ify("&cWARNING"), Color.ify(message), 20, 20, 20);
        }else if (type.equals("chat")){
            player.sendMessage(Color.ify(message));
        }
    }
}
