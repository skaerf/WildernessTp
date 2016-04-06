package me.Qball.Wild.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetGui {
	public static void OpenSet(Player p)
	{
		
		ItemStack Close = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta meta = Close.getItemMeta();
		meta.setDisplayName("Close");
		Close.setItemMeta(meta);
		Inventory Set = Bukkit.createInventory(p,18,"WildTp");
		p.openInventory(Set);
		Set.setItem(0,MinX());
		Set.setItem(2,MaxX());
		Set.setItem(4,MinZ());
		Set.setItem(17,Close);
	}
	public static ItemStack MinX()
	{
		ItemStack MinX = new ItemStack(Material.BOOK_AND_QUILL,1);
		ItemMeta meta = MinX.getItemMeta();
		meta.setDisplayName("MinX");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Click to set the No permission to make a sign message");
		MinX.setItemMeta(meta);
		return MinX;
	}
	public static ItemStack MaxX()
	{
		ItemStack MaxX = new ItemStack(Material.BOOK_AND_QUILL,1);
		ItemMeta meta = MaxX.getItemMeta();
		meta.setDisplayName("MaxX");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Click to set the No permission to make a sign message");
		MaxX.setItemMeta(meta);
		return MaxX;
	}
	public static ItemStack MinZ()
	{
		ItemStack MinZ = new ItemStack(Material.BOOK_AND_QUILL,1);
		ItemMeta meta = MinZ.getItemMeta();
		meta.setDisplayName("MinX");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Click to set the No permission to make a sign message");
		MinZ.setItemMeta(meta);
		return MinZ;
	}
	
}