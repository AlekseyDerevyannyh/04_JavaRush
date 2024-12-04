package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))) {
            while (fileReader.ready()) {
                char[] line = fileReader.readLine().toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = line.length - 1; i >= 0; i--) {
                    stringBuilder.append(line[i]);
                }
                System.out.println(stringBuilder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
