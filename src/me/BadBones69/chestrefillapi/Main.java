package me.BadBones69.chestrefillapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(commandLable.equalsIgnoreCase("refillchance")){
			Player player = (Player) sender;
			HashMap<ItemStack, Integer> items = new HashMap<ItemStack, Integer>();
			items.put(new ItemStack(Material.WOOD_AXE), 90);
			items.put(new ItemStack(Material.GOLD_AXE), 70);
			items.put(new ItemStack(Material.IRON_AXE), 50);
			items.put(new ItemStack(Material.DIAMOND_AXE), 20);
			ChestRefillAPI.refillChest(player.getTargetBlock((HashSet<Byte>)null, 7).getLocation(), items, 2);
			player.sendMessage("You have just refilled a chest.");
			return true;
		}
		if(commandLable.equalsIgnoreCase("refillitems")){
			Player player = (Player) sender;
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			items.add(new ItemStack(Material.WOOD_AXE));
			items.add(new ItemStack(Material.GOLD_AXE));
			items.add(new ItemStack(Material.IRON_AXE));
			items.add(new ItemStack(Material.DIAMOND_AXE));
			ChestRefillAPI.refillChest(player.getTargetBlock((HashSet<Byte>)null, 7).getLocation(), items);
			player.sendMessage("You have just refilled a chest.");
			return true;
		}
		return false;
	}
	
}