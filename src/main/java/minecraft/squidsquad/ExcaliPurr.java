package minecraft.squidsquad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ShapedRecipe;

public class ExcaliPurr extends JavaPlugin{
	
	public static ItemStack excaliPurr() {
		ItemStack expurr = new ItemStack(Material.NETHERITE_SWORD);
		ItemMeta im = expurr.getItemMeta();
		im.setDisplayName(ChatColor.GREEN + "ExcaliPurr");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("This mythical blade is used to summon mythical creatures!");
		im.setLore(lore);
		expurr.setItemMeta(im);
		return(expurr);
	}
	
	public static void registerCatSwordRecipe(String pluginname) {
		System.out.println("ExcaliPurr from AttackPlugin has been enabled!");
		ItemStack expurr = excaliPurr();
		@SuppressWarnings("deprecation")
		NamespacedKey key = new NamespacedKey(pluginname, "ExcaliPurr");
		ShapedRecipe recipe = new ShapedRecipe(key, expurr);
        recipe.shape(
                " ! ",
                " @ ",
                " & ");
        recipe.setIngredient('@', Material.IRON_INGOT);
        recipe.setIngredient('!', Material.NETHERITE_INGOT);
        recipe.setIngredient('#', Material.AIR);
        recipe.setIngredient('&', Material.STICK);
        Bukkit.getServer().addRecipe(recipe);
	}

}
