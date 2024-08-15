package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.5, "полтора");
        labels.put(2.5, "два с половиной");
        labels.put(3.5, "три с половиной");
        labels.put(4.5, "четыре с половиной");
        labels.put(5.5, "пять с половиной");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
