package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        if (decimalNumber <= 0) {
            return "";
        }
        String result = "";
        int i = 0;
        while (decimalNumber > 0) {
            result = decimalNumber % 2 + result;
            decimalNumber /= 2;
            i++;
        }
        return result;
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty()) {
            return 0;
        }
        int result = 0;
        int i = 0;
        while (i < binaryNumber.length()) {
            result += Character.getNumericValue(binaryNumber.charAt(binaryNumber.length() - 1 - i)) * (int) Math.pow(2, i);
            i++;
        }
        return result;
    }
}
