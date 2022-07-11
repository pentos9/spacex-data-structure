package com.spacex.data.structure.map;

public class CustomizeHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16

    private int size = 0;

    public CustomizeHashMap() {
        this(INITIAL_CAPACITY);
    }

    public CustomizeHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {

    }

    public V get(K key) {

        return null;
    }
}
