package com.spacex.data.structure.map.lru;

public interface ILRUCache<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();
}
