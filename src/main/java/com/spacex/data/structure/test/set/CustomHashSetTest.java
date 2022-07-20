package com.spacex.data.structure.test.set;

import com.spacex.data.structure.set.CustomHashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomHashSetTest {

    private CustomHashSet<String> customHashSet;

    @BeforeEach
    public void init() {
        this.customHashSet = new CustomHashSet<>();
    }

    @Test
    public void test() {
        Assertions.assertTrue(customHashSet.isEmpty());

        HashMap<String, String> map = new HashMap<>();
        Set<String> stringSet = map.keySet();
        stringSet.iterator();
    }

    @Test
    public void testSize() {
        Assertions.assertTrue(customHashSet.isEmpty());
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customHashSet.add(String.valueOf(i));
        }

        Assertions.assertTrue(customHashSet.size() == total);
    }

    @Test
    public void testAdd() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customHashSet.add(String.valueOf(i));
        }

        Assertions.assertTrue(customHashSet.size() == total);
        for (int i = 0; i < total; i++) {
            int random = ThreadLocalRandom.current().nextInt(customHashSet.size());
            Assertions.assertTrue(customHashSet.contains(String.valueOf(random)));
        }
    }

    @Test
    public void testContain() {
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            customHashSet.add(String.valueOf(i));
        }

        List<String> numbers = IntStream.range(0, total).boxed().map(String::valueOf).collect(Collectors.toList());
        customHashSet.addAll(numbers);
        Assertions.assertTrue(customHashSet.containsAll(numbers));
    }

    @Test
    public void testRemove() {
        int total = ThreadLocalRandom.current().nextInt(100);
        List<String> numbers = IntStream.range(0, total).boxed().map(String::valueOf).collect(Collectors.toList());
        customHashSet.addAll(numbers);
        Assertions.assertTrue(customHashSet.containsAll(numbers));

        for (int i = 0; i < numbers.size(); i++) {
            customHashSet.remove(String.valueOf(i));
        }

        Assertions.assertTrue(customHashSet.size() == 0);
        Assertions.assertFalse(customHashSet.containsAll(numbers));
    }
}
