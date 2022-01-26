package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.ArrayCustomBlockingQueue;
import com.spacex.data.structure.queue.BlockingQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayCustomBlockingQueueTest extends AbstractCustomQueueTest {

    @BeforeEach
    @Override
    protected void init() {
        this.customQueue = new ArrayCustomBlockingQueue<>(100);
    }

    @Test
    @Override
    public void testEmptyQueue() {
        Runnable emptyTask = () -> {
            customQueue.deQueue();
        };

        Thread emptyTestWorker = new Thread(emptyTask);
        emptyTestWorker.start();

        Runnable fillTask = () -> {
            customQueue.enQueue(UUID.randomUUID().toString());
        };

        Thread fillTestWorker = new Thread(fillTask);
        fillTestWorker.start();
        try {
            emptyTestWorker.join();
            fillTestWorker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    @Override
    public void testFull() {

    }

    @Test
    public void simpleTest() {
        BlockingQueue<String> blockingQueue = new ArrayCustomBlockingQueue<>(100);
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            blockingQueue.enQueue(UUID.randomUUID().toString());
        }

        System.out.println(blockingQueue);
    }
}
