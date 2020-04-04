package net.prosavage.yarpg;

import net.prosavage.yarpg.api.YFiles;
import net.prosavage.yarpg.commands.ArmorCommand;
import net.prosavage.yarpg.commands.EntityCommand;
import net.prosavage.yarpg.commands.WeaponCommand;
import net.prosavage.yarpg.commands.YaRPGCommand;
import net.prosavage.yarpg.utils.Color;
import net.prosavage.yarpg.utils.handlers.abilities.DropAction;
import net.prosavage.yarpg.utils.handlers.abilities.LeftAndRightAction;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public final class YaRPG extends JavaPlugin {

    private static YaRPG instance;
    private Color Color = new Color();
    private String weaponFolder = getDataFolder() + "\\weapons";
    private String armorFolder = getDataFolder() + "\\armors";
    private String abilityFolder = getDataFolder() + "\\abilities";
    private String entityFolder = getDataFolder() + "\\entities";
    private File configFile = new File(getDataFolder(), "config.yml");

    private YFiles YFiles = new YFiles();

    private HashMap<String, Consumer<PlayerInteractEvent>> leftClickInteractions = new HashMap<>();
    private HashMap<String, Consumer<PlayerInteractEvent>> rightClickInteractions = new HashMap<>();
    private HashMap<String, Consumer<PlayerDropItemEvent>> itemDropInteractions = new HashMap<>();

    public YaRPG() {
        instance = this;
    }

    public static YaRPG getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        if (getConfig().getBoolean("server-startup.big-fat-bloody-message-enabled")) {
            sendConsole("");
            sendConsole("\n\n&e" + "\n" +
                    "\n" +
                    "▓██   ██▓ ▄▄▄       ██▀███   ██▓███    ▄████ \n" +
                    " ▒██  ██▒▒████▄    ▓██ ▒ ██▒▓██░  ██▒ ██▒ ▀█▒\n" +
                    "  ▒██ ██░▒██  ▀█▄  ▓██ ░▄█ ▒▓██░ ██▓▒▒██░▄▄▄░\n" +
                    "  ░ ▐██▓░░██▄▄▄▄██ ▒██▀▀█▄  ▒██▄█▓▒ ▒░▓█  ██▓\n" +
                    "  ░ ██▒▓░ ▓█   ▓██▒░██▓ ▒██▒▒██▒ ░  ░░▒▓███▀▒\n" +
                    "   ██▒▒▒  ▒▒   ▓▒█░░ ▒▓ ░▒▓░▒▓▒░ ░  ░ ░▒   ▒ \n" +
                    " ▓██ ░▒░   ▒   ▒▒ ░  ░▒ ░ ▒░░▒ ░       ░   ░ \n" +
                    " ▒ ▒ ░░    ░   ▒     ░░   ░ ░░       ░ ░   ░ \n" +
                    " ░ ░           ░  ░   ░                    ░ \n" +
                    " ░ ░                                         \n" +
                    "\n");
        }
        Objects.requireNonNull(this.getCommand("yarpg")).setExecutor(new YaRPGCommand());
        Objects.requireNonNull(this.getCommand("weapon")).setExecutor(new WeaponCommand());
        Objects.requireNonNull(this.getCommand("armor")).setExecutor(new ArmorCommand());
        Objects.requireNonNull(this.getCommand("entity")).setExecutor(new EntityCommand());
        Bukkit.getPluginManager().registerEvents(new LeftAndRightAction(), this);
        Bukkit.getPluginManager().registerEvents(new DropAction(), this);
        new BukkitRunnable(){
            @Override
            public void run() {
                sendConsole("");
                sendConsole("&eTotal (YAML) weapon(s) loaded: &7" + YFiles.getWeaponAmount());
                sendConsole("&eTotal (YAML) armor(s) loaded: &7" + YFiles.getArmorAmount());
                sendConsole("&eTotal abilities loaded: &7" + YFiles.getAbilityAmount());
                sendConsole("&eTotal (YAML) entities loaded: &7" + YFiles.getEntityAmount());
                sendConsole("");
            }
        }.runTaskLater(this, 1L);
    }

    @Override
    public void onDisable() {
        YFiles.removeAbilityFiles();
    }

    public void sendConsole(Object object){
        System.out.println(Color.ify(String.valueOf(object)));
    }

    public String getWeaponFolder() {
        return weaponFolder;
    }

    public String getArmorFolder() {
        return armorFolder;
    }

    public String getAbilityFolder() {
        return abilityFolder;
    }

    public String getEntityFolder() {
        return entityFolder;
    }

    public HashMap<String, Consumer<PlayerInteractEvent>> getLeftClickInteractions(){
        return leftClickInteractions;
    }

    public HashMap<String, Consumer<PlayerInteractEvent>> getRightClickInteractions() {
        return rightClickInteractions;
    }

    public HashMap<String, Consumer<PlayerDropItemEvent>> getItemDropInteractions() {
        return itemDropInteractions;
    }

}
