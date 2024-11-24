package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()))) {
            List<String> lines1 = new ArrayList<>();
            List<String> lines2 = new ArrayList<>();

            while (fileReader1.ready()) {
                lines1.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                lines2.add(fileReader2.readLine());
            }

            int k = 0;
            for (int i = 0; i < lines1.size(); i++) {
                if (k == lines2.size()) {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                }
                for (int j = k; j < lines2.size(); j++) {
                    if (lines1.get(i).equals(lines2.get(j))) {
                        lines.add(new LineItem(Type.SAME, lines1.get(i)));
                        k++;
                        break;
                    } else if (lines1.size() > (i + 1) && lines1.get(i + 1).equals(lines2.get(j))) {
                        lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                        break;
                    } else if (lines2.size() > (j + 1) && lines1.get(i).equals(lines2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                        k++;
                    }
                }
            }
            for (int i = k; i < lines2.size(); i++) {
                lines.add(new LineItem(Type.ADDED, lines2.get(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
