package com.javarush.task.pro.task12.task1206;

/* 
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int result = 0;
        for (char symbol : string.toCharArray()) {
            if (Character.isDigit(symbol))
                result ++;
        }
        return result;
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int result = 0;
        for (char symbol : string.toCharArray()) {
            if (Character.isLetter(symbol))
                result ++;
        }
        return result;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int result = 0;
        for (char symbol : string.toCharArray()) {
            if (Character.isSpaceChar(symbol))
                result ++;
        }
        return result;
    }
}
