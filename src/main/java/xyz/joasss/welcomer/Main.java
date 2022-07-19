package xyz.joasss.welcomer;

import java.io.File;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public final class Main extends JavaPlugin implements Listener {


	private Object plugin;

	// When the plugin gets enabled
	@Override
	public void onEnable() {
		getLogger().info("Thank you for chosing Welcomer!");
		this.saveDefaultConfig();

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new Welcome(this), this);	
		
		// Check if the config exists and create a new one
		File file = new File(getDataFolder() + File.separator + "config.yml");
	    if (!file.exists()) {
	      getLogger().info("Generating config.yml..");
	      getConfig().options().copyDefaults(true);
	      saveConfig();
	    } 
	}
	
	// When the plugin gets disabled
	@Override
	public void onDisable() {
		getLogger().info("Welcomer is now disabled, thanks for chosing Welcomer!");
	}
	
	// When commands are used
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Send the /welcomer response
		if (cmd.getName().equalsIgnoreCase("welcomer")) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eWelcomer &fV1.0.0 &7by &eJoa_sss&7 - A simple welcome messages project for Minecraft."));
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("welcomerreload")) {
			if (sender instanceof Player) {
		        Player p = (Player)sender;
		        this.reloadConfig();
		        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Reloaded the configuration file for &eWelcomer&7."));
		      } else {
		        this.reloadConfig();
		        getLogger().info("Welcomer configuration file reloaded.");
		      }  
			return true;
		}
		return false;
	}
}
