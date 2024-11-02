package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] fileNames = new String[3];
            for (int i = 0; i < 3; i++) {
                fileNames[i] = reader.readLine();
            }
            try (FileOutputStream fos1 = new FileOutputStream(fileNames[0]);
                FileInputStream fis2 = new FileInputStream(fileNames[1])) {
                while (fis2.available() > 0) {
                    fos1.write(fis2.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (FileOutputStream fos1 = new FileOutputStream(fileNames[0], true);
                 FileInputStream fis3 = new FileInputStream(fileNames[2])) {
                while (fis3.available() > 0) {
                    fos1.write(fis3.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
