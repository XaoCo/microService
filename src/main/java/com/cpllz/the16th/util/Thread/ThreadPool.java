package com.cpllz.the16th.util.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther CPP
 * @date 2020/8/18 17:37
 */
public class ThreadPool {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
}
