package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {

    private StatisticAdvertisementManager () {}

    private static class InstanceHolder {
        private static final StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    }

    public static StatisticAdvertisementManager getInstance() {
        return InstanceHolder.ourInstance;
    }

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public Map<String, Integer> getActiveVideoSet() {
        Map<String, Integer> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        List<Advertisement> videos = storage.list();
        for (Advertisement video : videos) {
            if (video.isActive())
                result.put(video.getName(), video.getHits());
        }
        return result;
    }

    public Set<String> getArchivedVideoSet() {
        Set<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        List<Advertisement> videos = storage.list();
        for (Advertisement video : videos) {
            if (!video.isActive())
                result.add(video.getName());
        }
        return result;
    }
}
