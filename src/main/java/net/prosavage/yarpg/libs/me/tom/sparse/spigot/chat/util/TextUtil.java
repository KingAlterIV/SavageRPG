package net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.util;

import java.util.Arrays;

import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.ChatMenuAPI;

public final class TextUtil {
    public static String generateSpaces(int count) {
        return repeatCharacter(' ', count);
    }

    public static String repeatCharacter(char character, int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, character);
        return new String(chars);
    }

    public static String generateWidth(char character, int width, boolean canExceed) {
        int charWidth = ChatMenuAPI.getCharacterWidth(character);
        int count = (int) (canExceed ? Math.round(width / (double) charWidth) : Math.floor(width / (double) charWidth));
        return repeatCharacter(character, count);
    }

    private TextUtil() {
    }
}
