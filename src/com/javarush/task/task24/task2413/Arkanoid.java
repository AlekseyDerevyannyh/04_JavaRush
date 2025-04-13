package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    public static Arkanoid game;
    private boolean isGameOver;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }

    public void run() {}

    public void move() {
        this.stand.move();
        this.ball.move();
    }

    public void draw(Canvas canvas) {
        this.ball.draw(canvas);
        this.stand.draw(canvas);
        for (Brick brick : this.bricks) {
            brick.draw(canvas);
        }
    }

    public void checkBricksBump() {
        for (Brick brick : this.bricks) {
            if (brick.intersects(this.ball)) {
                double angle = Math.random() * 360;
                this.ball.setDirection(angle);
                break;
            }
        }
        bricks.removeIf(b -> b.intersects(this.ball));
    }

    public void checkStandBump() {
        if (this.ball.intersects(this.stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            this.ball.setDirection(angle);
        }
    }

    public void checkEndGame() {
        if (this.ball.y > this.height) {
            isGameOver = true;
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Ball getBall() {
        return this.ball;
    }

    public Stand getStand() {
        return this.stand;
    }

    public List<Brick> getBricks() {
        return this.bricks;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
