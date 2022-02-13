package com.spacex.data.structure.customtree;

import java.util.Stack;

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
        return this.root == null;
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node<T> node) {
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

    public void preOrderNonRecursiveTraverse(Node<T> root) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> tNode = root;
        while (tNode != null || !stack.isEmpty()) {
            if (tNode != null) {
                System.out.print(tNode.data + " ");
                stack.push(tNode);
                tNode = tNode.left;
            } else { // tNode == null && !stack.isEmpty()
                Node<T> node = stack.pop();
                tNode = node.right;
            }
        }

    }

    public void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(" " + node.data);
            inOrderTraverse(node.right);
        }
    }

    public void inOrderNonRecursiveTraverse(Node<T> root) {
        if (root != null) {
            Stack<Node<T>> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.data);
                    root = root.right;
                }
            }
        }
    }

    public void postOrderTraverse(Node<T> node) {
        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(" " + node.data);
        }
    }

    public void postOrderNonRecursiveTraverse(Node<T> root) {
        if (root == null) {
            return;
        }

        Stack<Node<T>> s1 = new Stack<>();
        Stack<Node<T>> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node<T> current = s1.pop();
            s2.push(current);
            if (current.left != null) {
                s1.push(current.left);
            }

            if (current.right != null) {
                s1.push(current.right);
            }
        }

        while (!s2.isEmpty()) {
            Node<T> current = s2.pop();
            System.out.println(current.data);
        }
    }


    public void delete(T data) {
        this.delete(this.root, data);
    }

    private Node<T> delete(Node<T> root, T key) {
        // 1. Find the node to be deleted
        // 2. Remove it and replace it with its successor/predecessor and update the BST.

        if (root == null) {
            return root;
        }

        if (key.compareTo(root.data) > 0) {
            root.right = delete(root.right, key);
        } else if (key.compareTo(root.data) < 0) {
            root.left = delete(root.left, key);
        } else {// found the target

        }

        return root;
    }

    private Node<T> successor(Node<T> root) {
        return null;
    }

    private Node<T> predecessor(Node<T> root) {
        return null;
    }

    public Node<T> search(T data) {
        return null;
    }
}
