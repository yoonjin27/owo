package org.first.pluginExample;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import org.bukkit.scoreboard.*;

import java.util.Objects;

public final class PluginExample extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인이 활성화되었습니다.");
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new MyCommand());
        Objects.requireNonNull(this.getCommand("openInventory")).setExecutor(new MyCommand());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인이 비활성화되었습니다.");
    }

    @EventHandler
    public void onPlayerJoinBoard(PlayerJoinEvent e) {
        createScoreBoard(e.getPlayer());
        updateScoreBoard();
    }

    @EventHandler
    public void onPlayerQuitEventBoard(PlayerQuitEvent e){
        updateScoreBoard();
    }

    public void createScoreBoard(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective o = board.registerNewObjective("My Server","dummy");
        o.setDisplayName(ChatColor.BOLD + "My Server");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = o.getScore("Players:");
        score.setScore(Bukkit.getOnlinePlayers().size());
        player.setScoreboard(board);
    }

    public void updateScoreBoard() {
        for(Player online : Bukkit.getOnlinePlayers()) {
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("Players:");
            score.setScore(Bukkit.getOnlinePlayers().size());
        }
    }

}
