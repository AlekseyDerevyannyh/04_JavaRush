package com.javarush.task.pro.task13.task1313;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        Node node = new Node();
        if (first.next == null || last.prev == null) {
            node.prev = first;
            node.next = last;
            node.value = value;
            first.next = node;
            last.prev = node;
        } else {
            node.prev = last.prev;
            last.prev.next = node;
            last.prev = node;
            node.next = last;
            node.value = value;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
