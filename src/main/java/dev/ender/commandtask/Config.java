package dev.ender.commandtask;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Config {

    public static Configuration CONFIG = CommandTask.INSTANCE.getConfig();

    public static ConcurrentHashMap<Date, String> getTimeToCommandMap() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ConfigurationSection tasks = CONFIG.getConfigurationSection("tasks");
        ConcurrentHashMap<Date, String> map = new ConcurrentHashMap<>();
        for (String date : tasks.getKeys(false)) {
            String rDate = "2022-" + date;
            String taskCommand = tasks.getString(date);
            Date taskDate = format.parse(rDate);
            if (taskDate != null) {
                map.put(taskDate, taskCommand);
            }
        }
        return map;
    }
}
