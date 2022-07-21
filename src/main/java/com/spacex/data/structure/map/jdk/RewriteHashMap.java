package com.spacex.data.structure.map.jdk;

import java.util.HashMap;
import java.util.Set;

public class RewriteHashMap<K, V> extends HashMap<K, V> {

    @Override
    public V get(Object key) {
        System.out.println("RewriteHashMap#get key:" + key);
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        System.out.println("RewriteHashMap#put key:" + key + ",value:" + value);
        return super.put(key, value);
    }

    @Override
    public V remove(Object key) {
        System.out.println("RewriteHashMap#remove key:" + key);
        return super.remove(key);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        System.out.println("RewriteHashMap#putIfAbsent key:" + key + ",value:" + value);
        return super.putIfAbsent(key, value);
    }

    public Set<K> getKeySet() {
        return keySet();
    }
}
