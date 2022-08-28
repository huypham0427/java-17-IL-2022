package com.example.java17il2022.week3.multithreading;

import java.util.Random;

public class Solution2 {
    public static void main(String[] args) throws Exception{
        RandomUtil randomUtil = new RandomUtil();
        Thread t1 = new Thread(() -> {
            for(int i = 1; i < 100; i++) {
                randomUtil.nextRandom(i);
            }
            randomUtil.stop();
        });
        Thread t2 = new Thread(() -> randomUtil.print());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class RandomUtil {
    private int num;
    private boolean finished;
    private boolean canPrint;
    private final Random rand = new Random();

    public synchronized void nextRandom(int bound) {
        while(canPrint) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num = rand.nextInt(bound);
        canPrint = true;
        System.out.println("generated random num: " + num);
        notify();
    }

    public synchronized void print() {
        while(!finished) {
            while(!canPrint) {
                try {
                    wait();
                    /*
                    we need this part, because our T2 will continue our while loop before t1 set the finished to true.
                    And T2 may enter waiting stage before t1 changes finished flag.
                    If T2 is in waiting stage, we need to wake t2 up and tells t2 to stop.
                    That's why we need notify t2 in stop() function. and put if(finished) after wait();
                     */
                    if(finished) {
                        System.out.println("has finished" + finished);
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("printing random num: " + num);
            canPrint = false;
            notify();
        }
    }

    public synchronized void stop() {
        this.finished = true;
    }
}