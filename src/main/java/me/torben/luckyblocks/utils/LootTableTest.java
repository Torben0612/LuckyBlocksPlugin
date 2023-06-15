package me.torben.luckyblocks.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootTableTest implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
    Block block = event.getBlock();

    if (block.getType() == Material.GOLD_BLOCK) {
        event.setCancelled(true); // Cancel the normal block drop

        List<ItemStack> loot = generateLoot(); // Generate loot items
        dropLoot(block, loot); // Drop the loot items

        block.setType(Material.AIR); // Remove the block
    }
}

    private List<ItemStack> generateLoot() {
        List<ItemStack> loot = new ArrayList<>();

        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemStack ironIngot = new ItemStack(Material.IRON_INGOT);

        loot.add(diamond);
        loot.add(goldIngot);
        loot.add(ironIngot);

        return loot;
    }

    private void dropLoot(Block block, List<ItemStack> loot) {
        Random random = new Random();

        for (ItemStack item : loot) {
            int amount = random.nextInt(item.getAmount()) + 1;
            item.setAmount(amount);

            block.getWorld().dropItemNaturally(block.getLocation(), item);
        }
    }


}
