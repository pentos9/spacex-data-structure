package com.spacex.data.structure.test.tree;

import com.spacex.data.structure.customtree.RedBlackTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RedBlackTreeTest {

    private RedBlackTree<String> redBlackTree;

    @BeforeEach
    public void init() {
        redBlackTree = new RedBlackTree<>();
    }

    @Test
    public void testNull() {
        Assertions.assertTrue(redBlackTree != null);
        redBlackTree = null;
        Assertions.assertNull(redBlackTree);
    }

    @Test
    public void testNonNull() {
        Assertions.assertTrue(redBlackTree != null);
        Assertions.assertTrue(redBlackTree.size() == 0);
    }

    @Test
    public void testSize() {
        Assertions.assertTrue(redBlackTree.size() == 0);

        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            redBlackTree.addNode(String.valueOf(i));
        }

        Assertions.assertTrue(redBlackTree.size() == total);
    }

    @Test
    public void testAdd() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            redBlackTree.addNode(UUID.randomUUID().toString());
        }

        Assertions.assertTrue(redBlackTree.size() == total);
    }

    @Test
    public void testFind() {

    }

    @Test
    public void testRemove() {
        int total = ThreadLocalRandom.current().nextInt(100);
        String random = UUID.randomUUID().toString();
        for (int i = 0; i < total; i++) {
            if (i == 0) {
                redBlackTree.addNode(random);
            }
            String uuid = UUID.randomUUID().toString();
            redBlackTree.addNode(uuid);
        }

        Assertions.assertTrue(redBlackTree.find(random) != null);
        redBlackTree.remove(random);
        Assertions.assertTrue(redBlackTree.find(random) == null);
    }

    @Test
    public void testPrint() {

    }
}
