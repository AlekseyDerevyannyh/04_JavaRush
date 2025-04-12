package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    public void start() {
        this.isFrozen = false;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(this.x, this.y, 'O');
    }

    @Override
    public void move() {
        if (!this.isFrozen) {
            this.x += this.dx;
            this.y += this.dy;
        }
    }

    public void checkRebound(int minx, int maxx, int miny, int maxy) {}

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        this.dx = Math.cos(angle) * this.speed;
        this.dy = -Math.sin(angle) * this.speed;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
