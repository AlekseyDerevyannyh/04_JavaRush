package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) throws IOException {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String inputMessage = "Введите название блюда: ";
        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage(inputMessage);
        String message = "";
        out: while (!(message = readString()).equalsIgnoreCase("exit")) {
            for (Dish dish : Dish.values()) {
                if (message.equalsIgnoreCase(dish.name())) {
                    dishes.add(dish);
                    writeMessage(inputMessage);
                    continue out;
                }
            }
            writeMessage("Такого блюда не существует!");
            writeMessage(inputMessage);
        }
        return dishes;
    }
}
