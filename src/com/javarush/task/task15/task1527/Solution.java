package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        int startParamIndex = url.indexOf("?");

        if (startParamIndex > 0) {
            String[] array = url.substring(startParamIndex + 1).split("&");
            List<String> objValues = new ArrayList<>();

            for (String item : array) {
                int indexValue = item.indexOf("=");

                if (indexValue > 0) {
                    String key = item.substring(0, indexValue);
                    String value = item.substring(indexValue + 1);

                    if (key.equals("obj")) {
                        System.out.print(key);
                        objValues.add(value);
                    } else {
                        System.out.print(key);
                    }
                } else {
                    System.out.print(item);
                }

                System.out.print(" ");
            }

            System.out.println();

            for (String item : objValues) {
                try {
                    alert(Double.parseDouble(item));
                } catch (Exception e) {
                    alert(item);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
