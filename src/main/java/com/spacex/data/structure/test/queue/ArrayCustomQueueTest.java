package com.spacex.data.structure.test.queue;

import com.spacex.data.structure.queue.ArrayCustomQueue;
import org.junit.jupiter.api.BeforeEach;

public class ArrayCustomQueueTest extends AbstractCustomQueueTest {

    @BeforeEach
    @Override
    protected void init() {
        this.customQueue = new ArrayCustomQueue(100);
    }
}
