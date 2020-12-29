package minecraft.squidsquad;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;


public class MyCommandExecutor implements CommandExecutor {
    private final MyPlugin plugin;

    public MyCommandExecutor(MyPlugin plugin) {
        this.plugin = plugin;
    }
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String commandName = command.getName();

        switch (commandName.toLowerCase()) {
            case "ping":
                handlePing(sender, command, label, args);
                break;
            case "spm":
                spawnMonster(sender, command, label, args);
                break;
            case "setwinddir":
                handleWindDirection(sender, command, label, args);
                break;
            case "setwindspd":
                handleWindSpeed(sender, command, label, args);
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean handlePing(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Pong!");
        return true;
    };

    private boolean spawnMonster(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player)sender;
            Location loc = p.getLocation();
            //World world = p.getWorld();
            //Creeper creeper = world.spawnEntity(loc, Creeper.class);
            p.getWorld().spawnEntity(loc, EntityType.DOLPHIN);
        }
        return true;
    };

    private boolean handleWindSpeed(CommandSender sender, Command command, String label, String[] args){
        if (args.length == 1){
            try{
                int speedModifier = Integer.parseInt(args[0]);
                plugin.wind.changeWindSpeed(speedModifier);
                sender.sendMessage("Windspeed has been modified!");
            }
            catch (NumberFormatException e){
                sender.sendMessage("This command requires an integer!");
                return false;
            }
            return true;
        }
        sender.sendMessage("This command requires one integer as argument!");
        return false;
    }
    
    private boolean handleWindDirection(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            try{
                int x = Integer.parseInt(args[0]);
                int z = Integer.parseInt(args[1]);
                /*boolean xInRange = (-1 <= x && x <= 1);
                boolean zInRange = (-1 <= z && z <= 1);
                if (xInRange && zInRange){
                    plugin.wind.changeWindSpeed(x, z);
                    sender.sendMessage("Wind velocity has been set");
                }
                else{
                    sender.sendMessage("valid values are -1, 0, 1");
                    return false;
                }*/
                plugin.wind.changeWindDirection(x, z);
                sender.sendMessage("Wind velocity has been set!");
            }
            catch (NumberFormatException e){
                sender.sendMessage("This command requires two integers");
                return false;
            }
            return true;
        }
        sender.sendMessage("This command requires exactly two integers");
        return false;
    }
}
