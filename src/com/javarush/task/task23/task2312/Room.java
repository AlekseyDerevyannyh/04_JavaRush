package com.javarush.task.task23.task2312;

public class Room {
    public static Room game;

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public static void main(String[] args) {
        Snake snake = new Snake(10, 10);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(20, 20, snake);
    }

    public void run() {}

    public void print() {}

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
