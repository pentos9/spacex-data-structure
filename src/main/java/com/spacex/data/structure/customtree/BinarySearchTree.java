package com.spacex.data.structure.customtree;

import java.util.LinkedList;
import java.util.Queue;
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

    public int height() {
        return height(this.root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
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

    public boolean contains(T data) {
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

    public void preOrderTraverse() {
        preOrderTraverse(this.root);
    }

    private void preOrderTraverse(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.data);
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void preOrderNonRecursiveTraverse() {
        this.preOrderNonRecursiveTraverse(this.root);
    }

    private void preOrderNonRecursiveTraverse(Node<T> root) {
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

    public void inOrderTraverse() {
        this.inOrderTraverse(this.root);
    }

    private void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(" " + node.data);
            inOrderTraverse(node.right);
        }
    }

    public void inOrderNonRecursiveTraverse() {
        this.inOrderNonRecursiveTraverse(this.root);
    }

    private void inOrderNonRecursiveTraverse(Node<T> root) {
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


    public void postOrderTraverse() {
        this.postOrderTraverse(this.root);
    }

    private void postOrderTraverse(Node<T> node) {
        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(" " + node.data);
        }
    }

    public void postOrderNonRecursiveTraverse() {
        this.postOrderNonRecursiveTraverse(this.root);
    }

    private void postOrderNonRecursiveTraverse(Node<T> root) {
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
            System.out.print(" " + current.data);
        }
    }

    public void depthOrderTraverse() {
        this.depthOrderTraverse(this.root);
    }

    /**
     * 度优先遍历用的是栈，而广度优先遍历要用队列来实现
     *
     * @param root
     */
    private void depthOrderTraverse(Node<T> root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            System.out.print(" " + node.data);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void bfs() {
        this.bfs(this.root);
    }

    /**
     * 度优先遍历用的是栈，而广度优先遍历要用队列来实现
     *
     * @param root
     */
    private void bfs(Node<T> root) {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(" " + node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
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
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                Node<T> successor = successor(root);
                root.data = (successor == null ? null : successor.data);
                root.right = delete(root.right, root.data);
            } else {
                Node<T> predecessor = predecessor(root);
                root.data = (predecessor == null ? null : predecessor.data);
                root.left = delete(root.left, root.data);
            }
        }

        return root;
    }

    private Node<T> successor(Node<T> root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node<T> predecessor(Node<T> root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node<T> search(T data) {
        return null;
    }
}
