package com.javarush.task.task25.task2503;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        Column[] columns = Column.values();
        int[] order = new int[realOrder.length];
        int emptyCount = 0;
        for (int i = 0; i < realOrder.length; i++) {
            if (realOrder[i] != -1) {
                order[realOrder[i]] = i;
            } else {
                order[order.length - 1 - emptyCount] = -1;
                emptyCount++;
            }
        }
        for (int orderIndex : order) {
            if (orderIndex != -1)
                result.add(columns[orderIndex]);
        }
        return result;
    }

    @Override
    public String getColumnName() {
        return this.columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder[this.ordinal()] != -1;
    }

    @Override
    public void hide() {
        int columnIndex = this.ordinal();
        for (int i = 0; i < realOrder.length; i++) {
            if (i == columnIndex) {
                for (int j = 0; j < realOrder.length; j++) {
                    if (j != i && realOrder[j] > realOrder[columnIndex]) {
                        realOrder[j]--;
                    }
                }
                realOrder[i] = -1;
                return;
            }
        }
    }
}
