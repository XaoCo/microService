package com.cpllz.the16th.util.Thread;

/**
 * @auther CPP
 * @date 2020/8/18 18:43
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {


                }
                System.out.println("t2");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {


                }
                System.out.println("t3");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
