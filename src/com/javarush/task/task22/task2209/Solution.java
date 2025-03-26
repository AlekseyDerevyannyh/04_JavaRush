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
        System.out.println(result.toString().split("\nили\n")[0]);
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) {
            return result;
        }
        if (words.length == 1) {
            return result.append(words[0]);
        }

        List<String> firstCharacters = new ArrayList<>();
        List<String> lastCharacters = new ArrayList<>();
        for (String word : words) {
            String firstCharacter = word.substring(0, 1).toLowerCase();
            String lastCharacter = word.substring(word.length() - 1).toLowerCase();
            if (firstCharacters.contains(lastCharacter)) {
                firstCharacters.remove(lastCharacter);
                if (lastCharacters.contains(firstCharacter)) {
                    lastCharacters.remove(firstCharacter);
                } else {
                    firstCharacters.add(firstCharacter);
                }
            } else {
                if (lastCharacters.contains(firstCharacter)) {
                    lastCharacters.remove(firstCharacter);
                } else {
                    firstCharacters.add(firstCharacter);
                }
                lastCharacters.add(lastCharacter);
            }
        }

        if (firstCharacters.size() == 1 && lastCharacters.size() == 1) {
            List<Integer> firstIndexes = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].substring(0, 1).equalsIgnoreCase(firstCharacters.get(0))) {
                    firstIndexes.add(i);
                }
            }
            List<String> resultList = new ArrayList<>();
            for (int index : firstIndexes) {
                String[] wordsCut = new String[words.length - 1];
                for (int i = 0; i < wordsCut.length; i++) {
                    if (i < index)
                        wordsCut[i] = words[i];
                    else
                        wordsCut[i] = words[i + 1];
                }
                StringBuilder resultPrev = getLine(wordsCut);
                if (resultPrev == null) {
                    continue;
                }
                String[] lines = resultPrev.toString().split("\nили\n");
                for (String line : lines) {
                    if (words[index].substring(words[index].length() - 1)
                            .equalsIgnoreCase(line.substring(0, 1))) {
                        StringBuilder newLine = new StringBuilder(words[index]);
                        newLine.append(" ");
                        newLine.append(line);
                        if (resultList.contains(newLine.toString())) {
                            continue;
                        }
                        resultList.add(newLine.toString());
                    }
                }
            }
            if (resultList.size() > 0) {
                for (String line : resultList) {
                    if (result.length() > 0)
                        result.append("\nили\n");
                    result.append(line);
                }
                return result;
            }
            else
                return null;
        } else if (firstCharacters.size() == 0 && lastCharacters.size() == 0) {
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String[] wordsCut = new String[words.length - 1];
                for (int j = 0; j < wordsCut.length; j++) {
                    if (j < i)
                        wordsCut[j] = words[j];
                    else
                        wordsCut[j] = words[j + 1];
                }
                StringBuilder resultPrev = getLine(wordsCut);
                if (resultPrev == null) {
                    continue;
                }
                String[] lines = resultPrev.toString().split("\nили\n");
                for (String line : lines) {
                    if (words[i].substring(words[i].length() - 1)
                            .equalsIgnoreCase(line.substring(0, 1))) {
                        StringBuilder newLine = new StringBuilder(words[i]);
                        newLine.append(" ");
                        newLine.append(line);
                        if (resultList.contains(newLine.toString())) {
                            continue;
                        }
                        resultList.add(newLine.toString());
                    }
                }
            }
            if (resultList.size() > 0) {
                for (String line : resultList) {
                    if (result.length() > 0)
                        result.append("\nили\n");
                    result.append(line);
                }
                return result;
            }
            else
                return null;
        } else
            return null;
    }
}
