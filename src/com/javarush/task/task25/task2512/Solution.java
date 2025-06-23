package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> exceptions = new LinkedList<>();
        while (e != null) {
            exceptions.add(0, e);
            e = e.getCause();
        }
        exceptions.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                throw new RuntimeException("DEF", new IllegalAccessException("GHI"));
            }
        };
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
