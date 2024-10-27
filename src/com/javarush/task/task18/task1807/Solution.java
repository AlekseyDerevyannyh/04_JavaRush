package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                int count = 0;
                while (fileInputStream.available() > 0) {
                    if (fileInputStream.read() == 0x2c) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
