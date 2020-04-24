package net.prosavage.yarpg.events;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.YPlayer;
import net.prosavage.yarpg.utils.Color;
import net.prosavage.yarpg.utils.Placeholders;
import net.prosavage.yarpg.utils.Packet;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    Packet Packet = new Packet();
    Placeholders Placeholders = new Placeholders();
    Color Color = new Color();

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        YPlayer yPlayer = new YPlayer(player);
        if (!yPlayer.hasData()){
            yPlayer.setDefault();
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                if (player.isOnline()){
                    Packet.sendActionbar(player, Color.ify(Placeholders.forPlayer(player, YaRPG.getInstance().getConfig().getString("format.actionbar"))));
                }else if (!player.isOnline()){
                    this.cancel();
                }
            }
        }.runTaskTimer(YaRPG.getInstance(), 0L, 10L);

    }
}
