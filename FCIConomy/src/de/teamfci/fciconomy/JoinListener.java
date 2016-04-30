package de.teamfci.fciconomy;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
		
	@EventHandler
	public void onJoin(PlayerJoinEvent ev){
		Player p = ev.getPlayer();
		File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Economy//Splitter.yml");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!cfg.contains("Blutsplitter." + p.getName())){
			double Null = (double) 0;
			cfg.set("Blutsplitter." + p.getName(), Null);
			try {
				cfg.save(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
