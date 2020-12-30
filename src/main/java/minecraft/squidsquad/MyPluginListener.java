package minecraft.squidsquad;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class MyPluginListener implements Listener {

    private final MyPlugin myPlugin;

    public MyPluginListener(MyPlugin myPlugin) {

        this.myPlugin = myPlugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("A wild player has appeared!");
        event.setJoinMessage("Please welcome " + event.getPlayer().getName() + " to the server!");
    }

    @EventHandler
    public void onProjectileFired(EntityShootBowEvent event) {
        Projectile projectile = (Projectile)event.getProjectile();
        Vector initialVelocity = projectile.getVelocity();
        Windspeed wind = myPlugin.wind;
        projectile.setVelocity(wind.applyWindToProjectile(initialVelocity));
    }
    
    @EventHandler 
    public void onShoot(ProjectileHitEvent e){
    	if (e.getEntity() instanceof Arrow) {
    		Arrow arrow = (Arrow) e.getEntity();
            Location loc = arrow.getLocation();
            World world = arrow.getWorld();
            arrow.remove();
            TNTPrimed tnt = (TNTPrimed) world.spawn(loc, TNTPrimed.class);
            tnt.setFuseTicks(1);
            arrow.remove();

    	}
    }

    public void onCreeperExplosion(EntityExplodeEvent e){
        if(e.getEntity() instanceof Creeper) {
            for (Block block : new ArrayList<Block>(e.blockList())){
                if(block.getType() == Material.BLACK_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.BLUE_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.BROWN_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.CYAN_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.GRAY_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.GREEN_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.LIGHT_BLUE_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.LIGHT_GRAY_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.LIME_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.MAGENTA_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.ORANGE_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.PINK_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.PURPLE_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.RED_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.WHITE_WOOL) {
                    e.blockList().remove(block);
                }
                if(block.getType() == Material.YELLOW_WOOL) {
                    e.blockList().remove(block);
                }
            }
        }
    } 
}
