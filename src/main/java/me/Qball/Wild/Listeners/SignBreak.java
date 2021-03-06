package me.Qball.Wild.Listeners;

import me.Qball.Wild.Wild;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class SignBreak implements Listener {
    private Wild wild;

    public SignBreak(Wild wild){
        this.wild = wild;
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {

        String noPerm = wild.getConfig().getString("No-Break");
        if (e.getBlock().getState() instanceof Sign) {
            Sign sign = (Sign) e.getBlock().getState();
            if (sign.getLine(0).equalsIgnoreCase("§4====================") &&
                    sign.getLine(1).equalsIgnoreCase("[§1Wild§0]") &&
                    sign.getLine(2).equalsIgnoreCase("§4====================")) {
                if (!e.getPlayer().hasPermission("wild.wildtp.break.sign")) {
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes( '&', noPerm));
                    e.setCancelled(true);
                } else {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "You have broken a wildtp sign");
                }
            }
        }
    }
}
