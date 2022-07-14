package com.spacex.data.structure.test.map;

import com.spacex.data.structure.map.fastmap.FastHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class FastHashMapTest {

    private FastHashMap<String, String> fastHashMap;

    @BeforeEach
    public void init() {
        fastHashMap = new FastHashMap<>();
    }

    @Test
    public void testSize() {
        Assertions.assertTrue(fastHashMap.size() == 0);
        Assertions.assertTrue(fastHashMap.isEmpty());

        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            fastHashMap.put(String.valueOf(i), String.valueOf(i));
        }

        Assertions.assertTrue(fastHashMap.size() == total);
    }

    @Test
    public void testEmpty() {
        Assertions.assertTrue(fastHashMap.isEmpty());
        Assertions.assertTrue(fastHashMap.size() == 0);
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            fastHashMap.put(String.valueOf(i), String.valueOf(i));
        }

        Assertions.assertTrue(fastHashMap.size() == total);
    }

    @Test
    public void testContainsKey() {
        Assertions.assertFalse(fastHashMap.containsKey("fast"));
        Assertions.assertFalse(fastHashMap.size() > 0);
        Assertions.assertTrue(fastHashMap.isEmpty());

        Assertions.assertFalse(fastHashMap.containsKey("NEW"));
        int total = ThreadLocalRandom.current().nextInt(100);
        for (int i = 0; i < total; i++) {
            fastHashMap.put(String.valueOf(i), String.valueOf(i));
        }

        for (int i = 0; i < total; i++) {
            int random = ThreadLocalRandom.current().nextInt(total);
            Assertions.assertTrue(fastHashMap.containsKey(String.valueOf(random)));
        }
    }

    @Test
    public void testPut() {
        Assertions.assertFalse(fastHashMap.containsKey("fast"));

        fastHashMap.put("CN", "CHINA");
        Assertions.assertEquals("CHINA", fastHashMap.get("CN"));

        fastHashMap.get("DD");
    }

    @Test
    public void testPutIfAbsent() {
        String key = "fast";
        String value = "fast-hash-fastmap";
        Assertions.assertFalse(fastHashMap.containsKey(key));
        fastHashMap.put(key, value);
        Assertions.assertTrue(fastHashMap.containsKey(key));
        Assertions.assertEquals(value, fastHashMap.get(key));

        String newValue = "new-fast-hash-fastmap";
        fastHashMap.putIfAbsent(key, newValue);
        Assertions.assertNotEquals(newValue, fastHashMap.get(key));
        Assertions.assertEquals(value, fastHashMap.get(key));

        fastHashMap.remove(key);
        Assertions.assertNull(fastHashMap.get(key));
        fastHashMap.putIfAbsent(key, newValue);
        Assertions.assertEquals(newValue, fastHashMap.get(key));
    }

    @Test
    public void testRemove() {
        Assertions.assertTrue(fastHashMap.isEmpty());

        int total = 10;
        for (int i = 0; i < total; i++) {
            fastHashMap.put(String.valueOf(i), String.valueOf(i));
        }

        for (int i = 0; i < total; i++) {
            int randomKey = ThreadLocalRandom.current().nextInt(total);
            Assertions.assertTrue(fastHashMap.containsKey(String.valueOf(randomKey)));
        }

        for (int i = 0; i < total; i++) {
            String key = fastHashMap.get(String.valueOf(i));
            Assertions.assertTrue(fastHashMap.containsKey(key));

            fastHashMap.remove(key);
            Assertions.assertFalse(fastHashMap.containsKey(key));
        }

    }

    @Test
    public void testBigHashMap() {
        // it is very slow if total is bigger than 1<<18, even though it works fine
        // that is the side effect of no resizing
        // it still has a lot to do to get an efficient hash map (resizing,linkedList to RBTree ...)
        int total = 1 << 10;

        for (int i = 0; i < total; i++) {
            fastHashMap.put(String.valueOf(i), String.valueOf(i));
        }

        int random = ThreadLocalRandom.current().nextInt(total);
        System.out.println(fastHashMap.get(String.valueOf(random)));

    }
}
