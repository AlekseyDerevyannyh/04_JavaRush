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

    public int getTotalCookingTime() {
        int totalCookingTime = 0;
        for (Dish dish : dishes) {
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "";
        StringBuilder dishesString = new StringBuilder();
        for (Dish dish : dishes) {
            dishesString.append(dish.toString()).append(",");
        }
        dishesString.deleteCharAt(dishesString.length() - 1);
        return String.format("Your order: [%s] of %s, cooking time %dmin", dishesString, tablet, getTotalCookingTime());
    }
}
