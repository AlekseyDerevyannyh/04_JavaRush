package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {
            String line;
             do {
                line = bufferedReader.readLine();
                bufferedWriter.write(line + "\n");
            } while (!line.equals("exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
