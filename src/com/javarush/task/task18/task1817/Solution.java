package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }
        try (FileReader fileReader = new FileReader(args[0])) {
            int countSpace = 0;
            int countAll = 0;
            while (fileReader.ready()) {
                if (fileReader.read() == (int) ' ') {
                    countSpace++;
                }
                countAll++;
            }
            System.out.printf("%.2f", (double) countSpace / countAll * 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
