package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.stack.FastBufferedQueue;
import com.spacex.data.structure.queue.stack.IQueue;
import com.spacex.data.structure.queue.stack.BufferedQueue;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MakeQueueWithStackTest {

    @Test
    public void test() {
        IQueue<String> queue = new BufferedQueue<>();
        int total = 10;
        for (int i = 0; i < total; i++) {
            queue.enQueue(String.valueOf(i));
        }

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.println(queue.deQueue());
        }
    }

    @Test
    public void test2() {
        IQueue<String> queue = new FastBufferedQueue<>();
        int total = ThreadLocalRandom.current().nextInt(0, 100);
        for (int i = 0; i < total; i++) {
            queue.enQueue(String.valueOf(i));
        }

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.println(queue.deQueue());
        }
    }
}
