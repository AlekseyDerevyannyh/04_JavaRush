package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             FileWriter fileWriter = new FileWriter(args[1])) {
            StringBuilder writeLine = new StringBuilder();
            while (fileReader.ready()) {
                String[] words = fileReader.readLine().split(" ");
                for (String word : words) {
                    if (word.matches(".*\\d.*")) {
                        writeLine.append(word).append(" ");
                    }
                }
            }
            fileWriter.write(writeLine.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
