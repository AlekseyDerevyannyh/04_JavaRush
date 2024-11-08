package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        if (args == null || args.length != 3) {
            return;
        }
        if (args[0].equals("-e")) {
            encrypt(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            decrypt(args[1], args[2]);
        }
    }

    public static void encrypt(String fileName, String fileOutputName) {
        try (FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName)) {
            while(fis.available() > 0) {
                int oneByte = fis.read();
                fos.write(oneByte == 255 ? 0 : oneByte + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(String fileName, String fileOutputName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(fileOutputName)) {
            while(fis.available() > 0) {
                int oneByte = fis.read();
                fos.write(oneByte == 0 ? 255 : oneByte - 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
