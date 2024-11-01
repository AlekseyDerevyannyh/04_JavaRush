package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        try (FileReader fileReader = new FileReader(args[0])) {
            int count = 0;
            Set<Character> alphabet = new HashSet<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                alphabet.add(c);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                alphabet.add(c);
            }
            while (fileReader.ready()) {
                if (alphabet.contains((char) fileReader.read())) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
