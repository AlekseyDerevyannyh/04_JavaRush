package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String[] elements = outputStream.toString().split(" ");
        if (elements.length < 3) {
            return;
        }
        int a = Integer.parseInt(elements[0]);
        int b = Integer.parseInt(elements[2]);
        int result;
        char operation;
        switch (elements[1]) {
            case "+":
                result = a + b;
                operation = '+';
                break;
            case "-":
                result = a - b;
                operation = '-';
                break;
            case "*":
                result = a * b;
                operation = '*';
                break;
            default:
                return;
        }
        System.out.printf("%d %s %d = %d\n", a, operation, b, result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

