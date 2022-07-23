package com.spacex.data.structure.map.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRULinkedListCache<K, V> implements ILRUCache<K, V> {

    class Node<K, V> {
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this;
            this.next = this;
        }
    }

    private final int capacity;
    private Node dummy;
    private Map<K, Node> cache;

    public LRULinkedListCache(int capacity) {
        this.capacity = capacity;
        this.dummy = new Node<>(new Object(), new Object());
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public void put(K key, V value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= this.capacity) {
                cache.remove(dummy.next.key);
                remove(dummy.next);
            }

            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        } else {
            cache.remove(node.key);
            remove(node);
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        }
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void add(Node node) {
        this.dummy.pre.next = node;
        node.pre = this.dummy.pre;
        node.next = this.dummy;
        this.dummy.pre = node;
    }

    @Override
    public V get(K key) {
        Node node = this.cache.get(key);
        if (node == null) {
            return null;
        }
        remove(key);
        add(node);
        return (V) node.value;
    }

    public void remove(K key) {
        Node node = this.cache.get(key);
        if (node != null) {
            remove(node);
        }
    }

    @Override
    public int size() {
        return this.cache.size();
    }
}
