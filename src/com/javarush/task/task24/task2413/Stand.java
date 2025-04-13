package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        this.speed = 1;
        this.direction = 0;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        this.x += this.speed * this.direction;
    }

    public void moveLeft() {
        this.direction = -1.0;
    }

    public void moveRight() {
        this.direction = 1.0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
