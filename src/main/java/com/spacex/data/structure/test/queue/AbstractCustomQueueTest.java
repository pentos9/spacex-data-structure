package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.CustomQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractCustomQueueTest {

    protected CustomQueue<String> customQueue;

    protected abstract void init();

    @Test
    public void testSize() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customQueue.enQueue(UUID.randomUUID().toString());
        }

        Assertions.assertTrue(customQueue.size() == total);
    }

    @Test
    public void testEmpty() {
        Assertions.assertTrue(customQueue.isEmpty());
        Assertions.assertTrue(customQueue.size() == 0);
    }

    @Test
    public void testFull() {
        int total = ThreadLocalRandom.current().nextInt(200, 300);
        Assertions.assertFalse(customQueue.isFull());
        for (int i = 0; i < total; i++) {
            customQueue.enQueue(UUID.randomUUID().toString());
        }
        Assertions.assertTrue(customQueue.isFull());
    }

    @Test
    public void testEnQueue() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customQueue.enQueue(UUID.randomUUID().toString());
        }

        Assertions.assertFalse(customQueue.isEmpty());
        Assertions.assertTrue(customQueue.size() == total);
    }

    @Test
    public void testDeQueue() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            String item = UUID.randomUUID().toString();
            customQueue.enQueue(item);
        }

        System.out.println();
        for (int i = 0; i < total; i++) {
            String item = customQueue.deQueue();
        }
    }

    @Test
    public void testEmptyQueue() {
        Assertions.assertTrue(customQueue.isEmpty());
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            customQueue.deQueue();
        });
    }

    @Test
    public void testPeek() {
        int total = ThreadLocalRandom.current().nextInt(100);
        String uuid = null;
        for (int i = 0; i < total; i++) {
            if (i == 0) {
                uuid = UUID.randomUUID().toString();
                customQueue.enQueue(uuid);
                continue;
            }
            customQueue.enQueue(UUID.randomUUID().toString());
        }
        Assertions.assertTrue(uuid.equals(customQueue.peek()));
    }

    @Test
    public void testForEach() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customQueue.enQueue(UUID.randomUUID().toString());
        }

        for (String item : customQueue) {
            System.out.println(item);
        }
    }
}
