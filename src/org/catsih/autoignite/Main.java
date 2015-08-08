package org.catsih.autoignite;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public Main() {
    }

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        System.out.print("[AutoIgnite] Activated.");
    }

    @EventHandler
    public void onTntPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        World world = player.getWorld();
        if(player.hasPermission("autoignite.auto") && player.getItemInHand().getType() == Material.TNT) {
            block.setType(Material.AIR);
            world.spawnEntity(block.getLocation(), EntityType.PRIMED_TNT);
        }

    }
    public void onDisable() {
        System.out.print("[AutoIgnite] Plugin disabled.");
    }
}