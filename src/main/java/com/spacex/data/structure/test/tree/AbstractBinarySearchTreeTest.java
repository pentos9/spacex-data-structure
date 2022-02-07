package com.spacex.data.structure.test.tree;

import com.spacex.data.structure.customtree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractBinarySearchTreeTest {

    protected BinarySearchTree tree;

    protected abstract void init();

    @Test
    public void testSize() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            tree.add(String.valueOf(i));
        }

        Assertions.assertTrue(tree.size() == total);
    }

    @Test
    public void testNull() {

    }

    @Test
    public void testNonNull() {

    }

    @Test
    public void testEmpty() {

    }
}
