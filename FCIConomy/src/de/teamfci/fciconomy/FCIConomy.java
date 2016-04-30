package de.teamfci.fciconomy;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.teamfci.fciconomy.Interface.BlutsplitterInterface;

public class FCIConomy extends JavaPlugin {

	public static HashMap<Player, Inventory> getinv = new HashMap<Player, Inventory>();
	
	@Override
	public void onEnable() {
	
		PluginManager pm = Bukkit.getServer().getPluginManager();	
		pm.registerEvents(new BlutsplitterInterface(), this);
		this.getCommand("fcico").setExecutor(new FCICOCommand());
		this.getCommand("splitter").setExecutor(new SplitterCommand());
	}
	
	
	
}
