package com.spacex.data.structure.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomHashSet<E> {

    private static final Object OBJECT = new Object();
    private HashMap<E, Object> hashMap = null;

    public CustomHashSet() {
        this.hashMap = new HashMap<>();
    }

    public boolean isEmpty() {
        return this.hashMap.isEmpty();
    }

    public int size() {
        return this.hashMap.size();
    }

    public boolean add(E element) {
        return hashMap.put(element, OBJECT) == null;
    }

    public void addAll(Collection<E> collection) {
        Map<E, Object> map = new HashMap<>();
        for (E element : collection) {
            map.put(element, OBJECT);
        }
        this.hashMap.putAll(map);
    }

    public boolean remove(Object element) {
        return this.hashMap.remove(element) == OBJECT;
    }

    public boolean contains(E element) {
        return this.hashMap.containsKey(element);
    }

    public boolean containsAll(Collection<E> collection) {
        return this.hashMap.keySet().containsAll(collection);
    }

    public Iterator<E> iterator() {
        return this.hashMap.keySet().iterator();
    }

    public void clear() {
        this.hashMap.clear();
    }
}
