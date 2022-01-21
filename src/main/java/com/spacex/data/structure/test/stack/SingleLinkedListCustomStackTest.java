package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.SingleLinkedListCustomStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingleLinkedListCustomStackTest extends AbstractCustomStackTest {

    @BeforeEach
    @Override
    public void init() {
        this.stack = new SingleLinkedListCustomStack<>();
    }

    @Test
    @Override
    public void testSearch() {
        int total = initStack();
        for (int i = 0; i < total; i++) {
            String top = stack.peek();
            int index = stack.search(top);
            Assertions.assertTrue(index != -1);
            Assertions.assertTrue(index == 0);
            stack.pop();
        }
    }
}
