package minecraft.squidsquad;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.event.Listener;

public class ExcaliPurr implements Listener{
	
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
	
	public static ShapedRecipe catSwordRecipe() {
		ItemStack expurr = excaliPurr();
		@SuppressWarnings("deprecation")
		NamespacedKey key = new NamespacedKey("Squid-squad", "ExcaliPurr");
		ShapedRecipe recipe = new ShapedRecipe(key, expurr);
        recipe.shape(
                " ! ",
                " @ ",
                " & ");
        recipe.setIngredient('@', Material.IRON_INGOT);
        recipe.setIngredient('!', Material.NETHERITE_INGOT);
        recipe.setIngredient('#', Material.AIR);
        recipe.setIngredient('&', Material.STICK);
        return(recipe);
	}

}
