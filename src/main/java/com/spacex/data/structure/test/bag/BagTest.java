package com.spacex.data.structure.test.bag;

import com.spacex.data.structure.bag.Bag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class BagTest {
    private Bag<String> bag;

    @BeforeEach
    public void init() {
        this.bag = new Bag<>();
    }

    @Test
    public void testAdd() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            bag.add(String.valueOf(i));
        }
        Assertions.assertEquals(total, bag.size());
    }
}
