package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null)
            return false;
        if (telNumber.matches("^\\+\\d{12}"))
            return true;
        if (telNumber.matches("^\\+\\d\\(\\d{3}\\)\\d{8}"))
            return true;
        if (telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}"))
            return true;
        if (telNumber.matches("^\\+\\d{3}\\(\\d{3}\\)\\d{6}"))
            return true;
        if (telNumber.matches("^\\+\\d{4}\\(\\d{3}\\)\\d{5}"))
            return true;
        if (telNumber.matches("^\\+\\d{5}\\(\\d{3}\\)\\d{4}"))
            return true;
        if (telNumber.matches("^\\+\\d{6}\\(\\d{3}\\)\\d{3}"))
            return true;
        if (telNumber.matches("^\\+\\d{7}\\(\\d{3}\\)\\d{2}"))
            return true;
        if (telNumber.matches("^\\+\\d{8}\\(\\d{3}\\)\\d"))
            return true;
        if (telNumber.matches("^\\d\\d{9}"))
            return true;
        if (telNumber.matches("^\\(\\d{3}\\)\\d{7}"))
            return true;
        if (telNumber.matches("^\\d\\(\\d{3}\\)\\d{6}"))
            return true;
        if (telNumber.matches("^\\d{2}\\(\\d{3}\\)\\d{5}"))
            return true;
        if (telNumber.matches("^\\d{3}\\(\\d{3}\\)\\d{4}"))
            return true;
        if (telNumber.matches("^\\d{4}\\(\\d{3}\\)\\d{3}"))
            return true;
        if (telNumber.matches("^\\d{5}\\(\\d{3}\\)\\d{2}"))
            return true;
        if (telNumber.matches("^\\d{6}\\(\\d{3}\\)\\d"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.println(checkTelNumber("0(501)234567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)123-45-67"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }
}
