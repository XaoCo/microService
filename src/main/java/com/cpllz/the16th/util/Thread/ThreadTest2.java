package com.cpllz.the16th.util.Thread;

/**
 * @auther CPP
 * @date 2020/8/18 17:33
 */
public class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadTest2.run");

    }

    public static void main(String[] args) {
        ThreadTest2 threadTest2 = new ThreadTest2();
        Thread thread = new Thread(threadTest2);
        thread.start();
    }
}
