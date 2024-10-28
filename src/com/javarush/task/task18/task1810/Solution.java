package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FileInputStream fileInputStream;
            do {
                fileInputStream = new FileInputStream(reader.readLine());

            } while (fileInputStream.available() >= 1000);
            fileInputStream.close();
            throw new DownloadException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
