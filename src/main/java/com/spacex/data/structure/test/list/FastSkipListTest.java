package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.skiplist.FastSkipList;
import org.junit.jupiter.api.Test;

public class FastSkipListTest {

    @Test
    public void test() {
        FastSkipList<Integer> fastSkipList = new FastSkipList<>();
        for (int i = 1; i < 20; i++) {
            fastSkipList.add(new FastSkipList.SkipNode<>(i, 666));
        }

        fastSkipList.print();
    }
}
