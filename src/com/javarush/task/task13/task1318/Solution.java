package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = null;
        InputStream inputStream = null;
        Scanner scanner = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String filePath = reader.readLine();

            inputStream = new FileInputStream(filePath);
            scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
            if (inputStream != null)
                inputStream.close();
            if (scanner != null)
                scanner.close();
        }
    }
}