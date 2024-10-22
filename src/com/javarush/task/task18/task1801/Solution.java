package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int max = 0;
        while (fileInputStream.available() > 0) {
            int currentByte = fileInputStream.read();
            if (currentByte > max) {
                max = currentByte;
            }
        }
        fileInputStream.close();
        System.out.println(max);
    }
}
