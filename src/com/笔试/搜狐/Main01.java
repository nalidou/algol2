package com.笔试.搜狐;

public class Main01 {
    final static Object object = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            for (int i=1;i<=52;i+=2) {
                try {
                    synchronized (object) {
                        object.notify();
                        System.out.print(i);
                        System.out.print(i+1);
                        object.wait();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
            for(int i = 1;i<=26;i++){
                try {
                    synchronized (object) {
                        object.notify();
                        System.out.print(((char) (64 + i) )+ " ");
                        if (i != 26) {
                            object.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();
    }




}
