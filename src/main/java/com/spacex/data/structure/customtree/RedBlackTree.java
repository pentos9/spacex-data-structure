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
        return this.size.get();
    }

    private Node<T> getRoot() {
        return this.root.getLeft();
    }

    public T addNode(T value) {
        Node<T> node = new Node<>(value);
        return addNode(node);
    }

    private T addNode(Node<T> node) {
        node.setLeft(null);
        node.setRight(null);
        node.setRed(true);
        setParent(node, null);

        if (node.getLeft() == null) {
            root.setLeft(node);
            //root node is black
            node.setRed(false);
            size.incrementAndGet();
        } else {
            Node<T> x = findParentNode(node);
            int cmp = x.getValue().compareTo(node.getValue());
            if (this.overwriteMode && cmp == 0) {
                T v = x.getValue();
                x.setValue(node.getValue());
                return v;
            } else if (cmp == 0) {
                // value exists,ignore this node
                return x.getValue();
            }

            setParent(node, x);
            if (cmp > 0) {
                x.setLeft(node);
            } else {
                x.setRight(node);
            }

            fixInsert(node);
            size.incrementAndGet();
        }

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

    private Node<T> findParentNode(Node<T> x) {
        Node<T> dataRoot = getRoot();
        Node<T> child = dataRoot;
        while (child != null) {
            int cmp = child.getValue().compareTo(x.getValue());
            if (cmp == 0) {
                return child;
            }
            if (cmp > 0) {
                dataRoot = child;
                child = child.getLeft();
            } else if (cmp < 0) {
                dataRoot = child;
                child = child.getRight();
            }
        }
        return dataRoot;
    }

    private void fixInsert(Node<T> node) {
        Node<T> parent = node.getParent();
        while (parent != null && parent.isRed()) {
            Node<T> uncle = getUncle(node);
            if (uncle == null) {// need to rotate
                Node<T> ancestor = parent.getParent();

                if (parent == ancestor.getLeft()) {
                    boolean isRight = (node == parent.getRight());
                    if (isRight) {
                        rotateLeft(parent);
                    }
                    rotateRight(ancestor);

                    if (isRight) {
                        node.setRed(false);
                        parent = null;
                    } else {
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                } else {
                    boolean isLeft = (node == parent.getLeft());
                    if (isLeft) {
                        rotateRight(parent);
                    }

                    rotateLeft(ancestor);
                    if (isLeft) {
                        node.setRed(false);
                        parent = null;
                    } else {
                        parent.setRed(false);
                    }
                    ancestor.setRed(true);
                }

            } else { // uncle is red
                parent.setRed(false);
                uncle.setRed(false);
                parent.getParent().setRed(true);
                node = parent.getParent();
                parent = node.getParent();
            }
        }

        getRoot().makeBlack();
        getRoot().setParent(null);
    }

    private Node<T> getSibling(Node<T> node, Node<T> parent) {
        parent = node == null ? parent : node.getParent();
        if (node == null) {
            return parent.getLeft() == null ? parent.getRight() : parent.getLeft();
        }

        if (node == parent.getLeft()) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    private Node<T> getUncle(Node<T> node) {
        Node<T> parent = node.getParent();
        Node<T> ancestor = parent.getParent();
        if (ancestor == null) {
            return null;
        }
        if (parent == ancestor.getLeft()) {
            return ancestor.getRight();
        } else {
            return ancestor.getLeft();
        }
    }

    private void rotateLeft(Node<T> node) {
        Node<T> right = node.getRight();
        if (right == null) {
            throw new java.lang.IllegalStateException("right node is null");
        }

        Node<T> parent = node.getParent();
        node.setRight(node.getLeft());
        setParent(right.getLeft(), node);


        right.setLeft(node);
        setParent(node, right);

        if (parent == null) {//node pointer to root
            //right  raise to root node
            root.setLeft(right);
            setParent(right, null);
        } else {
            if (parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            setParent(right, parent);
        }
    }

    private void rotateRight(Node<T> node) {

    }

    private boolean isBlack(Node<T> node) {
        return node == null || node.isBlack();
    }

    private boolean isRoot(Node<T> node) {
        return root.getLeft() == node && node.getParent() == null;
    }

    private Node<T> removeMin(Node<T> node) {
        Node<T> parent = node;
        while (node != null && node.getLeft() != null) {
            parent = node;
            node = node.getLeft();
        }

        if (parent == node) {
            return node;
        }

        parent.setLeft(node.getRight());
        setParent(node.getRight(), parent);
        //don't remove right pointer,it is used for fixed color balance
        //node.setRight(null);
        return node;
    }

    private void setParent(Node<T> node, Node<T> parent) {
        if (node != null) {
            node.setParent(parent);
            if (parent == this.root) {
                node.setParent(null);
            }
        }
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

        public void setRed(boolean red) {
            this.red = red;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public void setLeft(Node<T> node) {
            this.left = node;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public void setRight(Node<T> node) {
            this.right = node;
        }

        public Node<T> getParent() {
            return this.parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public void setValue(T value) {
            this.value = value;
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
