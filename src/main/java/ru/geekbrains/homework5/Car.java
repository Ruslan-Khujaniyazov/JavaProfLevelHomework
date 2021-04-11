package ru.geekbrains.homework5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdl;
    private CountDownLatch cdl1;

    public static int getCarsCount() {
        return CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl, CountDownLatch cdl1) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
        this.cdl1 = cdl1;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cdl1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

    }

}
