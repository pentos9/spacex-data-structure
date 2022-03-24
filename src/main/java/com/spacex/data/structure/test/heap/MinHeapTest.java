package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.MinHeap;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

    @Test
    public void test() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
    }

    @Test
    public void test2() {
        System.out.println((0 - 1) / 2);
    }
}
