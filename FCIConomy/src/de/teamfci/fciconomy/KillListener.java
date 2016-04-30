package de.teamfci.fciconomy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillListener implements Listener {

	@EventHandler
	public void onKill(PlayerDeathEvent ev) {
		Player pDeath = ev.getEntity();
		Player pKill = pDeath.getKiller();

		int TotSplitter = SplitterManager.getMoney(pDeath);
		if(TotSplitter >= 0 && TotSplitter <=20){
				SplitterManager.addMoney(pKill, 1);
		}
		if(TotSplitter >=21 && TotSplitter <= 40){
			SplitterManager.addMoney(pKill, 3);
		}
		
		if(TotSplitter >= 41){
			SplitterManager.addMoney(pKill, 3);
		}
	}

}
