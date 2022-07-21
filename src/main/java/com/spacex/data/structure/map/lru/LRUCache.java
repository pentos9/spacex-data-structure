package com.spacex.data.structure.map.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> implements ILRUCache<K, V> {
    private Map<K, V> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<K, V>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > getCacheCapacity();
            }
        };
    }

    private int getCacheCapacity() {
        return this.capacity;
    }

    @Override
    public void put(K key, V value) {
        this.map.put(key, value);
    }

    @Override
    public V get(K key) {
        return this.map.get(key);
    }

    public void remove(K key) {
        this.map.remove(key);
    }

    @Override
    public int size() {
        return this.map.size();
    }
}
