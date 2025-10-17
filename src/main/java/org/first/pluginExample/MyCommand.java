package org.first.pluginExample;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class MyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, @NotNull String[] args) {
        if(cmd.getName().equalsIgnoreCase("test")) {
            if(sender instanceof Player) {
                sender.sendMessage("플러그인 작동");
                return false;
            }
            sender.sendMessage("========================" + "\r  \n"
                    + "                콘솔창에서 입력되었습니다." + "\r\n"
                    + "                플레이어가 치시기 바랍니다." + "\r\n"
                    + "                 ========================");
            return false;
        }

        if(cmd.getName().equals("openInventory"))
        {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                openCustomInventory(player);
                return true;
            }
            return false;
        }
        return true;
    }

    public void openCustomInventory(Player player)
    {
        Inventory customInventory = Bukkit.createInventory(null, 9, "Custom Inventory");

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = diamondSword.getItemMeta();
        if (meta != null)
        {
            meta.setDisplayName("Special Diamond Sword");
            diamondSword.setItemMeta(meta);
        }

        customInventory.setItem(8, diamondSword);

        player.openInventory(customInventory);
    }
}
