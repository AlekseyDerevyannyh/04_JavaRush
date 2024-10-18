package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String[] fileName = new String[2];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName[0] = reader.readLine();
            fileName[1] = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName[i]))) {
                while (reader.ready()) {
                    if (i == 0)
                        allLines.add(reader.readLine());
                    else
                        forRemoveLines.add(reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        System.out.println(allLines);
        System.out.println(forRemoveLines);
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
