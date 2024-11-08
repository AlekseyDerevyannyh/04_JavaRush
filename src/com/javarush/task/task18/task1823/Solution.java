package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (!(input = reader.readLine()).equals("exit")) {
                new ReadThread(input).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try (FileInputStream fis = new FileInputStream(this.getName())) {
                int[] counts = new int[128];
                while (fis.available() > 0) {
                    counts[fis.read()]++;
                }
                int maxCountIndex = 0;
                for (int i = 0; i < counts.length; i ++) {
                    if (counts[i] > counts[maxCountIndex]) {
                        maxCountIndex = i;
                    }
                }
                resultMap.put(this.getName(), maxCountIndex);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
