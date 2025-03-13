package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();
        int firstSpaceIndex = string.indexOf(' ');
        if (firstSpaceIndex == -1)
            throw new TooShortStringException();
        int fourthSpaceIndex = firstSpaceIndex;
        for (int i = 0; i < 3; i++) {
            int spaceIndex = string.indexOf(' ', fourthSpaceIndex + 1);
            if (spaceIndex == -1)
                throw new TooShortStringException();
            fourthSpaceIndex = spaceIndex;
        }
        int fifthSpaceIndex = string.indexOf(' ', fourthSpaceIndex + 1);
        if (fifthSpaceIndex != -1)
            return string.substring(firstSpaceIndex + 1, fifthSpaceIndex);
        else
            return string.substring(firstSpaceIndex + 1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
