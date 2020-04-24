package net.prosavage.yarpg.utils.chatmenu;

import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.ChatMenu;
import net.prosavage.yarpg.libs.me.tom.sparse.spigot.chat.menu.element.Element;
import net.prosavage.yarpg.YaRPG;
import org.bukkit.entity.Player;
import java.util.*;

public class MenuElements {

    private Map<UUID, List<Element>> elementList;
    private Player player;
    private ChatMenu menu;
    private Element element;

    public MenuElements(Player player, ChatMenu menu){
        this.player = player;
        this.menu = menu;
        this.elementList = YaRPG.getInstance().getElementList();
    }

    public Element addElement(Player player, Element element){
        this.element = element;
        List<Element> elementList2 = elementList.get(player.getUniqueId());
        if (elementList.get(player.getUniqueId()) == null){
            elementList2 = new ArrayList<>();
        }
        elementList2.add(this.element);

        elementList.put(player.getUniqueId(), elementList2);
        return element;
    }

    public MenuElements setMenu(ChatMenu menu){
        this.menu = menu;
        return this;
    }

    public void removeElement(Element selectedElement){
        List<Element> elementList2 = elementList.get(player.getUniqueId());
        elementList2.remove(selectedElement);
        this.elementList.put(player.getUniqueId(), elementList2);
    }

    public void clear(){
        if (menu == null) throw new IllegalStateException("The menu is null, if it's not set yet, you can set it with MenuElements#setMenu(ChatMenu menu)");
        List<Element> elementList2 = elementList.get(player.getUniqueId());
        if (elementList2 != null) {
            for (Element value : elementList2) {
                if (value != null) {
                    this.menu.remove(value);
                }
            }
        }
    }
}
