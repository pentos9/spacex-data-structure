package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.JdkArrayListCustomStack;
import org.junit.jupiter.api.BeforeEach;

public class JdkArrayListCustomStackTest extends AbstractCustomStackTest {

    @BeforeEach
    @Override
    public void init() {
        this.stack = new JdkArrayListCustomStack<>();
    }
}
