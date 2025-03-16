package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> example = new LinkedHashMap<>();
        example.put("name", "Ivanov");
        example.put("country", "Ukraine");
        example.put("city", "Kiev");
        example.put("age", null);
        System.out.println(getQuery(example));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null)
            return result.toString();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                result.append(entry.getKey());
                result.append(" = '");
                result.append(entry.getValue());
                result.append("' and ");
            }
        }
        if (result.length() > 6)
            return result.substring(0, result.length() - 5);
        return result.toString();
    }
}
