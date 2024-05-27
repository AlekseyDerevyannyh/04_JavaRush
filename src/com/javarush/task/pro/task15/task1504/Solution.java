package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             InputStream inputStream = Files.newInputStream(Path.of(scanner.nextLine()));
             OutputStream outputStream = Files.newOutputStream(Path.of(scanner.nextLine()))
        ) {
            while (inputStream.available() > 0) {
                byte[] bytes = new byte[2];
                int read = inputStream.read(bytes);
                if (read != 1) {
                    byte tmp = bytes[0];
                    bytes[0] = bytes[1];
                    bytes[1] = tmp;
                }
                outputStream.write(bytes, 0, read);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
    }
}

