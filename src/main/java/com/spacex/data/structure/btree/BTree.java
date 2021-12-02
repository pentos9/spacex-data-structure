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
}
