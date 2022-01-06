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
    public void nullTest() {
        Assertions.assertTrue(customList.size() == 0);
        Assertions.assertTrue(customList.isEmpty());
        Assertions.assertFalse(customList.contains("Peace"));
    }

    @Test
    public void add() {
        Object number = 12;
        customList.add(number);
        Assertions.assertTrue(customList.get(0).equals(number));
        Assertions.assertTrue(customList.contains(number));
    }

    @Test
    public void addByIndexTest() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(i, String.valueOf(i));
        }

        Assertions.assertTrue(customList.size() == loopTimes);
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

    @Test
    public void sizeTest() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add("Apple-" + i);
        }

        Assertions.assertTrue(customList.size() == loopTimes);
    }

    @Test
    public void destroyTest() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(String.valueOf(i));
        }

        Assertions.assertTrue(customList.size() == loopTimes);
        Assertions.assertFalse(customList.isEmpty());

        customList.clear();
        Assertions.assertTrue(customList.size() == 0);
        Assertions.assertTrue(customList.isEmpty());
    }
}
