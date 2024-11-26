package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("file");
        fileConsoleWriter.write("0123456789", 1, 5);
        fileConsoleWriter.close();
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.print(String.copyValueOf(cbuf));
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.print((char) c);
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.print(str);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        if (len > cbuf.length) {
            len = cbuf.length;
        }
        System.out.print(String.copyValueOf(cbuf, off, len));
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }
}
