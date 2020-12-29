package minecraft.squidsquad;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ShapedRecipe;

public class ExcaliPurr extends JavaPlugin implements Listener{
	
	Logger excaliPurrLogger = Bukkit.getLogger();
	
	@Override
    public void onEnable(){
		System.out.println("ExcaliPurr from AttackPlugin has been enabled!");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
		String excaliPurr = ("ExcaliPurr");
		ItemStack myItem = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta im = myItem.getItemMeta();
		im.setDisplayName(excaliPurr);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This mythical blade is used to summon mythical creatures!");
		myItem.setItemMeta(im);
        @SuppressWarnings("deprecation")
		ShapedRecipe hRecipe = new ShapedRecipe(myItem);
        hRecipe.shape(
                "#@#",
                "!@!",
                "#&#");
        hRecipe.setIngredient('@', Material.IRON_INGOT);
        hRecipe.setIngredient('!', Material.NETHERITE_INGOT);
        hRecipe.setIngredient('#', Material.AIR);
            Bukkit.getServer().addRecipe(hRecipe);
	}
	
	@Override
    public void onDisable(){
            System.out.println("ExcaliPurr from AttackPlugin has been disabled!");
    }
	
	public static void giveCatBlade(Player player) {
		String excaliPurr = ("ExcaliPurr");
		ItemStack myItem = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta im = myItem.getItemMeta();
		im.setDisplayName(excaliPurr);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This mythical blade is used to summon mythical creatures!");
		myItem.setItemMeta(im);
		player.sendMessage(ChatColor.RED + "You have been given ExcaliPurr!");
		player.getInventory().addItem(myItem);
	}
	
	@Override
	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) theSender;
		if(commandLabel.equalsIgnoreCase("ExcaliPurr")){
			ExcaliPurr.giveCatBlade(player);
		}
		return true;
	}
}
