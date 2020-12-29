package minecraft.squidsquad;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Creeper;
import org.bukkit.inventory.*;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.event.*;
import org.bukkit.Material;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.entity.Player;

//import minecraft.teamocto.DefenseCreationEvent;

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
    	/*} else if (e.getEntity() instanceof Snowball) {
    		Snowball snow = (Snowball) e.getEntity();
    		Location loc = snow.getLocation();
    		World world = snow.getWorld();
    		//Spawn Creeper?
    	 */
    	}
    }

    @EventHandler
    public void onDefenseCreated(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Inventory inv = p.getInventory();
        Material material = Material.GOLDEN_PICKAXE;
        Boolean fulfilledConditionsToCreateShield = (e.useInteractedBlock() != Result.DENY) && (e.getHand() == EquipmentSlot.HAND) && (p.getInventory().getItemInMainHand().getType() == material) && (e.getAction() == Action.RIGHT_CLICK_BLOCK);
        Boolean enoughGlassPanelsInInventory = inv.contains(Material.GLASS_PANE, 9);
        if (fulfilledConditionsToCreateShield && enoughGlassPanelsInInventory){
            Location loc = e.getPlayer().getLocation();
            World world = loc.getWorld();
            // Creating custom location
            Random x = new Random();
            Random y = new Random();
            double randomX = -5 + (5 - - 5)* x.nextDouble();
            double randomY = -5 + (5 - - 5)* y.nextDouble();
            Location spawnloc = new Location (world, loc.getX()+randomX , loc.getY()+randomY, loc.getZ());
            //Spawn creeper
            Creeper creeper = (Creeper)world.spawnEntity(spawnloc, EntityType.CREEPER);
            creeper.setHealth(1);
            creeper.setMaxFuseTicks(100);
            creeper.ignite();
        }
    }
}
