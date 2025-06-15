package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State previousState = thread.getState();
        System.out.println(previousState);
        while (!previousState.equals(State.TERMINATED)) {
            Thread.State currentState = thread.getState();
            if (!previousState.equals(currentState)) {
                System.out.println(currentState);
                previousState = currentState;
            }
        }
    }
}
