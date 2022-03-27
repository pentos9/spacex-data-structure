package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.MinHeap;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MinHeapTest {

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
}
