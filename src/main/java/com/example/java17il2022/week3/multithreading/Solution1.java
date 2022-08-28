package com.example.java17il2022.week3.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * T1 generate random number
 * T2 print after T1 finished
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        List<Integer> l = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            Random rand = new Random();
            for(int i = 0; i < 100; i++) {
                l.add(rand.nextInt(100));
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println(l);
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
    }
}
