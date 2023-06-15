package me.torben.luckyblocks.items.loot;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class LuckyPotion implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            ItemStack potion = new ItemStack(Material.POTION);
            ItemMeta meta = potion.getItemMeta();
            PotionMeta potionMeta = (PotionMeta) meta;
            potionMeta.setBasePotionData(new PotionData(PotionType.SPEED));
            potionMeta.setColor(Color.fromRGB(219, 183, 0));
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 24000, 3), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 24000, 3), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 24000, 3), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 24000, 1), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 24000, 5), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 24000, 3), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 24000, 5), true);
            potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 24000, 1  ), true);

            potionMeta.setDisplayName(Color.fromRGB(219, 183, 0) +  "Lucky Potion");
            potion.setItemMeta(potionMeta);
            ((Player) commandSender).getPlayer().getInventory().addItem(potion);
        }


        return false;
    }
}
