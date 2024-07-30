package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.util.EmptyStackException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.NumberFormatException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.StringIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new java.lang.ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
