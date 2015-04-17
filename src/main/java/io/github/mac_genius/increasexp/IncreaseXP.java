package io.github.mac_genius.increasexp;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * A simple plugin that increases the amount of xp dropped when
 * an entity is killed with a looting sword.
 *
 * @author Mac_Genius
 */
public class IncreaseXP extends JavaPlugin {

    /**
     * This runs when the plugin is enabled.
     */
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getLogger().info("Plugin enabled! ");
    }

    /**
     * This runs when the plugin is disabled.
     */
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }
}
