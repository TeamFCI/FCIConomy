package de.teamfci.fciconomy.Interface;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.teamfci.fciconomy.FCIConomy;
import de.teamfci.fciconomy.SplitterManager;

public class BlutsplitterInterface implements Listener {

	public static void openInv(Player p) {

		Inventory inv = Bukkit.createInventory(null, 27, "Blutsplitterverwaltung");

		ItemStack isPlatzhalter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7);
		ItemMeta imPlatzhalter = isPlatzhalter.getItemMeta();
		imPlatzhalter.setDisplayName("");
		isPlatzhalter.setItemMeta(imPlatzhalter);

		for (int i = 0; i < 27; i++) {
			inv.setItem(i, isPlatzhalter);
		}

		ItemStack isBlutsplitter = new ItemStack(Material.PRISMARINE_SHARD,
				SplitterManager.split(SplitterManager.getMoney(p))[0]);
		ItemMeta imBlutsplitter = isBlutsplitter.getItemMeta();
		imBlutsplitter.setDisplayName(
				"§3Du hast §4" + SplitterManager.split(SplitterManager.getMoney(p))[0] + " Blutsplitter§3.");
		isBlutsplitter.setItemMeta(imBlutsplitter);
		inv.setItem(0, isBlutsplitter);

		ItemStack isBlutkristalle = new ItemStack(Material.PRISMARINE_CRYSTALS,
				SplitterManager.split(SplitterManager.getMoney(p))[1]);
		ItemMeta imKristalle = isBlutkristalle.getItemMeta();
		imKristalle.setDisplayName(
				"§3Du hast §4" + SplitterManager.split(SplitterManager.getMoney(p))[1] + " Blutkristalle§3.");
		isBlutkristalle.setItemMeta(imKristalle);
		inv.setItem(8, isBlutkristalle);

		ItemStack isTransfer = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta smTransfer = (SkullMeta) isTransfer.getItemMeta();
		smTransfer.setOwner("MHF_ArrowRight");
		smTransfer.setDisplayName("§3Blutsplitter überweisen");
		isTransfer.setItemMeta(smTransfer);
		inv.setItem(13, isTransfer);

		FCIConomy.getinv.put(p, inv);
		p.openInventory(FCIConomy.getinv.get(p));
	}

	@EventHandler
	public void onKlick(InventoryClickEvent ev) {
		Inventory invClick = ev.getClickedInventory();
		int iSlot = ev.getRawSlot();
		Player p = (Player) ev.getWhoClicked();
		if (invClick.equals(FCIConomy.getinv.get(p))) {
			ev.setCancelled(true);
			if (invClick.getName().equals("Blutsplitterverwaltung")) {
				if (iSlot == 13) {
					Ueberweisen.openInv(p, p);
				}
			}
		}
	}
}
