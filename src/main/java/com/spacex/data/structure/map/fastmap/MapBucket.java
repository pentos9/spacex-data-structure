package com.spacex.data.structure.map.fastmap;

import java.util.LinkedList;

public class MapBucket<K, V> {
    private LinkedList<KeyValueEntry<K, V>> entries;

    public MapBucket() {
        this.entries = new LinkedList<>();
    }

    public LinkedList<KeyValueEntry<K, V>> getEntries() {
        return entries;
    }

    public void addEntry(KeyValueEntry<K, V> entry) {
        this.entries.add(entry);
    }

    public void removeEntry(KeyValueEntry<K, V> entry) {
        this.entries.remove(entry);
    }
}
