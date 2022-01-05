package com.spacex.data.structure.test;

import com.spacex.data.structure.list.CustomArrayList;
import com.spacex.data.structure.list.CustomList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArrayListTestCase {

    private CustomList customList;

    @BeforeEach
    public void init() {
        customList = new CustomArrayList();
    }

    @Test
    public void nonNull() {
        Assertions.assertNotNull(customList);
    }

    @Test
    public void add() {
        Object number = 12;
        customList.add(number);
        Assertions.assertTrue(customList.get(0).equals(number));
        Assertions.assertTrue(customList.contains(number));
    }

    @Test
    public void get() {
        Assertions.assertTrue(customList.size() == 0);
        int loopTimes = 20;
        String prefix = "item-";
        for (int i = 0; i < loopTimes; i++) {
            customList.add(prefix + i);
        }

        for (int i = 0; i < loopTimes; i++) {
            Assertions.assertTrue(customList.get(i).equals(prefix + i));
        }
    }
}
