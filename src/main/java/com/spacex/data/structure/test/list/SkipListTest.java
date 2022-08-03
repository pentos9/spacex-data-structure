package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.skiplist.ISkipList;
import com.spacex.data.structure.list.skiplist.SkipList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class SkipListTest {

    @Test
    public void test() {
        ISkipList<String> skipList = new SkipList<>();
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            int random = ThreadLocalRandom.current().nextInt(100);
            skipList.add(String.valueOf(random));
        }

        skipList.print();

        int random = ThreadLocalRandom.current().nextInt(total);
        skipList.search(String.valueOf(random));

        System.out.println(skipList.delete(String.valueOf(random)));

        int item = ThreadLocalRandom.current().nextInt(100, 1000);
        System.out.println("Inserting " + item);
        skipList.add(String.valueOf(item));
        skipList.print();
        skipList.search(String.valueOf(item));
    }

    @Test
    public void testSize() {
        ISkipList<String> skipList = new SkipList<>();
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            int random = ThreadLocalRandom.current().nextInt(100);
            skipList.add(String.valueOf(random));
        }
        Assertions.assertEquals(total, skipList.size());
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("0.5");
        System.out.println(bigDecimal);
        BigDecimal b2 = new BigDecimal(0.1);
        System.out.println(b2);
    }
}
