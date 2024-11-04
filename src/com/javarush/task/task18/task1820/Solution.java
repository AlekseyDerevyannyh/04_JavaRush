package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()));
             PrintWriter printWriter = new PrintWriter(new FileWriter(reader.readLine()))) {

            while (bufferedFileReader.ready()) {
                String[] splitLine = bufferedFileReader.readLine().split(" ");
                for (String numberInString : splitLine) {
                    double number = Double.parseDouble(numberInString);
                    long roundedNumber = Math.round(number);
                    printWriter.print(roundedNumber + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}