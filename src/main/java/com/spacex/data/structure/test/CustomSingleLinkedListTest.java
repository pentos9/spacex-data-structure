package com.spacex.data.structure.test;

import com.spacex.data.structure.list.CustomList;
import com.spacex.data.structure.list.CustomSingleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class CustomSingleLinkedListTest implements BaseListTest {

    private CustomList<String> singleLinkedList;

    @BeforeEach
    public void init() {
        singleLinkedList = new CustomSingleLinkedList<>();
    }

    @Test
    @Override
    public void testNonNull() {
        Assertions.assertTrue(singleLinkedList != null);
    }

    @Test
    @Override
    public void testNullTest() {
        singleLinkedList = null;
        Assertions.assertTrue(singleLinkedList == null);
    }

    @Test
    @Override
    public void testAdd() {
        int total = initList();
        Assertions.assertTrue(singleLinkedList.size() == total);
        Assertions.assertFalse(singleLinkedList.isEmpty());
    }

    @Test
    @Override
    public void testAddByIndex() {
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            String random = String.valueOf(i) + "--" + UUID.randomUUID().toString();
            singleLinkedList.add(i, random);
            Assertions.assertTrue(random.equals(singleLinkedList.get(i)));
        }

        for (int i = 0; i < this.singleLinkedList.size(); i++) {
            String item = singleLinkedList.get(i);
        }
    }

    @Test
    @Override
    public void testGet() {
        int total = (int) (Math.random() * 100);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            singleLinkedList.add(random);
            map.put(i, random);
            Assertions.assertTrue(random.equals(singleLinkedList.get(i)));
        }

        for (int i = 0; i < total; i++) {
            String random = map.get(i);
            Assertions.assertTrue(random.equals(singleLinkedList.get(i)));
        }
    }

    @Test
    @Override
    public void testSize() {
        int total = initList();
        Assertions.assertTrue(singleLinkedList.size() == total);
    }

    private int initList() {
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            singleLinkedList.add(UUID.randomUUID().toString());
        }
        return total;
    }

    @Test
    @Override
    public void testDestroy() {
        initList();
        singleLinkedList.clear();
        Assertions.assertTrue(singleLinkedList.size() == 0);
        Assertions.assertTrue(singleLinkedList.isEmpty());
    }

    @Test
    @Override
    public void testRemove() {
        CustomSingleLinkedList<String> singleLinkedList = new CustomSingleLinkedList<>();
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            singleLinkedList.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < total; i++) {
            String random = singleLinkedList.get(0);
            singleLinkedList.remove(random);
        }

        Assertions.assertTrue(singleLinkedList.isEmpty());
        Assertions.assertTrue(singleLinkedList.size() == 0);
    }

    @Test
    @Override
    public void testRemoveByIndex() {
        CustomSingleLinkedList<String> singleLinkedList = new CustomSingleLinkedList<>();
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            singleLinkedList.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < total; i++) {
            singleLinkedList.removeByIndex(0);
        }

        Assertions.assertTrue(singleLinkedList.isEmpty());
        Assertions.assertTrue(singleLinkedList.size() == 0);
    }

    @Test
    @Override
    public void testSet() {
        int total = initList();
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            singleLinkedList.set(i, random);
            String queryResult = singleLinkedList.get(i);
            Assertions.assertTrue(random.equals(queryResult));
        }

        Assertions.assertTrue(singleLinkedList.size() == total);
    }

    @Test
    @Override
    public void testIndexOf() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            int total = (int) (Math.random() * 100);
            for (int i = 0; i < total; i++) {
                String uuid = UUID.randomUUID().toString();
                // singleLinkedList is empty currently,so it should throws exception
                singleLinkedList.set(i, uuid);
            }
        });
    }

    @Test
    public void testIndexOf2() {
        int total = initList();
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            singleLinkedList.set(i, uuid);
            String result = singleLinkedList.get(i);
            int index = singleLinkedList.indexOf(uuid);
            Assertions.assertTrue(index == i);
            Assertions.assertTrue(uuid.equals(result));
        }
    }

    @Test
    @Override
    public void testToArray() {
        int total = initList();
        Assertions.assertTrue(singleLinkedList.size() == total);
        System.out.println(Arrays.toString(singleLinkedList.toArray()));
    }

    @Test
    @Override
    public void testIterator() {
        int total = initList();
        for (String item : singleLinkedList) {
            System.out.print(item + ",");
        }
    }
}