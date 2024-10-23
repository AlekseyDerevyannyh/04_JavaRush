package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> bytes = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            bytes.add(fileInputStream.read());
        }

        int[] counts = new int[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            for (int j = 0; j < bytes.size(); j++) {
                if (i != j && bytes.get(i).equals(bytes.get(j))) {
                    counts[i] ++;
                }
            }
        }
        fileInputStream.close();
        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
            }
        }
        ArrayList<Integer> maxBytes = new ArrayList<>();
        for (int i = 0; i < bytes.size(); i++) {
            if (counts[i] == max) {
                maxBytes.add(bytes.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value : maxBytes) {
            if (!result.contains(value)) {
                result.add(value);
            }
        }
        result.forEach(b -> System.out.print(b + " "));
    }
}
