package com.spacex.data.structure.test.heap;

import com.spacex.data.structure.heap.MinHeap;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

    @Test
    public void test() {
        MinHeap<Integer> heap = new MinHeap<>();
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
    }
}
