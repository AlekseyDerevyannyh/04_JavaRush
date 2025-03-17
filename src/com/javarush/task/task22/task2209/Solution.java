package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] words;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
                stringBuilder.append(" ");
            }
            words = stringBuilder.toString().trim().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null) {
            return result;
        }

        List<String> wordsList = new ArrayList<>(List.of(words));
        for (int i = 0; i < wordsList.size() - 1; i++) {
            for (int j = i + 1; j < wordsList.size(); j++) {
                if (wordsList.get(i).substring(wordsList.get(i).length() - 1).equalsIgnoreCase(wordsList.get(j).substring(0, 1))) {
                    if (j != i + 1) {
                        String tmp = wordsList.get(j);
                        wordsList.set(j, wordsList.get(i + 1));
                        wordsList.set(i + 1, tmp);
                    }
                    break;
                }
            }
        }
        for (String word : wordsList) {
            if (!result.isEmpty())
                result.append(" ");
            result.append(word);
        }
        return result;
    }
}

