package dev.ender.commandtask;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TaskExecutor extends BukkitRunnable {
    public static ConcurrentHashMap<Date, List<String>> tasks = new ConcurrentHashMap<>();
    @Override
    public void run() {
        Date current = new Date(System.currentTimeMillis());
        List<Date> removeList = new ArrayList<>();
        for (Date date : tasks.keySet()) {
            if (date.getMonth() == current.getMonth() && date.getDay() == current.getDay()) {
                removeList.add(date);
                for (String command : tasks.get(date)) {
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
                }
            }
        }
        for (Date date : removeList) {
            tasks.remove(date);
        }
    }
}
