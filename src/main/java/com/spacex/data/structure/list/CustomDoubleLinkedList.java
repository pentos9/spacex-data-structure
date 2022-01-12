package com.spacex.data.structure.list;

import java.util.Iterator;

public class CustomDoubleLinkedList<T> implements CustomList<T> {

    // 双向链表也叫双链表，是链表的一种，链表的每个数据结点中都有两个指针，分别指向直接后继和直接前驱，
    // 从双向链表中的任意一个结点开始，都可以很快速地访问它的前驱结点和后继结点，
    // 链表结构的使用多数都是构造双向循环链表。

    private class Node<T> {// 双向链表结点
        private T data;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // double LinkedList
    private Node head = new Node();
    private Node tail = new Node();

    private int size;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean add(int index, T data) {
        if (index < 0 || index > this.size) {
            return false;
        }

        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            if (this.size == 0) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
        } else if (index == this.size) {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            Node<T> previous = this.getNode(index - 1);
            newNode.prev = previous;
            newNode.next = previous.next;
            previous.next.prev = newNode;
            previous.next = newNode;
        }
        this.size++;
        return true;
    }

    private Node getNode(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        int position = 0;
        Node current = this.head;
        while (position < index) {
            current = current.next;
            position++;
        }
        return current;
    }

    @Override
    public void remove(T element) {

    }

    public void removeByIndex(int index) {

    }

    @Override
    public T get(int index) {
        if (index < 0 || index < this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        Node<T> node = getNode(index);
        if (node == null) {
            return null;
        }
        return node.data;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public void set(int index, T element) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T[] toArray() {
        return (T[]) new Object[0];
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
