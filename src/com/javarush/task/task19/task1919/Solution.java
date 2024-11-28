package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        String fileName = args[0];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            TreeMap<String, Double> users = new TreeMap<>();
            while (fileReader.ready()) {
                String[] words = fileReader.readLine().split(" ");
                users.put(words[0], users.getOrDefault(words[0], 0.0) + Double.parseDouble(words[1]));
            }
            for (Map.Entry<String, Double> entry : users.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
