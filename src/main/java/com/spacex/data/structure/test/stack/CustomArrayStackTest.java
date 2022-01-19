package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.ArrayCustomStack;
import com.spacex.data.structure.stack.exception.StackOverFlowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CustomArrayStackTest extends AbstractCustomStackTest {

    @BeforeEach
    @Override
    public void init() {
        this.stack = new ArrayCustomStack<>();
    }

    @Test
    @Override
    public void testPushBoundary() {
        int total = ThreadLocalRandom.current().nextInt(500, 1000);
        Assertions.assertThrowsExactly(StackOverFlowException.class, () -> {
            for (int i = 0; i < total; i++) {
                String uuid = UUID.randomUUID().toString();
                stack.push(uuid);
            }
        });
    }
}
