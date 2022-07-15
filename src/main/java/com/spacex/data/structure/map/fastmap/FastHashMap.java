package com.spacex.data.structure.map.fastmap;

import java.util.Arrays;
import java.util.Objects;

public class FastHashMap<K, V> {
    private int CAPACITY = 1 << 4;
    private MapBucket[] buckets;
    private int size = 0;

    public FastHashMap() {
        this.buckets = new MapBucket[CAPACITY];
    }

    private int getHash(K key) {
        return key == null ? 0 : ((key.hashCode() & 0xfffffff) % CAPACITY);
    }

    private KeyValueEntry<K, V> getEntry(K key) {
        int hash = getHash(key);// bucket index
        for (int i = 0; i < this.buckets[hash].getEntries().size(); i++) {
            KeyValueEntry<K, V> kvKeyValueEntry = (KeyValueEntry<K, V>) this.buckets[hash].getEntries().get(i);
            if (kvKeyValueEntry.getKey().equals(key)) {
                return kvKeyValueEntry;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            KeyValueEntry<K, V> entry = getEntry(key);
            entry.setValue(value);
        } else {
            int hash = getHash(key);
            if (this.buckets[hash] == null) {
                this.buckets[hash] = new MapBucket();
            }
            this.buckets[hash].addEntry(new KeyValueEntry<>(key, value));
            this.size++;
        }
    }

    public void putIfAbsent(K key, V value) {
        if (containsKey(key)) {
            return;
        }

        int hash = getHash(key);
        if (this.buckets[hash] == null) {
            this.buckets[hash] = new MapBucket();
        }
        this.buckets[hash].addEntry(new KeyValueEntry<>(key, value));
        this.size++;

    }

    public V get(K key) {
        return containsKey(key) ? getEntry(key).getValue() : null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        // login operation ¬(A∨B)=¬A∧¬B,¬(A||B)=¬A && ¬B
        return !(Objects.isNull(this.buckets[hash]) || Objects.isNull(getEntry(key)));
    }

    public boolean remove(K key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            this.buckets[hash].removeEntry(getEntry(key));
            this.size--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean clear() {
        Arrays.fill(this.buckets, null);
        this.size = 0;
        return true;
    }
}