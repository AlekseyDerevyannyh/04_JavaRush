package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            ConsoleHelper.writeMessage(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            ConsoleHelper.writeMessage(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                ConsoleHelper.writeMessage(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }


    public void printActiveVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        Map<String, Integer> activeVideos = statisticAdvertisementManager.getActiveVideoSet();
        for (String name : activeVideos.keySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %d", name, activeVideos.get(name)));
        }

    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();
        Set<String> archivedVideos = statisticAdvertisementManager.getArchivedVideoSet();
        for (String name : archivedVideos) {
            ConsoleHelper.writeMessage(name);
        }
    }
}
