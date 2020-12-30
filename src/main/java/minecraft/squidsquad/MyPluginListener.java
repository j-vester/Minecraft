package minecraft.squidsquad;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.*;


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
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onCatSwordSwing(PlayerInteractEvent event) {
    	if (
    			event.getPlayer().getItemInHand().equals(ExcaliPurr.excaliPurr()) 
    			&& 
    			(
    				event.getAction() == org.bukkit.event.block.Action.LEFT_CLICK_BLOCK
    				|| 
    				event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK
        		)
            )
    	{
    		//Implement what happens on click block?
    	} 
    	else if (
    			event.getPlayer().getItemInHand().equals(ExcaliPurr.excaliPurr()) 
    			&& 
    			(
    				event.getAction() == org.bukkit.event.block.Action.LEFT_CLICK_AIR
    				||
    				event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR
    			)
    		)
    	{
    		Snowball kittenball = event.getPlayer().launchProjectile(Snowball.class);
    		kittenball.setGlowing(true);
    		kittenball.setShooter(event.getPlayer());
    		Vector initialVelocity = kittenball.getVelocity();
            Windspeed wind = myPlugin.wind;
            kittenball.setVelocity(wind.applyWindToProjectile(initialVelocity));
            Bukkit.broadcastMessage(ChatColor.GOLD + event.getPlayer().getDisplayName() + "has launched a kittenball!");
    	}
    }
    
    @EventHandler
    public void onKittenBallImpact(ProjectileHitEvent e) {
    	if(e.getEntity() instanceof Snowball && e.getEntity().isGlowing() == true) {
    		Snowball kittenball = (Snowball) e.getEntity();
    		Location loc = kittenball.getLocation();
    		World world = kittenball.getWorld();
            Cat kitty = (Cat) world.spawnEntity(loc, EntityType.CAT);
            // Implement multiple kittens being spawned, preferably shooting lazors.
            // Implement lightning strike on spawn location.
    	}
    }
}
