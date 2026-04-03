package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Thread demon = new Thread( () ->
        {
            try {
                while (true) {
                    while (orderQueue.isEmpty())
                        Thread.sleep( 10 );

                    for (Cook cook : statisticManager.getCooks())
                        if (!cook.isBusy()){
                            cook.startCookingOrder(orderQueue.poll());
                        }

                }
            } catch (InterruptedException e) {
            }
        } );
        demon.setDaemon( true );
        demon.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
