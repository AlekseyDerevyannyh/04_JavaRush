package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException, IOException {
        if (storage.list() == null || storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                advertisements.add(advertisement);
            }
        }
        List<Advertisement> advertisementsForShow = new ArrayList<>();
        getAdvertisement(advertisements, advertisementsForShow);
        if (advertisementsForShow.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(advertisementsForShow);
        for (Advertisement advertisement : advertisementsForShow) {
            ConsoleHelper.writeMessage(advertisement.toString());
            advertisement.revalidate();
        }
    }

    private void getAdvertisement(List<Advertisement> advertisements, List<Advertisement> advertisementsForShow) {
        if (advertisements == null || advertisements.isEmpty()) {
            return;
        }
        if (checkDuration(advertisements)) {
            if (advertisementsForShow.isEmpty()) {
                advertisementsForShow.addAll(advertisements);
                return;
            }
            Comparator<List<Advertisement>> advertisementsComparator = new Comparator<List<Advertisement>>() {
                @Override
                public int compare(List<Advertisement> o1, List<Advertisement> o2) {
                    long sumAmount1 = o1.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
                    long sumAmount2 = o2.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum();
                    if (sumAmount1 == sumAmount2) {
                        int sumDuration1 = o1.stream().mapToInt(Advertisement::getDuration).sum();
                        int sumDuration2 = o2.stream().mapToInt(Advertisement::getDuration).sum();
                        if (sumDuration1 == sumDuration2) {
                            return o2.size() - o1.size();
                        }
                        return Integer.compare(sumDuration1, sumDuration2);
                    }
                    return Long.compare(sumAmount1, sumAmount2);
                }
            };
            if (advertisementsComparator.compare(advertisements, advertisementsForShow) > 0) {
                advertisementsForShow.clear();
                advertisementsForShow.addAll(advertisements);
            }
            return;
        }
        for (Advertisement advertisement : advertisements) {
            List<Advertisement> advertisementRec = new ArrayList<>(advertisements);
            advertisementRec.remove(advertisement);
            getAdvertisement(advertisementRec, advertisementsForShow);
        }
    }

    private boolean checkDuration(List<Advertisement> advertisements) {
        int sumDuration = advertisements.stream().mapToInt(Advertisement::getDuration).sum();
        return sumDuration <= timeSeconds;
    }
}