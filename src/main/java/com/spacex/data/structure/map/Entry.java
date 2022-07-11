package com.spacex.data.structure.map;

import java.util.Objects;

public class Entry<K, V> {
    final K key;
    final V value;

    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return Objects.equals(key, entry.key) &&
                Objects.equals(value, entry.value) &&
                Objects.equals(next, entry.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, next);
    }
}
