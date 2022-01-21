package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.JdkDequeCustomStack;
import org.junit.jupiter.api.BeforeEach;

public class JdkDequeCustomStackTest extends AbstractCustomStackTest {

    @BeforeEach
    @Override
    public void init() {
        this.stack = new JdkDequeCustomStack<>();
    }

    @Override
    public void testSearch() {
        //in this case,no need to test
    }
}
