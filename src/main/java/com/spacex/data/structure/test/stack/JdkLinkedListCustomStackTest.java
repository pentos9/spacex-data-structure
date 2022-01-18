package com.spacex.data.structure.test.stack;

import com.spacex.data.structure.stack.JdkLinkedListCustomStack;
import org.junit.jupiter.api.BeforeEach;

public class JdkLinkedListCustomStackTest extends AbstractCustomStackTest {

    @BeforeEach
    @Override
    public void init() {
        this.stack = new JdkLinkedListCustomStack<>();
    }
}
