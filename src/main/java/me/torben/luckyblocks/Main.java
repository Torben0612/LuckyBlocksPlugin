package me.torben.luckyblocks;

import me.torben.luckyblocks.items.loot.LuckyPotion;
import me.torben.luckyblocks.utils.AdvancedLicense;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        saveDefaultConfig();
        String licence = this.getConfig().getString("licence-key");
        if(!new AdvancedLicense(licence, "https://tornadokspigotplugins.000webhostapp.com/verify.php", this).register());


        getCommand("lucky-pot").setExecutor(new LuckyPotion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
