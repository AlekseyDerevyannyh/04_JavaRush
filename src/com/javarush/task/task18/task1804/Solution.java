package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int[] counts = new int[256];
        while (fileInputStream.available() > 0) {
            counts[fileInputStream.read()]++;

        }
        fileInputStream.close();

        int min = Integer.MAX_VALUE;
        for (int element : counts) {
            if (element < min && element >= 1)  min = element;
        }

        ArrayList<Byte> result = new ArrayList<>();
        for (int i = 0; i < 256; i ++) {
            if (counts[i] == min) {
                result.add((byte) i);
            }
        }

        result.forEach(b -> System.out.print(b + " "));
    }
}
