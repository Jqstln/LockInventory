package com.justinnndev.lockinventory;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {

    boolean isEnabled = false;


    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event)
    {
        if(isEnabled==true)
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event)
    {
        if(isEnabled==true)
        {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryMoveItemEvent event)
    {
        if(isEnabled==true)
        {
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event)
    {
        if(isEnabled==true)
        {
            event.setCancelled(true);
        }
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("lockinventory"))
        {
            if(isEnabled==false)
            {
                getServer().broadcastMessage(ChatColor.GOLD + "LockInventory has been enabled!");
                isEnabled = true;
                return true;
            }
            if(isEnabled==true) {
                getServer().broadcastMessage(ChatColor.GOLD + "LockInventory has been disabled");
                isEnabled = false;
                return true;
            }

        }
        return true;
    }
}