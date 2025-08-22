package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            BotClient.this.sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] messageArray = message.split(": ");
            if (messageArray.length != 2)
                return;
            String name = messageArray[0];
            String text = messageArray[1];
            String dateFormatPattern;
            switch(text) {
                case "дата":
                    dateFormatPattern = "d.MM.YYYY";
                    break;
                case "день":
                    dateFormatPattern = "d";
                    break;
                case "месяц":
                    dateFormatPattern = "MMMM";
                    break;
                case "год":
                    dateFormatPattern = "YYYY";
                    break;
                case "время":
                    dateFormatPattern = "H:mm:ss";
                    break;
                case "час":
                    dateFormatPattern = "H";
                    break;
                case "минуты":
                    dateFormatPattern = "m";
                    break;
                case "секунды":
                    dateFormatPattern = "s";
                    break;
                default:
                    return;
            }
            Date currentDate = Calendar.getInstance().getTime();
            String outputString = String.format("Информация для %s: %s", name, new SimpleDateFormat(dateFormatPattern).format(currentDate));
            BotClient.this.sendTextMessage(outputString);
        }
    }
}
