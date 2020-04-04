package net.prosavage.yarpg.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class Config extends YamlConfiguration {

    private net.prosavage.yarpg.YaRPG plugin;
    private File file;
    private String name;

    public Config(net.prosavage.yarpg.YaRPG plugin, String name) {
        this.plugin = plugin;
        this.name = name;
        this.file = new File(plugin.getDataFolder(), name);
        reloadFile();
    }

    public void reloadFile() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            load(file);
        } catch (IOException | InvalidConfigurationException err) {
            err.printStackTrace();
        }
    }

    public void saveFile() {
        try {
            save(file);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}