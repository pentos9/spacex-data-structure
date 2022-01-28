package com.spacex.data.structure.customtree;

public class BinarySearchTree<T extends Comparable> {

    private class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }

    }

    private Node<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(this.root);
    }

    public int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    public void add(T data) {
        this.root = add(this.root, data);
    }

    private Node<T> add(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = add(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = add(current.right, data);
        } else {
            current.data = data;
            return current;
        }
        return current;
    }

    public boolean conntains(T data) {
        return contains(this.root, data);
    }

    private boolean contains(Node<T> current, T data) {
        if (current == null) {
            return false;
        }

        if (current.data.equals(data)) {
            return true;
        }
        return data.compareTo(current.data) < 0 ?
                contains(current.left, data) :
                contains(current.right, data);
    }

    public void preOrderTraverse(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.data);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(" " + node.data);
            inOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node<T> node) {
        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(" " + node.data);
        }
    }

    public void delete(T data) {

    }
}
