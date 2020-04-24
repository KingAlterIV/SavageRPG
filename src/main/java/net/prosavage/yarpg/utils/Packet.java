package net.prosavage.yarpg.utils;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.bukkit.entity.Player;
import java.lang.reflect.InvocationTargetException;

public class Packet {

    public void sendActionbar(Player player, String message) {
        if (message == null || message.isEmpty()) {
            return;
        }
        PacketContainer chat = new PacketContainer(PacketType.Play.Server.CHAT);
        chat.getChatTypes().writeSafely(0, EnumWrappers.ChatType.GAME_INFO);
        chat.getChatComponents().write(0, WrappedChatComponent.fromText(message));
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, chat);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}