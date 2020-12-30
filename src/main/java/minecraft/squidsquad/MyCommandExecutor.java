package minecraft.squidsquad;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.*;

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
            case "setwind":
                handleWind(sender, command, label, args);
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
    
    private boolean handleWind(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 2){
            try{
                int x = Integer.parseInt(args[0]);
                int z = Integer.parseInt(args[1]);
                plugin.wind.changeWindSpeed(x, z);
                sender.sendMessage("Wind velocity has been set");
            }
            catch (NumberFormatException e){
                sender.sendMessage("This command requires integers");
                return false;
            }
            return true;
        }
        sender.sendMessage("This command requires two integers as x and z values");
        return false;
    }
}
