package de.teamfci.fciconomy.Interface;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.teamfci.fciconomy.FCIConomy;
import de.teamfci.fciconomy.SplitterManager;

public class Ueberweisen {
	static ItemStack isBlutsplitter;
	static ItemStack isBlutkristalle;
	static Inventory inv = Bukkit.createInventory(null, 45, "Transaktion bearbeiten");
	public static void openInv(Player p, Player pGet){
		
		isBlutsplitter = new ItemStack(Material.PRISMARINE_SHARD, SplitterManager.split(SplitterManager.getMoney(p))[0]);
		isBlutkristalle = new ItemStack(Material.PRISMARINE_CRYSTALS, SplitterManager.split(SplitterManager.getMoney(p))[1]);
		
		ItemStack isPlatzhalter = new ItemStack(Material.STAINED_GLASS_PANE,1 ,(byte) 7);
		ItemMeta imPlatzhalter = isPlatzhalter.getItemMeta();
		imPlatzhalter.setDisplayName("");
		isPlatzhalter.setItemMeta(imPlatzhalter);
		
		for (int i = 0; i < 45; i++) {
			inv.setItem(i, isPlatzhalter);
		}
		
		ItemMeta imBlutsplitter = isBlutsplitter.getItemMeta();	
		imBlutsplitter.setDisplayName("§3Du hast §4" + SplitterManager.split(SplitterManager.getMoney(p))[0] + " Blutsplitter§3.");
		isBlutsplitter.setItemMeta(imBlutsplitter);
		inv.setItem(0, isBlutsplitter);
		
		ItemMeta imKristalle = isBlutkristalle.getItemMeta();	
		imKristalle.setDisplayName("§3Du hast §4" + SplitterManager.split(SplitterManager.getMoney(p))[1] + " Blutkristalle§3.");
		isBlutkristalle.setItemMeta(imKristalle);
		inv.setItem(8, isBlutkristalle);
		
		ItemStack isplus10 = new ItemStack(Material.SKULL_ITEM);
		SkullMeta smisplus10 = (SkullMeta) isplus10.getItemMeta();
		smisplus10.setDisplayName("§2+10");
		smisplus10.setOwner("MHF_ArrowRight");
		isplus10.setItemMeta(smisplus10);
		inv.setItem(24, isplus10);
		
		
		
		FCIConomy.getinv.put(p, inv);
		p.openInventory(FCIConomy.getinv.get(p));
	}
	
	@EventHandler
	public void onKlick(InventoryClickEvent ev){
		
		Inventory invClick = ev.getClickedInventory();
		int iSlot = ev.getRawSlot();
		Player p = (Player) ev.getWhoClicked();
		if(invClick.equals(FCIConomy.getinv.get(p))){
			ev.setCancelled(true);
			if(invClick.getName().equals(inv.getName())){
				if(iSlot == 0){
					
				}
			}
		}
	}
}
