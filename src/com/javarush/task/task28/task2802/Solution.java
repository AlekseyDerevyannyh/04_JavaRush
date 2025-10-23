package com.javarush.task.task28.task2802;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(0);
        private final AtomicInteger treadNumber = new AtomicInteger(0);
        private final String threadName = Thread.currentThread().getThreadGroup().getName() +
                "-pool-" +
                poolNumber.incrementAndGet() +
                "-thread-";

        @Override
        public Thread newThread(Runnable r) {
            Thread tr = new Thread(r, threadName +
                    treadNumber.incrementAndGet());
            tr.setDaemon(false);
            tr.setPriority(Thread.NORM_PRIORITY);
            return tr;
        }
    }
}
