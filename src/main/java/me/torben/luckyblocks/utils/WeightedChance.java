package me.torben.luckyblocks.utils;

import org.bukkit.Material;
import org.bukkit.event.Listener;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedChance<E> implements Listener {

    private final NavigableMap<Double, E> valueMap = new TreeMap<Double, E>();
    private final Random random = new Random();
    private double total = 0;

    private final WeightedChance<Material> randomItems = new WeightedChance<>();


    public void add(double weight, E value) {
        if(weight <= 0 ) return;
        total += weight;
        valueMap.put(total, value);
        randomItems.add(10, Material.DIAMOND);
        randomItems.add(50, Material.GOLD_INGOT);
    }

    public E next() {
        double value = random.nextDouble() * total;
        return valueMap.higherEntry(value).getValue();
    }

}
