package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] fileNames = new String[3];
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i] = reader.readLine();
            }
            try (FileInputStream fileInputStream = new FileInputStream(fileNames[0])) {
                byte[] firstPart;
                if (fileInputStream.available() % 2 != 0) {
                    firstPart = new byte[fileInputStream.available() / 2 + 1];
                } else {
                    firstPart = new byte[fileInputStream.available() / 2];
                }
                byte[] secondPart = new byte[fileInputStream.available() / 2];
                int count1 = fileInputStream.read(firstPart, 0, firstPart.length);
                int count2 = fileInputStream.read(secondPart, 0, fileInputStream.available());
                try (FileOutputStream fileOutputStream = new FileOutputStream(fileNames[1])) {
                    fileOutputStream.write(firstPart, 0, count1);
                }
                try (FileOutputStream fileOutputStream = new FileOutputStream(fileNames[2])) {
                    fileOutputStream.write(secondPart, 0, count2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
