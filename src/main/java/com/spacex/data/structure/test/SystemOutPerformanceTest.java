package com.spacex.data.structure.test;

public class SystemOutPerformanceTest {
    public static void main(String[] args) {
        long loopTimes = 100000;
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < loopTimes; i++) {
            System.out.println("i:" + i);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < loopTimes; i++) {

        }
        long end2 = System.currentTimeMillis();

        System.out.println("with-system-out:" + (end1 - start1));
        System.out.println("no-system-out:" + (end2 - start2));
    }
}
