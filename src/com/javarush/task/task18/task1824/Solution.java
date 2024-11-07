package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String fileName = reader.readLine();
                try (FileInputStream fis = new FileInputStream(fileName)) {
                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
