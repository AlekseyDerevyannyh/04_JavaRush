package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int value1, int value2) {
        return value1 < value2 ? value1: value2;
    }

    public static int min(int value1, int value2, int value3) {
        return min(min(value1, value2), value3);
    }

    public static int min(int value1, int value2, int value3, int value4) {
        return min(min(value1, value2, value3), value4);
    }

    public static int min(int value1, int value2, int value3, int value4, int value5) {
        return min(min(value1, value2, value3, value4), value5);
    }

    public static int max(int value1, int value2) {
        return value1 > value2 ? value1: value2;
    }

    public static int max(int value1, int value2, int value3) {
        return max(max(value1, value2), value3);
    }

    public static int max(int value1, int value2, int value3, int value4) {
        return max(max(value1, value2, value3), value4);
    }

    public static int max(int value1, int value2, int value3, int value4, int value5) {
        return max(max(value1, value2, value3, value4), value5);
    }
}
