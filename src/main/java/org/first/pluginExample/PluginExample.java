package org.first.pluginExample;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PluginExample extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인이 활성화되었습니다.");
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new MyCommand());
        Objects.requireNonNull(this.getCommand("openInventory")).setExecutor(new MyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인이 비활성화되었습니다.");
    }
}
