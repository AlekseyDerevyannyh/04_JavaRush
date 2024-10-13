package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("beach1", 8.0f, 4);
        Beach beach2 = new Beach("beach2", 9.0f, 5);
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach2.compareTo(beach1));
    }

    @Override
    public synchronized int compareTo(Beach beach) {
        if (this.getDistance() < beach.getDistance()) {
            if (this.getQuality() >= beach.getQuality()) {
                return 1;
            } else {
                return 0;
            }
        } else if (this.getDistance() > beach.getDistance()) {
            if (this.getQuality() <= beach.getQuality()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (this.getQuality() > beach.getQuality()) {
                return 1;
            } else if (this.getQuality() < beach.getQuality()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
