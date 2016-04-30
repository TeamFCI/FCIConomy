package de.teamfci.fciconomy;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * @author Filip
 *
 */
public class SplitterManager{
	public static File file = new File("plugins//Fortress-Combat-System//Fortress-Combat-PvP-System//Economy//Splitter.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public SplitterManager() {
		
	}

	public static int getMoney(Player p) {

		try {
			return cfg.getInt("Blutsplitter." + p.getName());
		} catch (NullPointerException ex) {
			cfg.set("Blutsplitter." + p.getName(), 0);
		}

			return cfg.getInt("Blutsplitter." + p.getName());
	}

	public static void setMoney(Player p, double Value) {

		cfg.set("Blutsplitter." + p.getName(), Value);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addMoney(Player p, int value) {

		int newV = (getMoney(p) + value);

		cfg.set("Blutsplitter." + p.getName(), newV);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int[] split(int Splitter){
		
		int splitter = 0;
		int crystals = 0;
		
		crystals = (Splitter/64);
		splitter = (Splitter-(crystals*64));
		
		int[] splitted = {splitter,crystals};
		
		return splitted;
	}

	public static void removeMoney(Player p, int value) {

		int newV = (getMoney(p) - value);

		cfg.set("Blutsplitter." + p.getName(), newV);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void transferMoney(Player pFrom, Player pTo, int Value) {

		double iMoneypFrom = getMoney(pFrom);
		if (iMoneypFrom >= Value) {
			removeMoney(pFrom, Value);
			addMoney(pTo, Value);
			pFrom.sendMessage("§f[§3FCIConomy§f] §3Du hast " + pTo.getName() + " einen Betrag von \"" + Value
					+ " Blutsplittern\" überwiesen.");
		} else {
			pFrom.sendMessage("§f[§3FCIConomy§f] §3Du hast nicht genug §4Blutsplitter §3 um " + pTo.getName()
					+ " einen Betrag von \"" + Value + " Blutsplittern\" zu überweisen.");
		}

	}

}
