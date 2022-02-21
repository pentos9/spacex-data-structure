package com.spacex.data.structure.test.tree;

import com.spacex.data.structure.customtree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;
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
        Assertions.assertNotNull(tree);
        Assertions.assertTrue(tree.isEmpty());
        Assertions.assertTrue(tree.size() == 0);
    }

    @Test
    public void testNonNull() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            tree.add(random);
        }

        Assertions.assertFalse(tree.isEmpty());
        Assertions.assertFalse(tree.size() == 0);
    }

    @Test
    public void testEmpty() {
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    public void testAdd() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            tree.add(random);
        }

        Assertions.assertTrue(tree.size() == total);
    }

    @Test
    public void testContains() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            tree.add(random);
        }


        Assertions.assertFalse(tree.conntains(""));
        String random = UUID.randomUUID().toString();
        tree.add(random);
        Assertions.assertTrue(tree.conntains(random));
    }

    private BinarySearchTree initGoodTree() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            tree.add(random);
        }
        return tree;
    }

    @Test
    public void testPreOrderTraverse() {
        initGoodTree();
        tree.preOrderTraverse();
    }

    @Test
    public void testInOrderTraverse() {
        initGoodTree();
        tree.inOrderTraverse();
    }

    @Test
    public void testPostOrderTraverse() {
        initGoodTree();
        tree.postOrderTraverse();
    }

    @Test
    public void testPreOrderNonRecursiveTraverse() {
        initGoodTree();
        tree.preOrderNonRecursiveTraverse();
    }

    @Test
    public void testInOrderNonRecursiveTraverse() {
        initGoodTree();
        tree.inOrderTraverse();
    }

    @Test
    public void testPostOrderNonRecursiveTraverse() {
        initGoodTree();
        tree.postOrderNonRecursiveTraverse();
    }

}
