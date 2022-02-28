package com.spacex.data.structure.customtree;

import java.util.concurrent.atomic.AtomicLong;

public class RedBlackTree<T extends Comparable<T>> {

    private Node<T> root;
    private AtomicLong size = new AtomicLong(0);
    private volatile boolean overwriteMode = true;

    public RedBlackTree() {
        this.root = new Node<>();
    }

    public RedBlackTree(boolean overwriteMode) {
        this();
        this.overwriteMode = overwriteMode;
    }

    public boolean isOverwriteMode() {
        return this.overwriteMode;
    }

    public void setOverwriteMode(boolean overwriteMode) {
        this.overwriteMode = overwriteMode;
    }

    public long size() {
        return size.get();
    }

    private Node<T> getRoot() {
        return root.left;
    }

    public T addNode(T value) {
        Node<T> node = new Node<>(value);
        return addNode(node);
    }

    private T addNode(Node<T> node) {
        return null;
    }

    public T find(T value) {
        Node<T> dataRoot = getRoot();
        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp > 0) {
                dataRoot = dataRoot.getLeft();
            } else if (cmp < 0) {
                dataRoot = dataRoot.getRight();
            } else {
                return dataRoot.getValue();
            }
        }
        return null;
    }

    public T remove(T value) {
        return null;
    }

    private class Node<T> {
        private T value;
        private boolean red;
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, boolean isRed) {
            this.value = value;
            this.red = isRed;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public T getValue() {
            return this.value;
        }

        public boolean isRed() {
            return this.red;
        }

        public boolean isBlack() {
            return !this.red;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        public void makeRed() {
            this.red = true;
        }

        public void makeBlack() {
            this.red = false;
        }
    }
}
