package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            try (FileInputStream fis1 = new FileInputStream(fileName1)) {
                int[] bytes = new int[fis1.available()];
                for (int i = 0; i < bytes.length; i++) {
                    bytes[i] = fis1.read();
                }
                try (FileOutputStream fos1 = new FileOutputStream(fileName1);
                     FileInputStream fis2 = new FileInputStream(fileName2)) {
                    while (fis2.available() > 0) {
                        fos1.write(fis2.read());
                    }
                    for (int oneByte : bytes) {
                        fos1.write(oneByte);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
