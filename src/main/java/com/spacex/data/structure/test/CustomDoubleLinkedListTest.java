package com.spacex.data.structure.test;

import com.spacex.data.structure.list.CustomDoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CustomDoubleLinkedListTest implements BaseListTest {

    private CustomDoubleLinkedList<String> doubleLinkedList;

    @BeforeEach
    public void init() {
        doubleLinkedList = new CustomDoubleLinkedList<>();
    }

    @Test
    @Override
    public void testNonNull() {
        Assertions.assertTrue(doubleLinkedList != null);
        Assertions.assertFalse(doubleLinkedList == null);
    }

    @Test
    @Override
    public void testNullTest() {
        Assertions.assertFalse(doubleLinkedList == null);
        doubleLinkedList = null;
        Assertions.assertTrue(doubleLinkedList == null);
    }

    @Test
    @Override
    public void testAdd() {
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            doubleLinkedList.add(random);
            Assertions.assertTrue(doubleLinkedList.size() == (i + 1));
            String result = doubleLinkedList.get(i);
            Assertions.assertTrue(random.equals(result));
        }
        Assertions.assertTrue(doubleLinkedList.size() == total);
    }

    @Test
    @Override
    public void testAddByIndex() {
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            String random = UUID.randomUUID().toString();
            doubleLinkedList.add(i, random);
            Assertions.assertTrue(doubleLinkedList.size() == (i + 1));
            String result = doubleLinkedList.get(i);
            Assertions.assertTrue(random.equals(result));
        }
    }

    @Override
    public void testGet() {
        int total = (int) (Math.random() * 100);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            doubleLinkedList.add(uuid);
            String result = doubleLinkedList.get(i);
            Assertions.assertTrue(uuid.equals(result));
        }
    }

    @Test
    @Override
    public void testSize() {
        int total = (int) (Math.random() * 100);

        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            doubleLinkedList.add(uuid);
            Assertions.assertTrue(doubleLinkedList.size() == (i + 1));
        }

        Assertions.assertTrue(total == doubleLinkedList.size());
    }

    @Test
    @Override
    public void testDestroy() {
        int total = new SecureRandom().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }
        Assertions.assertTrue(doubleLinkedList.size() == total);

        doubleLinkedList.clear();
        Assertions.assertTrue(doubleLinkedList.size() == 0);
        Assertions.assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    @Override
    public void testRemove() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < total; i++) {
            String item = doubleLinkedList.get(0);
            doubleLinkedList.remove(item);
        }

        Assertions.assertTrue(doubleLinkedList.size() == 0);
        Assertions.assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    @Override
    public void testRemoveByIndex() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }
        Assertions.assertTrue(doubleLinkedList.size() == total);

        for (int i = 0; i < total; i++) {
            doubleLinkedList.removeByIndex(0);
        }
        Assertions.assertTrue(doubleLinkedList.size() == 0);

    }

    @Test
    @Override
    public void testSet() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }

        String uuid = UUID.randomUUID().toString();
        int randomIndex = ThreadLocalRandom.current().nextInt(total);
        doubleLinkedList.set(randomIndex, uuid);
        Assertions.assertTrue(uuid.equals(doubleLinkedList.get(randomIndex)));
    }

    @Test
    @Override
    public void testIndexOf() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(total);
        String result = doubleLinkedList.get(randomIndex);
        int indexOf = doubleLinkedList.indexOf(result);
        Assertions.assertTrue(indexOf == randomIndex);
    }

    @Test
    @Override
    public void testToArray() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }
        Object[] array = doubleLinkedList.toArray();
        System.out.println(Arrays.toString(array));
    }

    @Test
    @Override
    public void testIterator() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            doubleLinkedList.add(UUID.randomUUID().toString());
        }

        int index = 0;
        for (String uuid : doubleLinkedList) {
            System.out.print((index + 1) + ":" + uuid + "\t");
            index++;
        }
        System.out.println("\n" + index);
    }
}
