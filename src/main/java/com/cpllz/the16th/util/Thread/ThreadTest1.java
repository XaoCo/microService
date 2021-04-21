package com.cpllz.the16th.util.Thread;

/**
 * @auther CPP
 * @date 2020/8/18 17:29
 */
public class ThreadTest1 extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadTest1.run");
    }

    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.start();
    }
}
