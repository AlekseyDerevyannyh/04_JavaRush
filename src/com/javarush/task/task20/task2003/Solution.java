package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
                writer.write(entry.getKey()
                        .replaceAll(" ", "\\\\ ")
                        .replaceAll(":", "\\\\:")
                        .replaceAll("=", "\\\\=") +
                        ":" + entry.getValue() + "\n");
            }
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            runtimeStorage.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);

        try (FileOutputStream fos = new FileOutputStream("file1")) {
            save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
