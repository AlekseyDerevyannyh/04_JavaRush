package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list() == null || storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> advertisments = storage.list();
        List<Advertisement> result = new ArrayList<>();




    }


}
