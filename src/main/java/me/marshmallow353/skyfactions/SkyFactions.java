package me.marshmallow353.skyfactions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyFactions extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.AQUA + "               ");
        System.out.println(ChatColor.AQUA + "               ");
        System.out.println(ChatColor.AQUA + "               [SkyFactions]");
        System.out.println(ChatColor.GREEN + "         Has Loaded Successfully");
        System.out.println(ChatColor.AQUA + "               ");
        System.out.println(ChatColor.AQUA + "               ");
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("sf").setExecutor(new Commands());
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[SkyFactions] Disabled Successfully!");
        this.saveConfig();
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        //Code that will run!
        Player player = event.getPlayer();
        player.sendMessage("You Left The Bed!!");
    }



    @EventHandler
    public void onSwordClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Create An Island!")) {
            e.setCancelled(true);
            p.performCommand("sf create_command");
        }
    }

    @EventHandler
    public void onFillerClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
            e.setCancelled(true);
            p.sendMessage("You Clicked the filler item");
        }
    }


}






