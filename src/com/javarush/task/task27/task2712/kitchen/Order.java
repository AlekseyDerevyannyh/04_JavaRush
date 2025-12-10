package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        StringBuilder dishesString = new StringBuilder();
        for (Dish dish : dishes) {
            dishesString.append(dish.toString()).append(",");
        }
        dishesString.deleteCharAt(dishesString.length() - 1);
        return String.format("Your order: [%s] of %s", dishesString, tablet);
    }
}
