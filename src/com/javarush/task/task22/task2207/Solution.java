package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            List<String> allWords = new ArrayList<>();
            while (reader.ready()) {
                String[] words = reader.readLine().split(" ");
                allWords.addAll(Arrays.asList(words));
            }
            List<Integer> usedIndex = new ArrayList<>();
            for (int i = 0; i < allWords.size(); i++) {
                if (usedIndex.contains(i))
                    continue;
                for (int j = i + 1; j < allWords.size(); j++) {
                    if (usedIndex.contains(j))
                        continue;
                    if (allWords.get(i).contentEquals(new StringBuilder(allWords.get(j)).reverse())) {
                        Pair pair = new Pair();
                        pair.first = allWords.get(i);
                        pair.second = allWords.get(j);
                        result.add(pair);
                        usedIndex.add(i);
                        usedIndex.add(j);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
