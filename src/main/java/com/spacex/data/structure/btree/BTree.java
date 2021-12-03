package com.spacex.data.structure.btree;

public class BTree<Key extends Comparable<Key>, Value> {

    // max children per B-tree node = M-1
    // (must be even and greater than 2)
    private static final int M = 4;

    private Node root; // root of the B-tree
    private int height; // height of the B-tree
    private int n; // number of key-value pairs in the B-tree

    private static final class Node {
        private int m;
        private Entry[] children = new Entry[M];

        // create a node with k children
        private Node(int k) {
            this.m = k;
        }
    }

    // internal nodes: only use key and next
    // external nodes: only use key and value
    private static final class Entry {
        private Comparable key;
        private Object val;
        private Node next;

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public BTree() {
        root = new Node(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public int height() {
        return this.height;
    }

    public Value getValue(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        return this.search(this.root, key, this.height);
    }

    private Value search(Node x, Key key, int height) {
        Entry[] children = x.children;
        if (height == 0) {
            for (int j = 0; j < x.m; j++) {
                if (eq(key, children[j].key)) {
                    return (Value) children[j].val;
                }
            }
        } else {
            for (int j = 0; j < x.m; j++) {
                if (j + 1 == x.m || less(key, children[j + 1].key)) {
                    return search(children[j].next, key, height - 1);
                }
            }
        }
        return null;
    }

    // comparison functions - make Comparable instead of Key to avoid casts
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }
}
