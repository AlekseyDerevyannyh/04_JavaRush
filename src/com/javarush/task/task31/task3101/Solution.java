package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    static void main(String[] args) throws IOException {
        if (args == null || args.length < 2) {
            System.out.println("Input args error!");
            return;
        }
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File sourceFile = new File(resultFileAbsolutePath);
        File destinationFile = new File(sourceFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(sourceFile, destinationFile);

        File sourceDir = new File(path);

        Set<File> files = new HashSet<>();
        getAllTxtFilesInSubfolders(sourceDir, files);
        if (files.isEmpty()) {
            return;
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(destinationFile, true)) {
            for (File file : files) {
                if (!file.getAbsolutePath().equals(destinationFile.getAbsolutePath())) {
                    byte[] bytes = Files.readAllBytes(file.toPath());
                    for (byte inputByte : bytes) {
                        fileOutputStream.write(inputByte);
                    }
                    fileOutputStream.write("\n".getBytes());
                }
            }
        }
    }

    private static void getAllTxtFilesInSubfolders(File sourceDir, Set<File> files) {
        File[] currentFiles = sourceDir.listFiles();
        if (currentFiles == null) {
            return;
        }
        for (File file : currentFiles) {
            if (file.isDirectory()) {
                getAllTxtFilesInSubfolders(file, files);
            }
            if (file.isFile() && file.getName().endsWith(".txt") && file.length() <= 50L) {
                files.add(file);
            }
        }
    }
}
