package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.MinHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MinHeapTest {

    private MinHeap<Integer> heap;

    @BeforeEach
    public void init() {
        this.heap = new MinHeap<>(Integer.class);
    }

    @Test
    public void test() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }

        heap.printPreOrder();

        heap.clear();

        System.out.println("=======");
        for (int i = 0; i < 10; i++) {
            heap.insert(ThreadLocalRandom.current().nextInt(100));
        }

        heap.printPreOrder();

        System.out.println(heap.min());
    }

    @Test
    public void testSample() {
        System.out.println((0 - 1) / 2);
    }

    @Test
    public void testSize() {
        Assertions.assertNotNull(heap);
        Assertions.assertTrue(heap.isEmpty());
        Assertions.assertTrue(heap.size() == 0);

        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            heap.insert(i);
        }

        Assertions.assertTrue(heap.size() == total);
    }

    @Test
    public void testEmpty() {
        Assertions.assertTrue(heap.isEmpty());
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            heap.insert(i);
        }

        Assertions.assertFalse(heap.isEmpty());

        heap.clear();
        Assertions.assertTrue(heap.isEmpty());
    }

    @Test
    public void testInsert() {
        int total = ThreadLocalRandom.current().nextInt(100);
        heap.clear();
        for (int i = 0; i < total; i++) {
            heap.insert(i);
        }

        Assertions.assertFalse(heap.isEmpty());
        Assertions.assertTrue(heap.size() == total);
    }

    @Test
    public void testGetParent() {
        int total = ThreadLocalRandom.current().nextInt(100);
        heap.clear();
        for (int i = 0; i < total; i++) {
            heap.insert(i);
        }

        for (int i = 0; i < heap.size(); i++) {
            heap.getParent(i);
        }

        for (int i = 0; i < heap.size(); i++) {
            heap.getParentElement(i);
        }

        for (int i = 0; i < heap.size(); i++) {
            heap.getElement(i);
        }
    }

    @Test
    public void testRemove() {

    }

    @Test
    public void testIndexOf() {

    }
}
