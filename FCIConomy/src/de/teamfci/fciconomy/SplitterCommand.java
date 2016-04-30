package de.teamfci.fciconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.teamfci.fciconomy.Interface.BlutsplitterInterface;

public class SplitterCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (arg3.length == 2) {
				if (arg3[0].equalsIgnoreCase("set")) {
					SplitterManager.setMoney(p, Double.parseDouble(arg3[1]));
				} else {
					BlutsplitterInterface.openInv(p);
				}
			} else {
				BlutsplitterInterface.openInv(p);
			}
		}

		return false;
	}

}
