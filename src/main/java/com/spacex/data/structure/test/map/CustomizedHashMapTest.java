package com.spacex.data.structure.test.map;

import com.spacex.data.structure.map.CustomizedHashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class CustomizedHashMapTest {

    private CustomizedHashMap<String, String> map;

    @BeforeEach
    public void init() {
        this.map = new CustomizedHashMap<>();
    }

    @Test
    public void testSize() {
        map.put("CN", "China");
        map.put("US", "USA");
        map.put("UK", "Britain");
        map.put("JP", "Japan");

        int total = 4;
        Assertions.assertEquals(map.size(), total);
        System.out.println(map);
        HashMap map;
    }

    @Test
    public void testGet() {
        map.put("CN", "China");
        map.put("US", "USA");
        map.put("UK", "Britain");
        map.put("JP", "Japan");

        Assertions.assertTrue("China".equals(map.get("CN")));
        Assertions.assertTrue("USA".equals(map.get("US")));
        Assertions.assertTrue("Britain".equals(map.get("UK")));
        Assertions.assertTrue("Japan".equals(map.get("JP")));
    }

    @Test
    public void testRemove() {
        int total = 4;
        map.put("CN", "China");
        map.put("US", "USA");
        map.put("UK", "Britain");
        map.put("JP", "Japan");

        Assertions.assertEquals("China", map.get("CN"));
        Assertions.assertEquals("USA", map.get("US"));
        Assertions.assertEquals("Britain", map.get("UK"));
        Assertions.assertEquals("Japan", map.get("JP"));

        Assertions.assertEquals(map.size(), total);

        map.remove("CN");
        Assertions.assertNull(map.get("CN"));
        Assertions.assertEquals(map.size(), total - 1);

        map.remove("US");
        Assertions.assertNull(map.get("US"));
        Assertions.assertEquals(map.size(), total - 2);

        map.remove("UK");
        Assertions.assertNull(map.get("UK"));
        Assertions.assertEquals(map.size(), total - 3);

        map.remove("JP");
        Assertions.assertNull(map.get("JP"));
        Assertions.assertEquals(map.size(), total - 4);
    }
}
