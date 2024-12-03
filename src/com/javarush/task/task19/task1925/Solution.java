package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }
        String fileName1 = args[0];
        String fileName2 = args[1];
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
             FileWriter fileWriter = new FileWriter(fileName2)) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                String[] words = fileReader.readLine().split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        stringBuilder.append(word).append(",");
                    }
                }
            }
            String result = "";
            if (stringBuilder.length() > 1) {
                result = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
            }

            fileWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
