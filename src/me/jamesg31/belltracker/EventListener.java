package me.jamesg31.belltracker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        BellTracker.playerJoin(event.getPlayer());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock().getType().equals(Material.BELL) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            BellTracker.setScore(event.getPlayer());
        }
    }
}
