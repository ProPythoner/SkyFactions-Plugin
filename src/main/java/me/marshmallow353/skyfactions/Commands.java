package me.marshmallow353.skyfactions;


import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.bukkit.enchantments.Enchantment.*;


public class Commands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String parancs, String[] args)    {

        if(sender instanceof Player)    {
            Player p = (Player) sender;
            if(args.length == 0)    {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.AQUA + "---Help---");
                player.sendMessage(ChatColor.AQUA + "Do /sf create to create your Sky Island");
                player.sendMessage(ChatColor.AQUA + "It Will Teleport You To The Wild");
                player.sendMessage(ChatColor.AQUA + "And Will Create Your Faction Claim!");
                player.sendMessage(ChatColor.AQUA + "----------");
                return true;
            }    else    {
                switch(args[0])    {
                    case "create_command":

                        Plugin plugin = SkyFactions.getPlugin(SkyFactions.class);

                        Player player3 = (Player) sender;
                        List<String> templist = plugin.getConfig().getStringList("players");
                        UUID uuid = player3.getUniqueId();
                        String StringUUID = uuid.toString();





                        if (p.hasPermission("skyfactions.createisland.guiclick")) {
                            if (templist.contains(StringUUID)) {
                                p.sendMessage(ChatColor.RED + "This Command Is Only Executable Once, If You Need Support Please Contact An Admin!");
                                return true;
                            }
                            else {



                                int min = plugin.getConfig().getInt("min-distance");
                                int max = plugin.getConfig().getInt("max-distance");


                                int x = (int)(Math.random() * (max - min + 1) + min);

                                int z = (int)(Math.random() * (max - min + 1) + min);

                                Location randomLocation = new Location(player3.getWorld(), x, 70, z);

                                p.sendMessage(ChatColor.AQUA + "[SkyFactions]" + ChatColor.GREEN + " You Have Started Your SkyFactions Journey, Do /sf manage to manage your " + ChatColor.LIGHT_PURPLE + "SkyFaction");
                                player3.teleport(randomLocation);
                                Location center = player3.getLocation().add(0, -1, 0);
                                center.getBlock().setType(Material.BEDROCK);
                                Location left = player3.getLocation().add(0, -1, 1);
                                left.getBlock().setType(Material.OBSIDIAN);
                                Location right = player3.getLocation().add(0, -1, -1);
                                right.getBlock().setType(Material.OBSIDIAN);
                                Location forward = player3.getLocation().add(-1, -1, 0);
                                forward.getBlock().setType(Material.OBSIDIAN);
                                Location backwards = player3.getLocation().add(1, -1, 0);
                                backwards.getBlock().setType(Material.OBSIDIAN);
                                Location forwardleft = player3.getLocation().add(-1, -1, 1);
                                forwardleft.getBlock().setType(Material.OBSIDIAN);
                                Location forwardright = player3.getLocation().add(-1, -1, -1);
                                forwardright.getBlock().setType(Material.OBSIDIAN);
                                Location backwardleft = player3.getLocation().add(1, -1, 1);
                                backwardleft.getBlock().setType(Material.OBSIDIAN);
                                Location backwardright = player3.getLocation().add(1, -1, -1);
                                backwardright.getBlock().setType(Material.OBSIDIAN);

                                templist.add(StringUUID);
                                plugin.getConfig().set("players", templist);
                                plugin.saveDefaultConfig();








                                return true;

                            }

                        }
                        else{
                            p.sendMessage(ChatColor.RED + "No Permission!");
                            return true;
                        }










                    case "help":
                        Player player1 = (Player) sender;
                        player1.sendMessage(ChatColor.AQUA + "---Help---");
                        player1.sendMessage(ChatColor.AQUA + "Do /sf create to create your Sky Island");
                        player1.sendMessage(ChatColor.AQUA + "It Will Teleport You To The Wild");
                        player1.sendMessage(ChatColor.AQUA + "And Will Create Your Faction Claim!");
                        player1.sendMessage(ChatColor.AQUA + "----------");
                        return true;

                    case "create":

                        if (p.hasPermission("skyfactions.createisland.command")) {
                            Plugin plugin1 = SkyFactions.getPlugin(SkyFactions.class);

                            List<String> templist1 = plugin1.getConfig().getStringList("players");
                            UUID uuid1 = p.getUniqueId();
                            String StringUUID1 = uuid1.toString();







                            if (templist1.contains(StringUUID1)) {
                                p.sendMessage(ChatColor.RED + "This Command Is Only Executable Once, If You Need Support Please Contact An Admin!");
                            }
                            else {

                                Player player = (Player) sender;
                                Inventory inv = Bukkit.getServer().createInventory(null, 9, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Create An Island");
                                ItemStack sword = new ItemStack(Material.GRASS);
                                ItemMeta meta = sword.getItemMeta();
                                meta.setDisplayName(ChatColor.GOLD + "Create An Island!");
                                sword.setItemMeta(meta);

                                ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
                                ItemMeta meta1 = filler.getItemMeta();
                                ;
                                meta1.setDisplayName(" ");
                                filler.setItemMeta(meta1);

                                inv.setItem(0, filler);
                                inv.setItem(1, filler);
                                inv.setItem(2, filler);
                                inv.setItem(3, filler);
                                inv.setItem(4, sword);
                                inv.setItem(5, filler);
                                inv.setItem(6, filler);
                                inv.setItem(7, filler);
                                inv.setItem(8, filler);
                                p.openInventory(inv);
                                return true;
                            }
                        }
                        else{
                            p.sendMessage(ChatColor.RED + "No Permission!");
                        }


                    case "kits":
                        //Do something
                        return true;

                    case "forcecreate":



                        Plugin plugin2 = SkyFactions.getPlugin(SkyFactions.class);
                        int min = plugin2.getConfig().getInt("min-distance");
                        int max = plugin2.getConfig().getInt("max-distance");


                        int x = (int)(Math.random() * (max - min + 1) + min);

                        int z = (int)(Math.random() * (max - min + 1) + min);

                        Location randomLocation = new Location(p.getWorld(), x, 70, z);

                        p.sendMessage(ChatColor.AQUA + "[SkyFactions]" + ChatColor.GREEN + " You Have Started Your SkyFactions Journey, Do /sf manage to manage your " + ChatColor.LIGHT_PURPLE + "SkyFaction");
                        p.teleport(randomLocation);
                        Location center = p.getLocation().add(0, -1, 0);
                        center.getBlock().setType(Material.BEDROCK);
                        Location left = p.getLocation().add(0, -1, 1);
                        left.getBlock().setType(Material.OBSIDIAN);
                        Location right = p.getLocation().add(0, -1, -1);
                        right.getBlock().setType(Material.OBSIDIAN);
                        Location forward = p.getLocation().add(-1, -1, 0);
                        forward.getBlock().setType(Material.OBSIDIAN);
                        Location backwards = p.getLocation().add(1, -1, 0);
                        backwards.getBlock().setType(Material.OBSIDIAN);
                        Location forwardleft = p.getLocation().add(-1, -1, 1);
                        forwardleft.getBlock().setType(Material.OBSIDIAN);
                        Location forwardright = p.getLocation().add(-1, -1, -1);
                        forwardright.getBlock().setType(Material.OBSIDIAN);
                        Location backwardleft = p.getLocation().add(1, -1, 1);
                        backwardleft.getBlock().setType(Material.OBSIDIAN);
                        Location backwardright = p.getLocation().add(1, -1, -1);
                        backwardright.getBlock().setType(Material.OBSIDIAN);
                        return true;



                    default:
                        Player player2 = (Player) sender;
                        player2.sendMessage(ChatColor.RED + "Command Not Recognised: Do /sf help for help!");

                        return true;
                }
            }
        }

        return true;

    }

}



