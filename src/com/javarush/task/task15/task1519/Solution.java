package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            while (!input.equals("exit")) {
                try {
                    Integer integerValue = Integer.valueOf(input);
                    if (integerValue > 0 && integerValue < 128) {
                        short shortValue = Short.parseShort(input);
                        print(shortValue);
                    } else {
                        print(integerValue);
                    }
                } catch (NumberFormatException ex) {
                    try {
                        Double doubleValue = Double.valueOf(input);
                        print(doubleValue);
                    } catch (NumberFormatException e) {
                        print(input);
                    }
                }
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
