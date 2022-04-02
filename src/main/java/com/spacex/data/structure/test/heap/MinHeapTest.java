package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.MinHeap;
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
    public void test2() {
        System.out.println((0 - 1) / 2);
    }

    @Test
    public void testSize() {

    }

    @Test
    public void testEmpty() {

    }

    @Test
    public void testInsert() {

    }

    @Test
    public void testGetParent() {

    }

    @Test
    public void testRemove() {

    }

    @Test
    public void testIndexOf() {

    }
}
