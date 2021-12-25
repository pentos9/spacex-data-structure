package com.spacex.data.structure.bst;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BinarySearchTree() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls contains() with a null key");
        }
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with a null key");
        }

        if (value == null) {
            delete(key);
            return;
        }

        root = put(root, key, value);
        assert check();
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.val = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls delete() with a null key");
        }

        root = delete(root, key);
        assert check();
    }

    private Node delete(Node node, Key key) {
        if (key == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.right);
        }
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("calls deleteMin() with a null key");
        }
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new PriorityQueue<>();
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node x = queue.remove();
            if (x == null) {
                continue;
            }

            keys.add(x.key);
            if (x.left != null) {
                queue.add(x.left);
            }

            if (x.right != null) {
                queue.add(x.right);
            }
        }
        return keys;
    }

    private boolean check() {
        // isBST()
        // isSizeConsistent()
        // isRankConsistent()

        if (!isBST()) {
            System.out.println("Not in symmetric order");
        }
        if (!isSizeConsistent()) {
            System.out.println("Subtree counts not consistent");
        }
        if (!isRankConsistent()) {
            System.out.println("Ranks not consistent");
        }
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) {
            return true;
        }
        if (min != null && x.key.compareTo(min) <= 0) {
            return false;
        }
        if (max != null && x.key.compareTo(max) >= 0) {
            return false;
        }
        return isBST(x.left, min, x.key) && isBST(x.right, max, x.key);
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null) {
            return true;
        }
        if (x.size != (size(x.left) + size(x.right) + 1)) {
            return false;
        }
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }

        for (Key key : keys()) {
            if (key.compareTo(select(rank(key))) != 0) {
                return false;
            }
        }
        return false;
    }

    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }

    private Key select(Node x, int rank) {
        if (x == null) {
            return null;
        }
        int leftSize = size(x.left);
        if (leftSize > rank) {
            return select(x.left, rank);
        } else if (leftSize < rank) {
            return select(x.right, rank);
        } else {
            return x.key;
        }
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (key == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }

    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new PriorityQueue<>();
        }
        return keys(min(), max());
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }

    public Iterable<Key> keys(Key low, Key high) {
        if (low == null) {
            throw new IllegalArgumentException("first argument to keys() is null ");
        }
        if (high == null) {
            throw new IllegalArgumentException("second argument to keys() is null ");
        }
        Queue<Key> queue = new PriorityQueue<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        return;
    }
}
