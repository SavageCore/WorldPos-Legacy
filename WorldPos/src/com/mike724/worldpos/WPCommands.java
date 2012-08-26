package com.mike724.worldpos;

import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WPCommands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("world") || command.getName().equalsIgnoreCase("worldwarp")) {
			World w; Player p;
			if(args.length==1) {
				w = Bukkit.getWorld(args[0]);
				p = Bukkit.getPlayerExact(sender.getName());
			} else if(args.length==2) {
				w = Bukkit.getWorld(args[1]);
				p = Bukkit.getPlayer(args[0]);
			} else {
				return false;
			}
			String wn = (w==null) ? "null" : w.getName();
			boolean perm = false;
			if(p==null) {
				sender.sendMessage(ChatColor.RED+"Target Player could not be found"); return false;
			} else if(w==null) {
				sender.sendMessage(ChatColor.RED+"Target world could not be found"); return false;
			}
			perm = p.hasPermission("WorldPos.world."+wn);
			if(!perm) {
				sender.sendMessage(ChatColor.RED+"You do not have permission to access that world"); return true;
			}
			if(w!=p.getWorld()) {
				try {
					p.teleport(LocationManager.getPastLocation(w, p));
					p.sendMessage(ChatColor.AQUA+"Teleported to world "+ChatColor.YELLOW+wn);
					return true;
				} catch(IOException e) {
					e.printStackTrace();
					p.sendMessage(ChatColor.RED+"Could not read player data! Report to admin");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.AQUA+"You are already in world "+ChatColor.YELLOW+wn);
				return true;
			}
		}
		return false;
	}
	
}
