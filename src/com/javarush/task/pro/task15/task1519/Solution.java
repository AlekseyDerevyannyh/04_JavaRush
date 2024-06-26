package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(sourceDirectory)) {
            for (Path path : paths) {
                if (Files.isRegularFile(path)) {
                    Path sourcePath = path.toAbsolutePath();
                    Path targetPath = targetDirectory.toAbsolutePath().resolve(path.getFileName());
                    Files.copy(sourcePath, targetPath);
                }
            }
        }
    }
}
