package de.teamfci.fciconomy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FCIConomy extends JavaPlugin {

	@Override
	public void onEnable() {
	
		PluginManager pm = Bukkit.getServer().getPluginManager();	
		
		this.getCommand("fcico").setExecutor(new FCICOCommand());
	}
	
	
	
}
