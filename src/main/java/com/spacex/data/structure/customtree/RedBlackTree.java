package com.spacex.data.structure.customtree;

import java.util.LinkedList;
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

    public int height() {
        return this.height(this.root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + height(node.getLeft()) + height(node.getRight());
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

        if (root.getLeft() == null) {
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
        Node<T> dataRoot = getRoot();
        Node<T> parent = root;
        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp < 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            } else if (cmp > 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            } else {
                if (dataRoot.getRight() != null) {
                    Node<T> min = removeMin(dataRoot.getRight());
                    // x for color balance
                    Node<T> x = (min.getRight() == null ? min.getParent() : min.getRight());
                    boolean isParent = (min.getRight() == null);

                    min.setLeft(dataRoot.getLeft());
                    setParent(dataRoot.getLeft(), min);
                    if (parent.getLeft() == dataRoot) {
                        parent.setLeft(min);
                    } else {
                        parent.setRight(min);
                    }
                    setParent(min, parent);

                    boolean currentMinIsBlack = min.isBlack();
                    //inherit data root's color
                    min.setRed(dataRoot.isRed());

                    if (min != dataRoot.getRight()) {
                        min.setRight(dataRoot.getRight());
                        setParent(dataRoot.getRight(), min);
                    }

                    // remove a black node,need to fix color
                    if (currentMinIsBlack) {
                        if (min != dataRoot.getRight()) {
                            fixRemove(x, isParent);
                        } else if (min.getRight() != null) {
                            fixRemove(min.getRight(), false);
                        } else {
                            fixRemove(min, true);
                        }
                    }
                } else {
                    setParent(dataRoot.getLeft(), parent);
                    if (parent.getLeft() == dataRoot) {
                        parent.setLeft(dataRoot.getLeft());
                    } else {
                        parent.setRight(dataRoot.getLeft());
                    }

                    // current node is black and tree is not empty
                    if (dataRoot.isBlack() && !(dataRoot.getLeft() == null)) {
                        Node<T> x = (dataRoot.getLeft() == null ?
                                parent : dataRoot.getLeft());
                        boolean isParent = dataRoot.getLeft() == null;
                        fixRemove(x, isParent);
                    }
                }

                setParent(dataRoot, null);
                dataRoot.setLeft(null);
                dataRoot.setRight(null);
                if (getRoot() != null) {
                    getRoot().setRed(false);
                    getRoot().setParent(null);
                }

                size.decrementAndGet();
                return dataRoot.getValue();
            }
        }
        return null;
    }

    private void fixRemove(Node<T> node, boolean isParent) {
        Node<T> current = isParent ? null : node;
        boolean isRed = (isParent ? false : node.isRed());
        Node<T> parent = isParent ? node : node.getParent();
        while (!isRed && !isRoot(current)) {
            Node<T> sibling = getSibling(current, parent);

            //if current is a left node
            boolean isLeft = (node.getRight() == sibling);
            if (sibling.isRed() && !isLeft) {//case 1
                parent.makeRed();
                sibling.makeBlack();
                rotateRight(parent);
            } else if (sibling.isRed() && isLeft) {
                //cur in red
                parent.makeRed();
                sibling.makeBlack();
                rotateLeft(parent);
            } else if (isBlack(sibling.getLeft()) && isBlack(parent.getRight())) {// case 2
                sibling.makeRed();
                current = parent;
                isRed = current.isRed();
                parent = parent.getParent();
            } else if (isLeft && !isBlack(sibling.getLeft()) && isBlack(sibling.getRight())) {//case 3
                sibling.makeRed();
                sibling.getLeft().makeBlack();
                rotateRight(sibling);
            } else if (!isLeft && !isBlack(sibling.getRight()) && isBlack(sibling.getLeft())) {
                sibling.makeRed();
                sibling.getRight().makeBlack();
                rotateLeft(sibling);
            } else if (isLeft && !isBlack(sibling.getRight())) {//case 4
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getRight().makeBlack();
                rotateLeft(parent);
                current = getRoot();
            } else if (!isLeft && !isBlack(sibling.getLeft())) {
                sibling.setRed(parent.isRed());
                parent.makeBlack();
                sibling.getLeft().makeBlack();
                rotateRight(parent);
                current = getRoot();
            }
        }

        if (isRed) {
            current.makeBlack();
        }
        if (getRoot() != null) {
            getRoot().setRed(false);
            getRoot().setParent(null);
        }
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
        Node<T> left = node.getLeft();
        if (left == null) {
            throw new java.lang.IllegalStateException("left node is null");
        }

        Node<T> parent = node.getParent();
        node.setLeft(left.getRight());
        setParent(left.getRight(), node);

        left.setRight(node);
        setParent(node, left);

        if (parent == null) {
            root.setLeft(left);
            setParent(left, null);
        } else {
            if (parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            setParent(left, parent);
        }
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

    public void printTree() {
        this.printTree(this.root);
    }

    private void printTree(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> queue2 = new LinkedList<>();
        if (root == null) {
            return;
        }

        queue.add(root);
        boolean firstQueue = true;

        while (!queue.isEmpty() || !queue2.isEmpty()) {
            LinkedList<Node> q = firstQueue ? queue : queue2;
            Node<T> n = q.poll();
            if (n != null) {
                String pos = (n.getParent() == null ? "" : (n == n.getParent().getLeft() ? " LE" : " RI"));
                String parentStr = (n.getParent() == null ? "" : n.getParent().toString());
                String colorStr = n.isRed() ? "R" : "B";
                colorStr = (n.getParent() == null ? colorStr : colorStr + " ");
                System.out.print(n + "(" + (colorStr) + parentStr + (pos) + ")" + "\t");
                if (n.getLeft() != null) {
                    (firstQueue ? queue2 : queue).add(n.getLeft());
                }
                if (n.getRight() != null) {
                    (firstQueue ? queue2 : queue).add(n.getRight());
                }
            } else {
                System.out.println();
                firstQueue = !firstQueue;
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

        @Override
        public String toString() {
            return this.value == null ? "null" : this.value.toString();
        }
    }
}
