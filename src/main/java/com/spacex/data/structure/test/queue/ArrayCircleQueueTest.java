package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.circular.ArrayCircleQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ArrayCircleQueueTest {

    @Test
    public void test() {
        int maxSize = 100;
        ArrayCircleQueue<String> queue = new ArrayCircleQueue<>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            String uuid = UUID.randomUUID().toString();
            queue.enQueue(uuid);
        }

        Assertions.assertEquals(maxSize - 1, queue.size());
    }
}
