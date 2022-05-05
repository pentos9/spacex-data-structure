package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.SimpleHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleHeapTest {

    private static final int CAPACITY = 128;
    private SimpleHeap simpleHeap;

    @BeforeEach
    public void init() {
        simpleHeap = new SimpleHeap(CAPACITY);
    }

    @Test
    public void testSize() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }

        Assertions.assertTrue(simpleHeap.size() == total);
    }

    @Test
    public void testFindMax() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }

        Assertions.assertNotNull(simpleHeap.findMax());
    }

    @Test
    public void testIsLeaf() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }
        Assertions.assertNotNull(simpleHeap.size() == total);
        Assertions.assertFalse(simpleHeap.isLeaf(0));
    }


    @Test
    public void testEmptyAndFull() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }
        Assertions.assertFalse(simpleHeap.isEmpty());
        Assertions.assertFalse(simpleHeap.isFull());
    }

    @Test
    public void testEmpty() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }

        Assertions.assertFalse(simpleHeap.isEmpty());

        for (int i = 0; i < this.simpleHeap.size(); i++) {
            simpleHeap.delete(i);
        }
        Assertions.assertTrue(simpleHeap.isEmpty());
    }

    @Test
    public void testPrintHeap() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }
        simpleHeap.printHeap();
    }

    @Test
    public void testSimpleInsert() {
        int total = ThreadLocalRandom.current().nextInt(CAPACITY);
        for (int i = 0; i < total; i++) {
            simpleHeap.insert(i);
        }
        Assertions.assertTrue(simpleHeap.size() == total);
    }
}
