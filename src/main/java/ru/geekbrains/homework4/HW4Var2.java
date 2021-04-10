package ru.geekbrains.homework4;

public class HW4Var2 {
    private static Object monitor = new Object();
    private static volatile char currentChar = 'A';
    private static final int MAX_ITERATIONS = 5;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try {
                synchronized (monitor) {
                    for (int i = 0; i < MAX_ITERATIONS; i++) {
                        while (currentChar != 'A') {

                            monitor.wait();
                        }

                        System.out.print("A");
                        currentChar = 'B';
                        monitor.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.start();


        Thread t2 = new Thread(() -> {
            try {
                synchronized (monitor) {
                    for (int i = 0; i < MAX_ITERATIONS; i++) {
                        while (currentChar != 'B') {

                            monitor.wait();
                        }

                        System.out.print("B");
                        currentChar = 'C';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.start();


        Thread t3 = new Thread(() -> {

            try {
                synchronized (monitor) {
                    for (int i = 0; i < MAX_ITERATIONS; i++) {
                        while (currentChar != 'C') {

                            monitor.wait();
                        }

                        System.out.print("C");
                        currentChar = 'A';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t3.start();


    }
}
