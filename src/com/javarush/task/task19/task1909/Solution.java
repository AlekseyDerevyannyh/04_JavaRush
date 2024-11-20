package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {

            while (fileReader.ready()) {
                fileWriter.write(fileReader.readLine().replaceAll("\\.", "!"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
