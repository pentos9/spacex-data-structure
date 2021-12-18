package com.spacex.data.structure.bst;

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

    private boolean check() {
        // isBST()
        // isSizeConsistent()
        // isRankConsistent()

        return false;
    }
}
