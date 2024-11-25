package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            TreeMap<String, Double> persons = new TreeMap<>();

            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");
                if (line.length != 2) {
                    continue;
                }
                persons.put(line[0], persons.getOrDefault(line[0], 0.0) + Double.parseDouble(line[1]));
            }
            Double max = 0.0;
            for (Map.Entry<String, Double> entry : persons.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            TreeSet<String> personsWithMaxSum = new TreeSet<>();
            for (Map.Entry<String, Double> entry : persons.entrySet()) {
                if (entry.getValue().equals(max)) {
                    personsWithMaxSum.add(entry.getKey());
                }
            }
            personsWithMaxSum.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
