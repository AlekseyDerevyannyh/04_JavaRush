package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger count = new AtomicInteger(Thread.MIN_PRIORITY);

    {
        if (count.get() > Thread.MAX_PRIORITY) {
            count.set(Thread.MIN_PRIORITY);
        }
        setPriority(count.getAndIncrement());
    }

    public MyThread() {
    }

    public MyThread(Runnable task) {
        super(task);
    }

    public MyThread(ThreadGroup group, Runnable task) {
        super(group, task);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable task, String name) {
        super(task, name);
    }

    public MyThread(ThreadGroup group, Runnable task, String name) {
        super(group, task, name);
    }

    public MyThread(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
    }
}
