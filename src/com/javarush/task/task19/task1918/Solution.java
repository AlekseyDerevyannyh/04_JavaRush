package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        String tag;
        if (args.length < 1) {
            tag = "";
        } else {
            tag = args[0];
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine())) {
            StringBuffer stringBuffer = new StringBuffer();
            while (fileReader.ready()) {
                char symbol = (char) fileReader.read();
                if (symbol != '\n' && symbol != '\r') {
                    stringBuffer.append(symbol);
                }
            }
            splitTag(stringBuffer.toString(), tag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitTag(String input, String tag) {
        String startTag = "<" + tag;
        String endTag = "</" + tag + ">";

        Stack<Integer> startIndexes = new Stack<>();
        Map<Integer, Integer> indexPairs = new TreeMap<>();

        StringBuilder builder = new StringBuilder();
        int currentTagStart = 0;
        boolean readingTag = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '<') {
                readingTag = true;
                currentTagStart = i;
            }
            if (currentChar == '>') {
                readingTag = false;
                String tagString = builder.append(currentChar).toString();
                builder = new StringBuilder();

                if (tagString.startsWith(startTag)) {
                    startIndexes.push(currentTagStart);
                }

                if (tagString.equals(endTag)) {
                    Integer start = startIndexes.pop();
                    indexPairs.put(start, i + 1);
                }
            }
            if (readingTag) {
                builder.append(currentChar);
            }
        }

        indexPairs.forEach((key, value) -> System.out.println(input.substring(key, value)));
    }
}
