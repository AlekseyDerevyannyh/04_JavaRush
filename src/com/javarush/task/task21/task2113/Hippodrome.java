package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for(int i = 1; i <= 100; i ++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void move() {}

    public void print() {}

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("horse1", 3.0, 0.0);
        Horse horse2 = new Horse("horse2", 3.0, 0.0);
        Horse horse3 = new Horse("horse3", 3.0, 0.0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
    }
}
