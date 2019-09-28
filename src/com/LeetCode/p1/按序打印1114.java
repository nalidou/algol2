package com.LeetCode.p1;

public class 按序打印1114 {
    public static void main(String[] args) {
        Thread one = new Thread(new One());
        Thread tow = new Thread(new Tow());
        Thread three = new Thread(new Three());

        one.start();
        tow.start();
        three.start();

    }

    private static Object lock = new Object();
    private static volatile int cur = 1;
    public static class One implements Runnable {

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                synchronized (lock){
                    if (cur == 1) {
                        System.out.println("one");
                        cur++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            }

        }
    }

    public static class Tow implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                synchronized (lock){
                    if (cur == 2) {
                        System.out.println("tow");
                        cur++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    public static class Three implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                synchronized (lock){
                    if (cur == 3) {
                        System.out.println("three");
                        cur = 1;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }
}
