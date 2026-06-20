package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        if (args == null || args.length == 0 || args[0].isEmpty()) {
            System.out.println("incorrect");
            return;
        }

        String inputString = args[0];
        Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]+$");
        if (inputString.length() > 255 || !ALPHANUMERIC.matcher(inputString).matches()) {
            System.out.println("incorrect");
            return;
        }

        for (int i = 2; i <= 36; i++) {
            try {
                new BigInteger(inputString, i);
                System.out.println(i);
                return;
            } catch (NumberFormatException _) {
            }
        }
        System.out.println("incorrect");
    }
}