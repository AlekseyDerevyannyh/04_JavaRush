package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {

    public Solution(Path startPath) {
        this.startPath = startPath;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите путь к директории: ");
            Path path = Paths.get(reader.readLine());
            if (!Files.isDirectory(path)) {
                System.out.println(path + " - не папка");
                return;
            }
            Solution solution = new Solution(path);

            Files.walkFileTree(path, solution);
            System.out.println("Всего папок - " + solution.getTotalDirsCount());
            System.out.println("Всего файлов - " + solution.getTotalFilesCount());
            System.out.println("Общий размер - " + solution.getTotalSize());
        }
    }

    private Path startPath;
    private AtomicInteger totalFilesCount = new AtomicInteger(0);
    private AtomicInteger totalDirsCount = new AtomicInteger(0);
    private AtomicLong totalSize = new AtomicLong(0);

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        totalFilesCount.addAndGet(1);
        totalSize.addAndGet(Files.size(file));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (!dir.equals(startPath)) {
            totalDirsCount.addAndGet(1);
        }
        return FileVisitResult.CONTINUE;
    }

    public AtomicInteger getTotalFilesCount() {
        return totalFilesCount;
    }

    public AtomicInteger getTotalDirsCount() {
        return totalDirsCount;
    }

    public AtomicLong getTotalSize() {
        return totalSize;
    }
}
