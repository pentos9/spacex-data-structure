package com.spacex.data.structure.test.list;

import com.spacex.data.structure.list.CustomList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractCustomListTest {

    protected CustomList customList;

    protected abstract void init();

    @Test
    public void testNonNull() {
        Assertions.assertNotNull(customList);
    }

    @Test
    public void testNullTest() {
        Assertions.assertTrue(customList.size() == 0);
        Assertions.assertTrue(customList.isEmpty());
        Assertions.assertFalse(customList.contains("Peace"));
    }

    @Test
    public void testAdd() {
        Object number = 12;
        customList.add(number);
        Assertions.assertTrue(customList.get(0).equals(number));
        Assertions.assertTrue(customList.contains(number));
    }

    @Test
    public void testAddByIndex() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(i, String.valueOf(i));
        }

        Assertions.assertTrue(customList.size() == loopTimes);
    }

    @Test
    public void testGet() {
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
    public void testSize() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add("Apple-" + i);
        }

        Assertions.assertTrue(customList.size() == loopTimes);
    }

    @Test
    public void testDestroy() {
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

    @Test
    public void testRemove() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(String.valueOf(i));
        }

        Assertions.assertTrue(customList.size() == loopTimes);

        for (int i = 0; i < loopTimes; i++) {
            customList.remove(customList.get(0));
        }

        Assertions.assertTrue(customList.size() == 0);
        Assertions.assertTrue(customList.isEmpty());
    }

    @Test
    public void testSet() {
        int loopTimes = (int) (Math.random() * 100);

        for (int i = 0; i < loopTimes; i++) {
            customList.add(0, String.valueOf(i));
        }
        Assertions.assertFalse(customList.size() == 0);
        Assertions.assertFalse(customList.isEmpty());

        String randomString = UUID.randomUUID().toString();

        int randomIndex = (int) (Math.random() * customList.size());
        customList.set(randomIndex, randomString);
        Assertions.assertTrue(randomString.equals(customList.get(randomIndex)));

    }

    @Test
    public void testIndexOf() {
        int loopTimes = (int) (Math.random() * 100);

        for (int i = 0; i < loopTimes; i++) {
            customList.add(0, String.valueOf(i));
        }

        int randomIndex = (int) (Math.random() * customList.size());
        Object target = customList.get(randomIndex);

        for (int i = 0; i < loopTimes; i++) {
            Assertions.assertTrue(Integer.valueOf(randomIndex).equals(customList.indexOf(target)));
        }

        System.out.println(customList.indexOf(null));
    }

    @Test
    public void testToArray() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(String.valueOf(i));
        }

        System.out.println("loopTimes:" + loopTimes);
        System.out.println(Arrays.toString(customList.toArray()));
    }

    @Test
    public void testIterator() {
        int loopTimes = (int) (Math.random() * 100);
        for (int i = 0; i < loopTimes; i++) {
            customList.add(String.valueOf(i));
        }

        System.out.println("testIterator loopTimes:" + loopTimes);
        for (Object obj : customList) {
            System.out.print(obj + "\t");
        }

        List list;
        new ArrayList().add(null);
        List l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.add(null);
            l.add(String.valueOf(i));
        }

        System.out.println(Arrays.toString(l.toArray()));

    }
}
