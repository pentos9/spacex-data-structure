package com.spacex.data.structure.map.fastmap;

import java.util.Objects;

public class KeyValueEntry<K, V> {
    private K key;
    private V value;

    public KeyValueEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyValueEntry)) return false;
        KeyValueEntry<?, ?> that = (KeyValueEntry<?, ?>) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "KeyValueEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
