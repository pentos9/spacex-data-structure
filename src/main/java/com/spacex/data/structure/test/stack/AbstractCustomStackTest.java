package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.ArrayCustomStack;
import com.spacex.data.structure.stack.CustomStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractCustomStackTest {
    protected CustomStack<String> stack;

    private static final int MAX_SIZE = 64;

    @BeforeEach
    public abstract void init();

    @Test
    public void testNull() {
        System.out.println(stack);
        Assertions.assertTrue(stack != null);
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertTrue(stack.size() == 0);
        int total = ThreadLocalRandom.current().nextInt(MAX_SIZE + 1);
        for (int i = 0; i < total; i++) {
            stack.push(UUID.randomUUID().toString());
        }
        Assertions.assertTrue(stack.size() == total);

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

        System.out.println(stack);
        System.out.println(new ArrayCustomStack<>());
    }

    @Test
    public void testPush() {
        int total = ThreadLocalRandom.current().nextInt(MAX_SIZE + 1);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            stack.push(random);
            String top = stack.peek();
            Assertions.assertTrue(random.equals(top));
        }

        Assertions.assertTrue(stack.size() == total);
    }

    @Test
    public void testPushBoundary() {
        int total = ThreadLocalRandom.current().nextInt(500, 1000);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            stack.push(uuid);
            String top = stack.peek();
            Assertions.assertFalse(!uuid.equals(top));
        }
    }

    @Test
    public void testPop() {
        int total = ThreadLocalRandom.current().nextInt(MAX_SIZE + 1);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            stack.push(uuid);
            int oldSize = stack.size();
            String top = stack.pop();
            Assertions.assertTrue(uuid.equals(top));
            Assertions.assertTrue(stack.size() == (oldSize - 1));
        }

        for (int i = 0; i < total; i++) {
            stack.pop();
        }

        Assertions.assertTrue(stack.size() == 0);
        Assertions.assertTrue(stack.isEmpty());

        for (int i = 0; i < 200; i++) {
            stack.pop();
        }
    }

    private int initStack() {
        int total = ThreadLocalRandom.current().nextInt(MAX_SIZE + 1);
        for (int i = 0; i < total; i++) {
            stack.push(UUID.randomUUID().toString());
        }
        return total;
    }

    @Test
    public void testPeek() {
        int total = initStack();
        for (int i = 0; i < total; i++) {
            String top = stack.peek();
            System.out.print(top + "\t");
        }
    }

    @Test
    public void testSearch() {
        int total = initStack();
        for (int i = 0; i < total; i++) {
            String top = stack.peek();
            int index = stack.search(top);
            Assertions.assertTrue(index != -1);
            Assertions.assertTrue(index == (stack.size() - 1));
            stack.pop();
        }
    }

    @Test
    public void testForEach() {
        initStack();
        for (String uuid : stack) {
            System.out.print(uuid + "\t");
        }
    }
}
