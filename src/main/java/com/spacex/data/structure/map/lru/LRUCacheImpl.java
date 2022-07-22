package com.spacex.data.structure.map.lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl<K, V> implements ILRUCache<K, V> {

    private Map<K, V> cache;
    private Deque<K> order;
    private int capacity;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.order = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        if (this.order.size() >= this.capacity) {
            K keyRemove = order.removeLast();
            this.cache.remove(keyRemove);
        }

        this.order.addFirst(key);
        this.cache.put(key, value);
    }

    @Override
    public V get(K key) {
        V res = this.cache.get(key);
        if (res != null) {
            this.order.remove(key);
            this.order.addFirst(key);
        } else {
            res = null;
        }
        return res;
    }

    @Override
    public int size() {
        return this.cache.size();
    }

    public void display() {
        for (K key : this.order) {
            System.out.print(this.cache.get(key) + " ");
        }
        System.out.println();
    }
}
