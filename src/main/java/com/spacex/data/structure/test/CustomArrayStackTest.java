package com.spacex.data.structure.test;

import com.spacex.data.structure.stack.ArrayCustomStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CustomArrayStackTest {
    private ArrayCustomStack<String> stack;

    @BeforeEach
    public void init() {
        stack = new ArrayCustomStack<>();
    }

    @Test
    public void testSize() {
        Assertions.assertTrue(stack.size() == 0);

        final int maxSize = 65;
        int total = ThreadLocalRandom.current().nextInt(maxSize);//the bound (exclusive)
        for (int i = 0; i < total; i++) {
            stack.push(UUID.randomUUID().toString());
        }

        Assertions.assertTrue(stack.size() == total);

        System.out.println("total:" + total);
        for (String item : stack) {
            System.out.println(item);
        }
    }
}
