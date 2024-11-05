package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            return;
        }
        try (FileReader fileReader = new FileReader(args[0])) {
            Map<Integer, Integer> symbols = new TreeMap<>();
            while (fileReader.ready()) {
                int symbol = fileReader.read();
                symbols.put(symbol, symbols.get(symbol) == null ? 1 : symbols.get(symbol) + 1);
            }

            symbols.forEach((symbol, count) -> System.out.printf("%s %d\n", (char) (int) symbol, count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
