package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            Set<Integer> bytes = new TreeSet<>();
            while (fileInputStream.available() > 0) {
                bytes.add(fileInputStream.read());
            }
            bytes.forEach(b -> System.out.print(b + " "));
        }
    }
}
