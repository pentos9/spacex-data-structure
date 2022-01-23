package com.spacex.data.structure.test;

import com.spacex.data.structure.btree.BTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class BTressTest {

    private BTree<String, String> bTree;

    @BeforeEach
    public void init() {
        bTree = new BTree<>();
    }

    @Test
    public void testSize() {
        int total = ThreadLocalRandom.current().nextInt(20);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            bTree.put(String.valueOf(i), uuid);
        }

        Assertions.assertTrue(bTree.size() == total);

        System.out.println(bTree.toString());
    }
}
