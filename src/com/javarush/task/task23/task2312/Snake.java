package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public void move() {
        if (!isAlive)                                       return;
        if (direction.equals(SnakeDirection.UP))            move(0, -1);
        else if (direction.equals(SnakeDirection.RIGHT))    move(1, 0);
        else if (direction.equals(SnakeDirection.DOWN))     move(0, 1);
        else if (direction.equals(SnakeDirection.LEFT))     move(-1, 0);
    }
    
    public void move(int x, int y) {

    }

    public void checkBorders(SnakeSection head) {
        if (!((head.getX() >= 0 && head.getX() < Room.game.getWidth())
                && (head.getY() >=0 && head.getY() < Room.game.getHeight())))
            isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head))
            isAlive = false;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public List<SnakeSection> getSections() {
        return this.sections;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public SnakeDirection getDirection() {
        return this.direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
