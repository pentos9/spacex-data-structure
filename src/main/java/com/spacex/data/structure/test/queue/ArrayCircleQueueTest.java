package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.circular.ArrayCircleQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ArrayCircleQueueTest {

    private ArrayCircleQueue<String> produce(int maxSize) {
        ArrayCircleQueue<String> queue = new ArrayCircleQueue<>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            String uuid = UUID.randomUUID().toString();
            queue.enQueue(uuid);
        }
        return queue;
    }

    @Test
    public void test() {
        int maxSize = 100;
        ArrayCircleQueue<String> queue = produce(maxSize);
        Assertions.assertEquals(maxSize - 1, queue.size());
    }

    @Test
    public void testDequeue() {
        int maxSize = 100;
        ArrayCircleQueue<String> queue = produce(maxSize);
        for (; !queue.isEmpty(); ) {
            queue.deQueue();
        }
        Assertions.assertTrue(queue.isEmpty());
    }
}
