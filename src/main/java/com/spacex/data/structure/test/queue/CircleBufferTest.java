package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.circular.CircleBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CircleBufferTest {

    private CircleBuffer<String> circleBuffer;

    @BeforeEach
    public void init() {
        int capacity = ThreadLocalRandom.current().nextInt(0, 1000);
        this.circleBuffer = new CircleBuffer<>(Math.abs(capacity));
    }

    @Test
    public void test() {
        int capacity = circleBuffer.capacity();
        for (int i = 0; i < capacity; i++) {
            String uuid = UUID.randomUUID().toString();
            circleBuffer.offer(uuid);
        }

        Assertions.assertEquals(capacity, circleBuffer.size());
    }
}
