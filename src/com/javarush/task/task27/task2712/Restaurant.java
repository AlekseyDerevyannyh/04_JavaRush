package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Cook cook = new Cook("Amigo");
        Cook cook2 = new Cook("Diego");
        StatisticManager.getInstance().register(cook);
        StatisticManager.getInstance().register(cook2);
        List<Tablet> tablets = new ArrayList<>();

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        OrderManager orderManager = new OrderManager();

        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i + 1));
            tablets.get(i).addObserver(orderManager);
        }

//        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            return;
//        }
//        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
