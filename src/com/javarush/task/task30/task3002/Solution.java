package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        byte numberSystem = 10;
        String number = s;
        if (s.startsWith("0x")) {
            numberSystem = 16;
            number = s.substring(2);
        } else if (s.startsWith("0b")) {
            numberSystem = 2;
            number = s.substring(2);
        } else if (s.startsWith("0")) {
            numberSystem = 8;
            number = s.substring(1);
        }
        return "" + Integer.parseInt(number, numberSystem);
    }
}
