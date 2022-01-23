package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.SingleLinkedListCustomQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class SingleLinkedListCustomQueueTest extends AbstractCustomQueueTest {

    @BeforeEach
    @Override
    protected void init() {
        this.customQueue = new SingleLinkedListCustomQueue<>();
    }

    @Test
    @Override
    public void testFull() {
        Assertions.assertTrue(customQueue.isEmpty());
        int total = ThreadLocalRandom.current().nextInt(100, 200);
        for (int i = 0; i < total; i++) {
            customQueue.enQueue(UUID.randomUUID().toString());
        }
        Assertions.assertFalse(customQueue.isEmpty());
    }
}
