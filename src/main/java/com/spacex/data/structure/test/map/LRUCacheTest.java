package com.spacex.data.structure.test.map;

import com.spacex.data.structure.map.lru.ILRUCache;
import com.spacex.data.structure.map.lru.LRUCache;
import com.spacex.data.structure.map.lru.LRULinkedListCache;
import com.spacex.data.structure.map.lru.LRUCacheImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class LRUCacheTest {
    private LRUCache<String, String> lruCacheStore;

    @BeforeEach
    public void init() {
        this.lruCacheStore = new LRUCache<>(10);
    }

    @Test
    public void testLRUCache() {
        int total = ThreadLocalRandom.current().nextInt(10, 100);
        LRUCache<String, String> lruCache = new LRUCache<>(10);
        for (int i = 0; i < total; i++) {
            lruCache.put(String.valueOf(i), String.valueOf(i));
        }

        Assertions.assertEquals(lruCache.size(), 10);
    }

    @Test
    public void testLinkedListLRUCache() {
        int cacheSize = 10;
        ILRUCache<String, String> cache = new LRULinkedListCache<>(cacheSize);
        int total = ThreadLocalRandom.current().nextInt(cacheSize, 100);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            cache.put(String.valueOf(i), uuid);
        }

        Assertions.assertEquals(cacheSize, cache.size());
    }

    @Test
    public void testLinkedListCacheGet() {
        int cacheSize = 10;
        ILRUCache<String, String> cache = new LRULinkedListCache<>(cacheSize);
        int total = ThreadLocalRandom.current().nextInt(cacheSize, 100);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            cache.put(String.valueOf(i), uuid);
        }

        for (int i = 0; i < cache.size(); i++) {
            cache.get(String.valueOf(i));
        }
        Assertions.assertEquals(cacheSize, cache.size());
    }

    @Test
    public void testLRUCacheImpl() {
        int capacity = 10;
        ILRUCache<String, String> lruCache = new LRUCacheImpl<>(capacity);
        int total = ThreadLocalRandom.current().nextInt(10, 100);
        for (int i = 0; i < total; i++) {
            String uuid = UUID.randomUUID().toString();
            lruCache.put(String.valueOf(i), uuid);
        }

        for (int i = 0; i < total; i++) {
            int key = ThreadLocalRandom.current().nextInt(10, total);
            lruCache.get(String.valueOf(key));
        }

        Assertions.assertEquals(capacity, lruCache.size());
    }

    @Test
    public void testLRUShow() {
        LRUCacheImpl<String, String> cache = new LRUCacheImpl<>(10);
        for (int i = 0; i < 30; i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }

        cache.display();

        LRUCacheImpl<Integer, String> lruCache = new LRUCacheImpl<>(3);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");
        lruCache.put(4, "four"); // putting new cache when full. 1 will be removed
        lruCache.get(3); // accessing 3, it will be moved to top
        lruCache.get(2);// accessing 2, it will be moved to top
        lruCache.put(1, "one"); // putting new cache when full. 4 will be removed
        lruCache.get(3);// accessing 3, it will be moved to top
        lruCache.get(1);// accessing 1, it will be moved to top
        lruCache.display(); // 1 should be on top
    }
}
