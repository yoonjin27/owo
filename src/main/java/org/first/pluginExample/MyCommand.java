package org.first.pluginExample;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.N;
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
        return true;
    }
}
