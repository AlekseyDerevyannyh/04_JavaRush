package com.javarush.task.pro.task15.task1506;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> reader = Files.readAllLines(Path.of(scanner.nextLine()));
            for (String line : reader) {
                for (char symbol : line.toCharArray()) {
                    if (symbol != '.' && symbol != ',' && symbol !=' ') {
                        System.out.print(symbol);
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
    }
}
