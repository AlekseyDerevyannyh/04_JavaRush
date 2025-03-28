package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2)
            return;
        try (FileInputStream inputStream = new FileInputStream(args[0]);
             FileOutputStream outputStream = new FileOutputStream(args[1])) {
            while (inputStream.available() > 0) {
                byte[] buffer = new byte[16];
                int count = inputStream.read(buffer);
                String text = new String(buffer, 0 , count, "Windows-1251");
                buffer = text.getBytes(StandardCharsets.UTF_8);
                outputStream.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
