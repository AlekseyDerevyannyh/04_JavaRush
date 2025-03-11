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

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        if (horses == null || horses.isEmpty())
            return null;
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("horse1", 3.0, 0.0);
        Horse horse2 = new Horse("horse2", 3.0, 0.0);
        Horse horse3 = new Horse("horse3", 3.0, 0.0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game = new Hippodrome(horses);
        game.run();
    }
}
