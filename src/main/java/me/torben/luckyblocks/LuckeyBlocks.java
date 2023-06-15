package me.torben.luckeyblocks;

import org.bukkit.plugin.java.JavaPlugin;

public final class LuckeyBlocks extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
