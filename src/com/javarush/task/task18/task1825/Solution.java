package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<String> fileNames = new TreeSet<>(new FileNameComparator());
            String fileName;
            while (!(fileName = reader.readLine()).equals("end")) {
                fileNames.add(fileName);
            }
            mergeFiles(fileNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mergeFiles(Set<String> fileNames) {
        if (fileNames == null || fileNames.isEmpty()) {
            return;
        }
        String fileOutputName = fileNames.iterator().next();
        fileOutputName = fileOutputName.substring(0, fileOutputName.lastIndexOf("."));
        try (FileOutputStream fos = new FileOutputStream(fileOutputName)) {
            for (String fileName : fileNames) {
                try (FileInputStream fis = new FileInputStream(fileName)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    fos.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class FileNameComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            }
            return s1.compareTo(s2);
        }
    }
}
