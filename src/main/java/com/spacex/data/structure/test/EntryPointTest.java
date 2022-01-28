package com.spacex.data.structure.test;

import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.locks.LockSupport;

public class EntryPointTest {
    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        Vector vector = new Vector();
        vector.add(UUID.randomUUID().toString());
        java.util.concurrent.locks.LockSupport lockSupport;
        System.out.println(Integer.valueOf(1).compareTo(Integer.valueOf(2)));
    }
}
