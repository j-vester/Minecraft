package minecraft.squidsquad;

import java.util.Random;
import java.util.Iterator;
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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.*;

public class MyPluginListener implements Listener {

    private final MyPlugin myPlugin;

    public ItemStack makeUnbreakable(ItemStack item) {
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setUnbreakable(true);
        item.setItemMeta(item_meta);
        return item;
    }
    
    public MyPluginListener(MyPlugin myPlugin) {
        this.myPlugin = myPlugin;
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("A wild player has appeared!");
        event.setJoinMessage("Please welcome " + event.getPlayer().getName() + " to the server!");
        event.getPlayer().getInventory().addItem(makeUnbreakable(ExcaliPurr.excaliPurr()));
        event.getPlayer().getInventory().addItem(makeUnbreakable(new ItemStack(Material.DIAMOND_SWORD)));
        event.getPlayer().getInventory().addItem(makeUnbreakable(new ItemStack(Material.POTION, 1, (short) 1642)));
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
            tnt.setYield(radius*2/5);
    	} else if (e.getEntity() instanceof SpectralArrow) {
    		SpectralArrow sparrow = (SpectralArrow) e.getEntity();
    		Location loc0 = sparrow.getLocation();
    		Location loc1 = sparrow.getLocation();
    		Location loc2 = sparrow.getLocation();
    		Location loc3 = sparrow.getLocation();
    		Vector upwards = new Vector(0,1,0);
    		Vector dir1 = sparrow.getVelocity().normalize().multiply(-.5);
    		Vector dir2 = dir1.clone().crossProduct(upwards).multiply(2).add(dir1);
	    	Vector dir3 = dir1.clone().crossProduct(upwards).multiply(-2).add(dir1);
	    	if (e.getHitEntity() != null) {
	    		dir2.multiply(-1);
	    		dir3.multiply(-1);
    		}
    		World world = sparrow.getWorld();
    		sparrow.remove();
    		loc1.add(dir1);
    		loc2.add(dir2);
    		loc3.add(dir3);
    		TNTPrimed tnt0 = (TNTPrimed) world.spawn(loc0, TNTPrimed.class);
    		TNTPrimed tnt1 = (TNTPrimed) world.spawn(loc1, TNTPrimed.class);
    		TNTPrimed tnt2 = (TNTPrimed) world.spawn(loc2, TNTPrimed.class);
    		TNTPrimed tnt3 = (TNTPrimed) world.spawn(loc3, TNTPrimed.class);
    		tnt0.setFuseTicks(0);
    		tnt1.setFuseTicks(40);
    		tnt2.setFuseTicks(40);
    		tnt3.setFuseTicks(40);
    		float radius = tnt0.getYield();
    		tnt0.setYield(radius*2/3);
    		tnt1.setYield(radius/3);
    		tnt2.setYield(radius/3);
    		tnt3.setYield(radius/3);
    	}
    }

    public void onCreeperExplosion(EntityExplodeEvent e){
        if(e.getEntity() instanceof Creeper) {
            Iterator<Block> it = e.blockList().iterator();
            Block block;
            while(it.hasNext()){
                block = it.next();
                if(block.getType() == Material.BLACK_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.BLUE_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.BROWN_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.CYAN_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.GRAY_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.GREEN_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.LIGHT_BLUE_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.LIGHT_GRAY_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.LIME_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.MAGENTA_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.ORANGE_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.PINK_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.PURPLE_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.RED_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.WHITE_WOOL) {
                    it.remove();
                }
                else if(block.getType() == Material.YELLOW_WOOL) {
                    it.remove();
                }
            }
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
    			//Bukkit.broadcastMessage(ChatColor.RED + "Magic!");	
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
            //Bukkit.broadcastMessage(ChatColor.RED + "Orb thrown!");
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
    		//Bukkit.broadcastMessage(ChatColor.GOLD + "Orb landed!");
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
    			//Bukkit.broadcastMessage(ChatColor.GOLD + "Turned into kitten!");
    			gary.remove();
    		}
    		else {
    			gary.remove();
    		}
    	}
    }
}
