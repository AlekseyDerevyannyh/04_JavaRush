package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
            }
        }
    }

    public static void main(String[] args) {
    }
}
