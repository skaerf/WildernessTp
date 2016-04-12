package me.Qball.Wild.Commands;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import me.Qball.Wild.*;
import me.Qball.Wild.GUI.*;
public class CmdWildTp implements CommandExecutor{
	
	private final  Wild plugin;
	public static Plugin wild = Wild.getInstance();
	public CmdWildTp(Wild plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("Wildtp")) {
			if (sender instanceof Player) {
				final Player player = (Player) sender;
				if (args.length == 0) {
					player.sendMessage(ChatColor.GOLD+ "-------------------Help-------------------------");
					player.sendMessage(ChatColor.GOLD+ "* Command:       Description:                  *");
					player.sendMessage(ChatColor.GOLD+ "* /Wild Teleports player to random location    *");
					player.sendMessage(ChatColor.GOLD+ "* /Wild [player] Teleports the specfied player *");
					player.sendMessage(ChatColor.GOLD+ "* to a radom location                          *");
					player.sendMessage(ChatColor.GOLD+ "* /WildTp reload Reloads the plugin's config   *");
					player.sendMessage(ChatColor.GOLD+ "* /WildTp set <minx,maxX,minz,maxz,cool,cost,  *");
					player.sendMessage(ChatColor.GOLD+ "* swound> allow you to set the min and max x   *");
					player.sendMessage(ChatColor.GOLD+ "* and z and cooldown and cost and sound for    *"); 
					player.sendMessage(ChatColor.GOLD+ "* using the command                            *");
					player.sendMessage(ChatColor.GOLD+ "* /WildTp Shows wild help message              *");
					player.sendMessage(ChatColor.GOLD+ "------------------------------------------------");
						
				}
				else if (args.length >= 1) {

					final String str = args[0];

					if (str.equalsIgnoreCase("reload")) {
						if (!player.hasPermission("wild.wildtp.reload")) {
							player.sendMessage(ChatColor.RED+ "Sorry you do not have permission to reload the plugin");
						} else {
						Wild.Reload(player);
						} 
					}
					
				if (str.equalsIgnoreCase("set"))
				{
					if(player.hasPermission("wild.wildtp.set"))
					{
						if (args.length>=2)
						{
							 String Set = args[1];
							String set = Set.toLowerCase();
							
							switch(set)
							{
							
							case "minx":
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									System.out.println(plugin);
									plugin.getConfig().set("MinX",(Object) X);
									 
									 player.sendMessage(ChatColor.GREEN+"You have set the MinX");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
								}
							break;

							case "maxx":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 System.out.println(plugin);
									 plugin.getConfig().set("MaxX", (Object)X);
									 player.sendMessage(ChatColor.GREEN+"You have set the MaxX");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
								}
							break;

							case "minz":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 System.out.println(plugin);
									 plugin.getConfig().set("MinZ", (Object)X);
									 player.sendMessage(ChatColor.GREEN+"You have set the MinZ");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
								}
							break;
							
								
							case "maxz":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 System.out.println(plugin);
									 plugin.getConfig().set("MaxZ",  (Object)X);
									 player.sendMessage(ChatColor.GREEN+"You have set the MaxZ");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
									
								}
								break;
							case "cool":
								
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 System.out.println(plugin);
									 plugin.getConfig().set("Cooldown",  (Object)X);
									 player.sendMessage(ChatColor.GREEN+"You have set the cooldown");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
									
								}
							break;
							case "cost":
								
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 System.out.println(plugin);
									 plugin.getConfig().set("Cost",  (Object)X);
									 player.sendMessage(ChatColor.GREEN+"You have set the cost for using the command");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
									
								}
							break;

							case "sound":


								if (args.length>=3)
								{
									StringBuilder sb = new StringBuilder();
									
								for (int i = 3; i < 4; i++) {
								     sb.append(" ").append(args[i]);
								}
								System.out.println(plugin);
									 plugin.getConfig().set("MaxX", sb.toString());
									 player.sendMessage(ChatColor.GREEN+"You have set the Sound");
									 plugin.saveConfig();
								}
								else
								{
									player.sendMessage(ChatColor.DARK_RED + "You must specify a value");
								}
							break;

								default:
									player.sendMessage(ChatColor.RED+"Only enter minx,minz,maxx,maxz,cool,or costor sound");
									break;
								
						 	
								
							}//end switch
						
							
						
					}//args length 2
						
						else
						{
							player.sendMessage(ChatColor.RED+" Please enter minx,minz,maxx,maxz,cool,or cost");
						}
						
					}//perm set
					else
					{
						player.sendMessage("You dont have permssion to set the x or z values");
						
				}
				
					
				}// str == set
			else if(str.equalsIgnoreCase("add"))
				{
					if(player.hasPermission("wild.wildtp.set"))
					{
						if(args.length >=2)
						{
							String add = args[1].toLowerCase();
							switch(add)
							{ 
							case "world":
								if(args.length>=3)
								{
									String world = args[2];
									
									List<String> Worlds = Wild.getWorlds();
									 Worlds.add(world);
									 System.out.println(plugin);
									 plugin.getConfig().set("Worlds", Worlds);
									 plugin.saveConfig();
									 player.sendMessage(ChatColor.GREEN+"You have added " + world + " to the allowed worlds");
								}
								else
								{
									player.sendMessage(ChatColor.RED+"Please enter a world");
								}
								break;
							case "potion":
								if(args.length>=3)
								{
									String potion = args[2];
								
										List<String> Potions = Wild.getListPots();
									    Potions.add(potion);
									    System.out.println(plugin);
									    plugin.getConfig().set("Potions", Potions);
										plugin.saveConfig();
				 						sender.sendMessage("You have added " + potion + " to the list of potions");
									
								}
								else
								{
									sender.sendMessage("Please enter a potion");
								}
								break;
							} 
							
							
						}
					}
				}

				else if (str.equalsIgnoreCase("gui"))
				{
					if(player.hasPermission("wild.wildtp.set"))
					{
					MainGui.OpenGUI(player);
					MainGui.putEdit(player);
					}
				
				}
				
				}// args length 1
			}// end if player
			 else {

				if (args.length == 0) {
					sender.sendMessage( "-------------------Help-------------------------");
					sender.sendMessage( "* Command:       Description:                  *");
					sender.sendMessage( "* /Wild Teleports player to random location    *");
					sender.sendMessage( "* /Wild [player] Teleports the specfied player *");
					sender.sendMessage( "* to a radom location                          *");
					sender.sendMessage( "* /WildTp reload Reloads the plugin's config   *");
					sender.sendMessage( "* /Wildtp set <minx,maxX,minz,maxz,cool,cost>  *");
					sender.sendMessage( "* allow you to set the min and max x and z and *"); 
					sender.sendMessage( "* the cooldown and cost for using the command  *");
					sender.sendMessage( "* /Wildtp Shows plugin help message              *");
					sender.sendMessage( "------------------------------------------------");
				}

				else if (args.length == 1) {

					String Str = args[0];

					if (Str.equalsIgnoreCase("reload")) {

						Bukkit.getServer().getPluginManager().getPlugin("plugin").reloadConfig();
						sender.sendMessage("[pluginnernessTP] Plugin config has successfuly been reload");

					}
					if (Str.equalsIgnoreCase("set"))
					{
						
						if (args.length>=2)
						{
							final String set = args[1];
							switch(set)
							{
							
							case "minx":
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									
									 plugin.getConfig().set("MinX",(Object) X);
									 
									 sender.sendMessage("You have set the MinX");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage( "You must specify a value");
								}
							break;

							case "maxx":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 plugin.getConfig().set("MaxX", (Object)X);
									 sender.sendMessage("You have set the MaxX");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage( "You must specify a value");
								}
							break;

							case "minz":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 plugin.getConfig().set("MinZ", (Object)X);
									 sender.sendMessage("You have set the MinZ");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage( "You must specify a value");
								}
							break;
							
								
							case "maxz":
							
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 plugin.getConfig().set("MaxZ",  (Object)X);
									 sender.sendMessage("You have set the MaxZ");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage( "You must specify a value");
									
								}
								break;
							case "cool":
								
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 plugin.getConfig().set("Cooldown",  (Object)X);
									 sender.sendMessage("You have set the cooldown");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage( "You must specify a value");
									
								}
							break;
							case "cost":
								
								if (args.length>=3)
								{
									String x = args[2];
									 int X = Integer.parseInt(x);
									 plugin.getConfig().set("Cost",  (Object)X);
									 sender.sendMessage("You have set the cost for using the command");
									 plugin.saveConfig();
								}
								else
								{
									sender.sendMessage("You must specify a value");
									
								}
							break;
								default:
									sender.sendMessage("Only enter minx,minz,maxx,maxz,cool,or cost");
									break;
								
						 	
								
							}//end switch
							if(Str.equalsIgnoreCase("add"))
							{
								
									if(args.length >=2)
									{
										String add = args[1].toLowerCase();
										switch(add)
										{ 
										case "world":
											if(args.length>=3)
											{
												String world = args[2];
												 @SuppressWarnings( "unchecked" )
												List<String> Worlds = (List<String>)plugin.getConfig().getList("Worlds");
												 Worlds.add(world);
												 plugin.getConfig().set("Worlds", Worlds);
												 plugin.saveConfig();
						 						 sender.sendMessage("You have added " + world + " to the allowed worlds");
											}
											else
											{
												sender.sendMessage(" Please enter a world");
											}
											break;
										case "potion":
											if(args.length>=3)
											{
												String potion = args[2];
												List<String> Potions = Wild.getListPots();		
												Potions.add(potion);
											    plugin.getConfig().set("Potions", Potions);
												plugin.saveConfig();
							 					sender.sendMessage("You have added " + potion + " to the list of potions");
												
											}
											else
											{
												sender.sendMessage("Please enter a potion");
											}
											break;
										}
										
										
									
								}
							}
						
					}
					

				
			}

		}
			 }
				
			
		}
		return false;
	}
	

}
