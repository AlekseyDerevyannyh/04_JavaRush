package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty() || !binaryNumber.matches("^[0-1]+")) {
            return "";
        }
        final String HEX = "0123456789abcdef";
        final String[] BIN = {"0000", "0001", "0010", "0011", "0100", "0101",
                "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

        String result = "";
        int i = binaryNumber.length();
        while (i > 0) {
            String subresult = "";
            if (i > 3) {
                subresult = binaryNumber.substring(i - 4, i);
            } else if (i == 3) {
                subresult = "0" + binaryNumber.substring(0, i);
            } else if (i == 2) {
                subresult = "00" + binaryNumber.substring(0, i);
            } else {
                subresult = "000" + binaryNumber.substring(0, i);
            }
            for (int j = 0; j < BIN.length; j++) {
                if (subresult.equals(BIN[j])) {
                    result = HEX.charAt(j) + result;
                }
            }
            i -= 4;
        }
        return result;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.isEmpty() || !hexNumber.matches("^[A-Fa-f0-9]+")) {
            return "";
        }
        final String HEX = "0123456789abcdef";
        final String[] BIN = {"0000", "0001", "0010", "0011", "0100", "0101",
                "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String result = "";

        for (int i = 0; i < hexNumber.length(); i++) {
            for (int j = 0; j < HEX.length(); j++) {
                if (hexNumber.charAt(i) == HEX.charAt(j)) {
                    result += BIN[j];
                }
            }
        }
        return result;
    }
}
