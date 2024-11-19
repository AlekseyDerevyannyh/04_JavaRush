package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {

            ArrayList<Integer> numbers = new ArrayList<>();
            while (fileReader.ready()) {
                String line = fileReader.readLine().replaceAll("\\s", " ");
                for (String word : line.split(" ")) {
                    try {
                        Integer number = Integer.parseInt(word);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                    }
                }
            }

            for (Integer number : numbers) {
                fileWriter.write(String.valueOf(number));
                fileWriter.write(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
