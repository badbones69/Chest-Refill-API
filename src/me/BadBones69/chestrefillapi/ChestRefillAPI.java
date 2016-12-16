package me.BadBones69.chestrefillapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.ItemStack;

public class ChestRefillAPI {
	
	/**
	 * This method will automatically fill a chest with items in a list.
	 * 
	 * Great if you just want a specified list of items you want to go into a chest.
	 * 
	 * @param loc The location of the chest.
	 * @param items The items that will be randomly placed in the chest.
	 */
	public static void refillChest(Location loc, ArrayList<ItemStack> items){
		if(isChest(loc)){
			Chest chest = (Chest) loc.getBlock().getState();
			chest.getBlockInventory().clear();
			for(ItemStack item : items){
				for(int i = 0; i <= 100; i++){
					int slot = new Random().nextInt(chest.getBlockInventory().getSize());
					if(chest.getBlockInventory().getItem(slot) == null){
						chest.getBlockInventory().setItem(slot, item);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * This method will automatically fill a chest with items and has its own Chance/100 system.
	 * 
	 * Great if you want to use a chance system without making your own.
	 * 
	 * @param loc The location of the chest.
	 * @param itemsWithChance The items with their chance.
	 * @param maxItems The max amount of items that will be in the chest.
	 */
	public static void refillChest(Location loc, HashMap<ItemStack, Integer> itemsWithChance, Integer maxItems){
		if(isChest(loc)){
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			for(int i = 0; items.size() <= 1; i++){
				for(ItemStack item : itemsWithChance.keySet()){
					if(isSuccessfull(itemsWithChance.get(item))){
						items.add(item);
					}
				}
				if(i >= 100){
					Bukkit.getLogger().log(Level.WARNING, "[ChestRefillAPI]: No items were successfull so the chest refilled will be empty.");
					return;
				}
			}
			for(; items.size() > maxItems;){
				items.remove(new Random().nextInt(items.size()));
			}
			Chest chest = (Chest) loc.getBlock().getState();
			chest.getBlockInventory().clear();
			for(ItemStack item : items){
				for(int i = 0; i <= 100; i++){
					int slot = new Random().nextInt(chest.getBlockInventory().getSize());
					if(chest.getBlockInventory().getItem(slot) == null){
						chest.getBlockInventory().setItem(slot, item);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * A quick method to check if the block is a chest.
	 * @param loc The location of the block.
	 * @return True if the block is a chest and false if not.
	 */
	public static Boolean isChest(Location loc){
		if(loc.getBlock() != null){
			if(loc.getBlock().getType() == Material.CHEST){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isSuccessfull(int chance){
		if(chance >= 100){
			return true;
		}
		Random number = new Random();
		int c = 1 + number.nextInt(chance);
		if(c >= 1 && c <= chance){
			return true;
		}
		return false;
	}
	
}