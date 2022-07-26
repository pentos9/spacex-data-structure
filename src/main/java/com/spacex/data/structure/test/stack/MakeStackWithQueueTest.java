package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.queue.BufferedStack;
import com.spacex.data.structure.stack.queue.IStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MakeStackWithQueueTest {

    @Test
    public void test() {
        IStack<String> stack = new BufferedStack<>();

        int total = ThreadLocalRandom.current().nextInt(10, 100);
        for (int i = 0; i < total; i++) {
            stack.push(String.valueOf(i));
        }

        Assertions.assertEquals(total, stack.size());

        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }

        Assertions.assertEquals(0, stack.size());

        int count = ThreadLocalRandom.current().nextInt(10, 100);
        for (int i = 0; i < count; i++) {
            Assertions.assertNull(stack.pop());
        }
    }
}
