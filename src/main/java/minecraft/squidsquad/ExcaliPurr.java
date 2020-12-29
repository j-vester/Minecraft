package minecraft.squidsquad;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ExcaliPurr extends JavaPlugin{
	
	Logger excaliPurrLogger = Bukkit.getLogger();
	
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
