package com.spacex.data.structure.test.tree;

import com.spacex.data.structure.customtree.RedBlackTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
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
        int total = ThreadLocalRandom.current().nextInt(100);
        List<String> uuidList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            uuidList.add(uuid);
            redBlackTree.addNode(uuid);
        }

        for (int i = 0; i < total; i++) {
            int index = ThreadLocalRandom.current().nextInt(total);
            String random = uuidList.get(index);
            Assertions.assertEquals(random, redBlackTree.find(random));
        }

    }

    @Test
    public void testRemove() {
        int total = ThreadLocalRandom.current().nextInt(100);
        String random = UUID.randomUUID().toString();
        List<String> uuidList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (i == 0) {
                redBlackTree.addNode(random);
            }
            String uuid = UUID.randomUUID().toString();
            uuidList.add(uuid);
            redBlackTree.addNode(uuid);
        }

        Assertions.assertTrue(redBlackTree.find(random) != null);
//        redBlackTree.remove(random);
//        Assertions.assertTrue(redBlackTree.find(random) == null);

        for (int i = 0; i < total; i++) {
            int index = ThreadLocalRandom.current().nextInt(uuidList.size());
            String randomUUID = uuidList.get(index);
            Assertions.assertEquals(randomUUID, redBlackTree.remove(randomUUID));
            uuidList.remove(randomUUID);
        }

    }

    @Test
    public void testPrint() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            redBlackTree.addNode(String.valueOf(i));
        }

        System.out.println(redBlackTree.size());
        redBlackTree.printTree();
    }
}
