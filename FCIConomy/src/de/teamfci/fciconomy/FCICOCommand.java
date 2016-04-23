package de.teamfci.fciconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FCICOCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.sendMessage("§f[§3FCIConomy§f] §3Blutsplittersystem von Fortress Combat");
			p.sendMessage("§f[§3FCIConomy§f] §3 Für weitere Infos an Filip Zocktan richten");
		}
		return false;
	}

}
