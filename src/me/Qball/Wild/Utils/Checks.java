package me.Qball.Wild.Utils;

import java.util.ArrayList;
import java.util.List;

import me.Qball.Wild.Wild;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Checks{
	public static boolean inNether;
	public static boolean inEnd;
	public static boolean loaded;
	public static boolean world;
	public static boolean blacklist;
	public static Plugin wild = Wild.getInstance();
	static List<String> worlds = wild.getConfig().getStringList("Worlds");
	 public  boolean getLiquid(Location loc)
	  {
		 loc.setY(loc.getBlockY() - 2.0);
		 int x = loc.getBlockX();
		 int z = loc.getBlockZ();
		 if (loc.getWorld().getBlockAt(loc).isLiquid()
				  ||loc.getWorld().getBiome(x,z).equals(Biome.OCEAN)
				  ||loc.getWorld().getBiome(x, z).equals(Biome.DEEP_OCEAN))
	    	 return true;
		  else
			  return false;
	  }
	  public  boolean inNether(int tempx,int tempz, Player target)
	  {
		 
		  if (target.getWorld().getBiome(tempx, tempz) == Biome.HELL)
	      {
	    	  inNether = true; 
	      }
		  else
		  {
			  inNether = false;
		  }
		  return inNether;
	  }
	  public  boolean inEnd(int tempx,int tempz, Player target)
	  {
		 
		  if (target.getWorld().getBiome(tempx, tempz) == Biome.SKY)
	      {
	    	  inEnd = true;
	      }
		  else
		  {
			  inEnd = false;
		  }
		  return inEnd;
	  }
	  public  void isLoaded(int tempx, int tempz, Player target)
	  {
		 
		
		if (!target.getWorld().isChunkLoaded(tempx,tempz) )
			  target.getWorld().getChunkAt(tempx, tempz).load();
		  
	  }	 
	  public  int getSoildBlock(int x, int z, Player target)
	  {
		
		  int y = 0;
		  for (int i = target.getWorld().getMaxHeight(); i>= 0; i --)
		  {
			 y = i;
			 if(!target.getWorld().getBlockAt(x, y, z).isEmpty())
			 {
				y+=2;
				break;
			 }
		  }
		
		 return y;
	  }
	  public  boolean world(Player p) 
	  {
		ArrayList<String> allWorlds = new ArrayList<String>();
		ConfigurationSection sec = wild.getConfig().getConfigurationSection("Worlds");
		for(String key : sec.getKeys(false))
		{
			allWorlds.add(key);
		}
				 if (allWorlds.contains(p.getLocation().getWorld().getName()))
				 {
					 world=true;
					 allWorlds.clear();
				 }
				 else
				 {
					 world = false;
					 allWorlds.clear();
							 
				 }
				 return world;
	  }
	  public  boolean blacklistBiome(Location loc)
	  {
		
		 
		  List<String> biomes = wild.getConfig().getStringList("Blacklisted_Biomes");
		  if(biomes.size()==0)
		  {
			  blacklist = false;
		  }
		  else
		  {
		  for (int i = 0; i <= biomes.size(); i++)
		  {
			  String biome = biomes.get(i).toString().toUpperCase();
			  if(loc.getBlock().getBiome() == Biome.valueOf(biome))
			  {	
				  blacklist= true;
				  break;
			  
			  } 
			else{
			  		if (i==biomes.size())
			  		{
			  			blacklist=false;
			  		}
			  	}
			  	
			  
		  }
		  }
		return blacklist;
	  }
}
