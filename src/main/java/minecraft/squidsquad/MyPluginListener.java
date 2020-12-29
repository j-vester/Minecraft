package minecraft.squidsquad;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
            tnt.setFuseTicks(0);
            float radius = tnt.getYield();
            tnt.setYield(radius/3);
    	} else if (e.getEntity() instanceof SpectralArrow) {
    		SpectralArrow sparrow = (SpectralArrow) e.getEntity();
    		Location locmid = sparrow.getLocation();
    		World world = sparrow.getWorld();
    		sparrow.remove();
    		Location locnorth = new Location(world,locmid.getX()+5,locmid.getY(),locmid.getZ());
    		Location loceast = new Location(world,locmid.getX(),locmid.getY(),locmid.getZ()+5);
    		Location locsouth = new Location(world,locmid.getX()-5,locmid.getY(),locmid.getZ());
    		Location locwest = new Location(world,locmid.getX(),locmid.getY(),locmid.getZ()-5);
    		TNTPrimed tntmid = (TNTPrimed) world.spawn(locmid, TNTPrimed.class);
    		TNTPrimed tntnorth = (TNTPrimed) world.spawn(locnorth, TNTPrimed.class);
    		TNTPrimed tnteast = (TNTPrimed) world.spawn(loceast, TNTPrimed.class);
    		TNTPrimed tntsouth = (TNTPrimed) world.spawn(locsouth, TNTPrimed.class);
    		TNTPrimed tntwest = (TNTPrimed) world.spawn(locwest, TNTPrimed.class);
    		tntmid.setFuseTicks(0);
    		tntnorth.setFuseTicks(40);
    		tnteast.setFuseTicks(40);
    		tntsouth.setFuseTicks(40);
    		tntwest.setFuseTicks(40);
    		float radius = tntmid.getYield();
    		tntmid.setYield(radius/2);
    		tntnorth.setYield(radius/3);
    		tnteast.setYield(radius/3);
    		tntsouth.setYield(radius/3);
    		tntwest.setYield(radius/3);
    	}
    }
    
}
