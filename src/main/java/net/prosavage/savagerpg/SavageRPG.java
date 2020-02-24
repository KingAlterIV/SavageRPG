package net.prosavage.savagerpg;

import net.prosavage.savagerpg.api.SFiles;
import net.prosavage.savagerpg.commands.ArmorCommand;
import net.prosavage.savagerpg.commands.EntityCommand;
import net.prosavage.savagerpg.commands.WeaponCommand;
import net.prosavage.savagerpg.utils.Color;
import net.prosavage.savagerpg.utils.handlers.abilities.DropAction;
import net.prosavage.savagerpg.utils.handlers.abilities.LeftAndRightAction;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Consumer;

public final class SavageRPG extends JavaPlugin {

    private static SavageRPG instance;
    private Color Color = new Color();
    private String weaponFolder = getDataFolder() + "\\weapons";
    private String armorFolder = getDataFolder() + "\\armors";
    private String abilityFolder = getDataFolder() + "\\abilities";
    private String entityFolder = getDataFolder() + "\\entities";
    private File configFile = new File(getDataFolder(), "config.yml");

    private SFiles SFiles = new SFiles();

    private HashMap<String, Consumer<PlayerInteractEvent>> leftClickInteractions = new HashMap<>();
    private HashMap<String, Consumer<PlayerInteractEvent>> rightClickInteractions = new HashMap<>();
    private HashMap<String, Consumer<PlayerDropItemEvent>> itemDropInteractions = new HashMap<>();

    public SavageRPG() {
        instance = this;
    }

    public static SavageRPG getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        if (getConfig().getBoolean("server-startup.big-fat-bloody-message-enabled")) {
            sendConsole("");
            sendConsole("\n\n&c" +
                    "  ██████  ▄▄▄    ██▒   █▓ ▄▄▄        ▄████ ▓█████  ██▀███   ██▓███    ▄████ \n" +
                    "▒██    ▒ ▒████▄ ▓██░   █▒▒████▄     ██▒ ▀█▒▓█   ▀ ▓██ ▒ ██▒▓██░  ██▒ ██▒ ▀█▒\n" +
                    "░ ▓██▄   ▒██  ▀█▄▓██  █▒░▒██  ▀█▄  ▒██░▄▄▄░▒███   ▓██ ░▄█ ▒▓██░ ██▓▒▒██░▄▄▄░\n" +
                    "  ▒   ██▒░██▄▄▄▄██▒██ █░░░██▄▄▄▄██ ░▓█  ██▓▒▓█  ▄ ▒██▀▀█▄  ▒██▄█▓▒ ▒░▓█  ██▓\n" +
                    "▒██████▒▒ ▓█   ▓██▒▒▀█░   ▓█   ▓██▒░▒▓███▀▒░▒████▒░██▓ ▒██▒▒██▒ ░  ░░▒▓███▀▒\n" +
                    "▒ ▒▓▒ ▒ ░ ▒▒   ▓▒█░░ ▐░   ▒▒   ▓▒█░ ░▒   ▒ ░░ ▒░ ░░ ▒▓ ░▒▓░▒▓▒░ ░  ░ ░▒   ▒ \n" +
                    "░ ░▒  ░ ░  ▒   ▒▒ ░░ ░░    ▒   ▒▒ ░  ░   ░  ░ ░  ░  ░▒ ░ ▒░░▒ ░       ░   ░ \n" +
                    "░  ░  ░    ░   ▒     ░░    ░   ▒   ░ ░   ░    ░     ░░   ░ ░░       ░ ░   ░ \n" +
                    "      ░        ░  ░   ░        ░  ░      ░    ░  ░   ░                    ░ \n" +
                    "                     ░                                                      ");
        }
        Objects.requireNonNull(this.getCommand("weapon")).setExecutor(new WeaponCommand());
        Objects.requireNonNull(this.getCommand("armor")).setExecutor(new ArmorCommand());
        Objects.requireNonNull(this.getCommand("entity")).setExecutor(new EntityCommand());
        Bukkit.getPluginManager().registerEvents(new LeftAndRightAction(), this);
        Bukkit.getPluginManager().registerEvents(new DropAction(), this);
        new BukkitRunnable(){
            @Override
            public void run() {
                sendConsole("");
                sendConsole("&aTotal (YAML) weapon(s) loaded: &e" + SFiles.getWeaponAmount());
                sendConsole("&aTotal (YAML) armor(s) loaded: &e" + SFiles.getArmorAmount());
                sendConsole("&aTotal abilities loaded: &e" + SFiles.getAbilityAmount());
                sendConsole("&aTotal (YAML) entities loaded: &e" + SFiles.getEntityAmount());
                sendConsole("");
            }
        }.runTaskLater(this, 1L);
    }

    @Override
    public void onDisable() {
        SFiles.removeAbilityFiles();
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
