package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length < 2) {
            return;
        }
        if (args[0] == null || args[0].isEmpty()) {
            return;
        }
        String outFileName = args[0];
        List<String> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            files.add(args[i]);
        }
        Collections.sort(files);

        List<FileInputStream> fisList = new ArrayList<>();
        for (String file : files) {
            fisList.add(new FileInputStream(file));
        }
        try (SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(fisList));
             ZipInputStream zis = new ZipInputStream(sis);
             FileOutputStream fos = new FileOutputStream(outFileName)) {

            ZipEntry entry = zis.getNextEntry();
            if (entry != null) { // Обычно в задаче внутри один целевой файл
                byte[] buffer = new byte[8 * 1024];
                int bytesRead;
                while ((bytesRead = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                zis.closeEntry();
            }
        }
    }
}
