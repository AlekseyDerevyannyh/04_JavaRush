package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Введите путь файла для удаления из архива:");
        Path removeFile = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(removeFile);
    }
}
