package xyz.joasss.welcomer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class Welcome implements Listener {
	
	public Main plugin;
	
	public Welcome(Main main) {
	    this.plugin = main;
	  }
	
	// When a player joins
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		
		if (!p.hasPlayedBefore()) {
			if (this.plugin.getConfig().getBoolean("FirstJoin")) {
				if (this.plugin.getConfig().getBoolean("SendMessage")) {
					String firstJoinMsg = this.plugin.getConfig().getString("FirstJoinMessage");
				    Integer playersOnline = Integer.valueOf(Bukkit.getOnlinePlayers().size());
				    
				    // Replace the join message with variables
				    firstJoinMsg = firstJoinMsg.replace("{player}", p.getName());
				    firstJoinMsg = firstJoinMsg.replace("{online}", playersOnline.toString());
				    firstJoinMsg = firstJoinMsg.replace("{world}", p.getWorld().getName());
				    firstJoinMsg = firstJoinMsg.replace("{PLAYER}", p.getName());
				    firstJoinMsg = firstJoinMsg.replace("{ONLINE}", playersOnline.toString());
				    firstJoinMsg = firstJoinMsg.replace("{WORLD}", p.getWorld().getName());
				    
				    // Send the join message
			        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', firstJoinMsg));
				}
			}
		}
		
		
		// Check if join message is enabled
		if (this.plugin.getConfig().getBoolean("SendMessage")) {
			String joinMsg = this.plugin.getConfig().getString("WelcomeMessage");
		    Integer playersOnline = Integer.valueOf(Bukkit.getOnlinePlayers().size());
		    
		    // Replace the join message with variables
		    joinMsg = joinMsg.replace("{player}", p.getName());
		    joinMsg = joinMsg.replace("{online}", playersOnline.toString());
		    joinMsg = joinMsg.replace("{world}", p.getWorld().getName());
		    joinMsg = joinMsg.replace("{PLAYER}", p.getName());
		    joinMsg = joinMsg.replace("{ONLINE}", playersOnline.toString());
		    joinMsg = joinMsg.replace("{WORLD}", p.getWorld().getName());
		    
		    // Send the join message
	        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMsg));
		}
		
		// Check if user messages are enabled
		if (this.plugin.getConfig().getBoolean("UserEnabled")) {
			String userMsg = this.plugin.getConfig().getString("UserMessage");
			Integer playersOnline = Integer.valueOf(Bukkit.getOnlinePlayers().size());
				    
			// Replace the join message with variables
			userMsg = userMsg.replace("{player}", p.getName());
			userMsg = userMsg.replace("{online}", playersOnline.toString());
			userMsg = userMsg.replace("{world}", p.getWorld().getName());
			userMsg = userMsg.replace("{PLAYER}", p.getName());
			userMsg = userMsg.replace("{ONLINE}", playersOnline.toString());
			userMsg = userMsg.replace("{WORLD}", p.getWorld().getName());
				    
			// Send the join message
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', userMsg));
				}
	}
}