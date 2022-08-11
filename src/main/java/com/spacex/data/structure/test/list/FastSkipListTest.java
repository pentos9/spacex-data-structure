package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.skiplist.FastSkipList;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class FastSkipListTest {

    @Test
    public void test() {
        FastSkipList<Integer> fastSkipList = new FastSkipList<>();
        for (int i = 1; i < 20; i++) {
            fastSkipList.add(new FastSkipList.SkipNode<>(i, 666));
        }

        fastSkipList.print();
    }

    private FastSkipList<String> produce(int max) {
        FastSkipList<String> fastSkipList = new FastSkipList<>();
        int total = ThreadLocalRandom.current().nextInt(max);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            fastSkipList.add(new FastSkipList.SkipNode<>(i, uuid));
        }
        return fastSkipList;
    }

    @Test
    public void testAdd() {
        int total = 100;
        FastSkipList<String> fastSkipList = produce(total);
        fastSkipList.print();


        System.out.println("===== SEARCH =====");
        for (int i = 0; i < total; i++) {
            int randomKey = ThreadLocalRandom.current().nextInt(total);
            FastSkipList.SkipNode<String> node = fastSkipList.search(randomKey);
            System.out.println("key:" + randomKey + ",node:" + node + ",total:" + total);
        }
    }

    @Test
    public void testDelete() {
        int maxTotal = 100;
        FastSkipList<String> fastSkipList = produce(maxTotal);

        System.out.println("====before delete====");
        fastSkipList.print();
        fastSkipList.delete(2);
        System.out.println("====after delete====");
        fastSkipList.print();


        System.out.println();
    }
}
