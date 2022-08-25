package dev.ender.commandtask;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TaskExecutor extends BukkitRunnable {
    public static ConcurrentHashMap<Date, String> tasks = new ConcurrentHashMap<>();
    @Override
    public void run() {
        Date current = new Date(System.currentTimeMillis());
        List<Date> removeList = new ArrayList<>();
        for (Date date : tasks.keySet()) {
            if (date.getYear() == current.getYear() && date.getMonth() == current.getMonth() && date.getDay() == current.getDay()) {
                removeList.add(date);
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), tasks.get(date));
            }
        }
        for (Date date : removeList) {
            tasks.remove(date);
        }
    }
}
