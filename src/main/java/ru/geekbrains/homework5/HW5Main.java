package ru.geekbrains.homework5;

import java.util.concurrent.CountDownLatch;

public class HW5Main {
    public static final int CARS_COUNT = 4;
    public static final int RACE_START_ANNOUNCEMENT = 1;

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdl1 = new CountDownLatch(RACE_START_ANNOUNCEMENT);

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНиЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl, cdl1);
        }

        for (int i = 0; i < cars.length; i++) {

            new Thread(cars[i]).start();
            //cdl.countDown();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНиЕ >>> Гонка началась!!!");
        cdl1.countDown();


        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНиЕ >>> Гонка закончилась!!!");

    }
}
