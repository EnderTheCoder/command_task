package dev.ender.commandtask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.ParseException;

public final class CommandTask extends JavaPlugin {
    public static CommandTask INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        Config.CONFIG = this.getConfig();
        try {
            TaskExecutor.tasks = Config.getTimeToCommandMap();
        } catch (ParseException e) {
            Bukkit.getLogger().severe("你输入的日期格式有误，插件无法正常启动");
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        new TaskExecutor().runTaskTimerAsynchronously(this, 0, 10000);
        Bukkit.getLogger().info(ChatColor.AQUA +
                " \n" +
                "/$$$$$$$$                 /$$                     /$$$$$$$                      \n" +
                "| $$_____/                | $$                    | $$__  $$                     \n" +
                "| $$       /$$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$ | $$  \\ $$  /$$$$$$  /$$    /$$\n" +
                "| $$$$$   | $$__  $$ /$$__  $$ /$$__  $$ /$$__  $$| $$  | $$ /$$__  $$|  $$  /$$/\n" +
                "| $$__/   | $$  \\ $$| $$  | $$| $$$$$$$$| $$  \\__/| $$  | $$| $$$$$$$$ \\  $$/$$/ \n" +
                "| $$      | $$  | $$| $$  | $$| $$_____/| $$      | $$  | $$| $$_____/  \\  $$$/  \n" +
                "| $$$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$$| $$      | $$$$$$$/|  $$$$$$$   \\  $/   \n" +
                "|________/|__/  |__/ \\_______/ \\_______/|__/      |_______/  \\_______/    \\_/    \n" +
                "                                                                                 ");
        Bukkit.getLogger().info(ChatColor.DARK_PURPLE + "欢迎使用由EnderDev团队开发的CommandTask插件，保留所有权利");
        Bukkit.getLogger().info(ChatColor.DARK_PURPLE + "定制各种插件请联系QQ1319819214👈😘");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
