package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            ArrayList<String> result = new ArrayList<>();
            while (fileReader.ready()) {
                String[] words = fileReader.readLine().split(" ");
                StringBuilder resultLine = new StringBuilder();
                for (String word : words) {
                    if (word.matches("^[0-9][,.!?;:]*$")) {
                        if (word.length() == 1) {
                            resultLine.append(map.get(Integer.parseInt(word))).append(" ");
                        } else {
                            String newWord = map.get(Integer.parseInt(word.substring(0, 1))) +
                                    word.substring(1);
                            resultLine.append(newWord).append(" ");
                        }
                    } else if(word.matches("^(1[0-2])[.,!?;:]*$")) {
                        if (word.length() == 2) {
                            resultLine.append(map.get(Integer.parseInt(word))).append(" ");
                        } else {
                            String newWord = map.get(Integer.parseInt(word.substring(0, 2))) +
                                    word.substring(2);
                            resultLine.append(newWord).append(" ");
                        }
                    } else {
                        resultLine.append(word).append(" ");
                    }
                }
                result.add(resultLine.toString().trim());
            }
            result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
