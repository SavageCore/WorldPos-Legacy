/*
    This file is part of WorldPos.

    WorldPos is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    WorldPos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with WorldPos.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.mike724.worldpos;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Settings {
	public static File dataDir = null;
	public static boolean round = false;
	public static boolean portalSupport = false;
	public static boolean hostnameSupport = false;
	public static boolean hostnameMessage = false;
	public static ArrayList<Hostname> hostnames = new ArrayList<Hostname>();
	//public static HashMap<String, Hostname> hostnameTeleport = new HashMap<String, Hostname>();
	//public static Set<String> justHNTeleported = new HashSet<String>();
	
	private static HashMap<String, WPPlayer> players = new HashMap<String, WPPlayer>();
	
	public static WPPlayer getWPPlayer(Player p) {
		return getWPPlayer(p.getName());
	}
	
	public static WPPlayer getWPPlayer(String playerName) {
		if(!players.containsKey(playerName)) {
			Player player = Bukkit.getPlayer(playerName);
			if(player!=null) {
				players.put(playerName, new WPPlayer(player));
			}
		}
		return players.get(playerName);
	}
	
}
