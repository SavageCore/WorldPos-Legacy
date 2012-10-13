package com.mike724.worldpos;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class Hostname {
	
	private String hostname;
	private String key;
	private World world;
	
	public Hostname(String hm, String k, String w) throws Exception {
		if((world = Bukkit.getWorld(w))==null) {
			throw new Exception();
		}
		key = k;
		hostname = hm;
	}
	public String getHostname() {
		return hostname;
	}
	public String getKey() {
		return key;
	}
	public World getWorld() {
		return world;
	}

}
