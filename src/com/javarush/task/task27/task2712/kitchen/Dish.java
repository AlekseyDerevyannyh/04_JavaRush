package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();
        for (Dish dish : values()) {
            result.append(dish.name()).append(", ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    public int getDuration() {
        return duration;
    }
}
