package minecraft.squidsquad;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.bukkit.util.Vector;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.*;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.entity.*;

public class MyPluginListener implements Listener {

    private final MyPlugin myPlugin;

    public MyPluginListener(MyPlugin myPlugin) {
        this.myPlugin = myPlugin;
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("A wild player has appeared!");
        event.setJoinMessage("Please welcome " + event.getPlayer().getName() + " to the server!");
        event.getPlayer().getInventory().addItem(ExcaliPurr.excaliPurr());
        event.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        event.getPlayer().getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 1642));
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
    	event.getPlayer().getInventory().addItem(ExcaliPurr.excaliPurr());
        event.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        event.getPlayer().getInventory().addItem(new ItemStack(Material.POTION, 1, (short) 1642));
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
            tnt.setYield(radius/2);
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
    		tntmid.setYield(radius*2/3);
    		tntnorth.setYield(radius/3);
    		tnteast.setYield(radius/3);
    		tntsouth.setYield(radius/3);
    		tntwest.setYield(radius/3);
    	}
    }

    public void onCreeperExplosion(EntityExplodeEvent e){
        if(e.getEntity() instanceof Creeper) {
            e.blockList().removeIf(block -> (block.getType() == Material.BLACK_WOOL));
            e.blockList().removeIf(block -> (block.getType() == Material.BLUE_WOOL));
            e.blockList().removeIf(block -> (block.getType() == Material.BROWN_WOOL));
               
            /*if(block.getType() == Material.BROWN_WOOL) {
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
            }*/
        }
    } 

    
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onCatSwordRightClick(PlayerInteractEntityEvent event) {
    	if(event.getHand().equals(EquipmentSlot.HAND)) {
    		if (
    			event.getPlayer().getItemInHand().equals(ExcaliPurr.excaliPurr())
				&& (
					event.getRightClicked().getType().equals(EntityType.CREEPER)
    				||
    				event.getRightClicked().getType().equals(EntityType.GHAST)
				)
    		){
    			Location loc = event.getRightClicked().getLocation();
    			World world = event.getRightClicked().getWorld();
    			event.getRightClicked().remove();
    			Firework fw = (Firework) world.spawnEntity(loc, EntityType.FIREWORK);
    			FireworkMeta fwm = fw.getFireworkMeta();
    			fwm.setPower(6);
    			fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
    			fw.setFireworkMeta(fwm);
    			fw.detonate();
    	    	Cat kitty = (Cat) world.spawnEntity(loc, EntityType.CAT);
    			kitty.setOwner(event.getPlayer());
    			Bukkit.broadcastMessage(ChatColor.RED + "Magic!");	
    		}
    	}
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onCatSwordSwing(PlayerInteractEvent event) {
    	if (
    		event.getPlayer().getItemInHand().equals(ExcaliPurr.excaliPurr()) 
    		&& 
    		event.getAction() == org.bukkit.event.block.Action.LEFT_CLICK_AIR
    	){
    		Snowball kittenball = event.getPlayer().launchProjectile(Snowball.class);
    		kittenball.setGlowing(true);
    		kittenball.setShooter(event.getPlayer());
    		Vector initialVelocity = kittenball.getVelocity();
            Windspeed wind = myPlugin.wind;
            kittenball.setVelocity(wind.applyWindToProjectile(initialVelocity));
            Bukkit.broadcastMessage(ChatColor.RED + "Orb thrown!");
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
            Random x = new Random();
            Random z = new Random();
            double randomX = -3 + (3 - - 3)* x.nextDouble();
            double randomZ = -3 + (3 - - 3)* z.nextDouble();
            Location spawnloc = new Location (world, loc.getX()+randomX , loc.getY(), loc.getZ()+randomZ);
            Creeper creeper = (Creeper)world.spawnEntity(spawnloc, EntityType.CREEPER);
            creeper.setHealth(1);
            creeper.setMaxFuseTicks(100);
            creeper.ignite();
        }
    }
    
    @EventHandler
    public void onKittenBallHitsCreeperOrGhast(ProjectileHitEvent e) {
    	if(
    		e.getEntity() instanceof Snowball 
    		&& 
    		e.getEntity().isGlowing() == true
    	){
    		Bukkit.broadcastMessage(ChatColor.GOLD + "Orb landed!");
    		Location loc = e.getEntity().getLocation();
    		World world = e.getEntity().getWorld();
    		Firework fw = (Firework) world.spawnEntity(loc, EntityType.FIREWORK);
    		FireworkMeta fwm = fw.getFireworkMeta();
    		fwm.setPower(6);
    		fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
    		fw.setFireworkMeta(fwm);
    	    fw.detonate();
			Ghast gary = (Ghast) world.spawnEntity(loc, EntityType.GHAST);
    		if (
    			e.getHitEntity().getType().equals(EntityType.CREEPER) 
    			||
    			e.getHitEntity().getType().equals(EntityType.GHAST)
    		) {
    			e.getHitEntity().remove();
    			Cat kitty = (Cat) world.spawnEntity(loc, EntityType.CAT);
    			kitty.setOwner((AnimalTamer) e.getEntity().getShooter());
    			Bukkit.broadcastMessage(ChatColor.GOLD + "Turned into kitten!");
    			gary.remove();
    		}
    		else {
    			gary.remove();
    		}
    	}
    }
}
