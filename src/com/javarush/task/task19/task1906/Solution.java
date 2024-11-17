package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String inputFileName = reader.readLine();
            String outputFileName = reader.readLine();
            try (FileReader fileReader = new FileReader(inputFileName);
                 FileWriter fileWriter = new FileWriter(outputFileName)) {
                boolean even = false;
                while (fileReader.ready()) {
                    int symbol = fileReader.read();
                    if (even) {
                        fileWriter.write(symbol);
                        even = false;
                    } else {
                        even = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
