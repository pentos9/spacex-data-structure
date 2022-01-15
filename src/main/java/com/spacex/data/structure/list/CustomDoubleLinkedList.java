package com.spacex.data.structure.list;

import java.util.Iterator;

public class CustomDoubleLinkedList<T> implements CustomList<T> {

    // 双向链表也叫双链表，是链表的一种，链表的每个数据结点中都有两个指针，分别指向直接后继和直接前驱，
    // 从双向链表中的任意一个结点开始，都可以很快速地访问它的前驱结点和后继结点，
    // 链表结构的使用多数都是构造双向循环链表。

    private class Node<T> {// 双向链表结点
        private T data;
        private Node<T> next;
        private Node<T> prev;

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
    private Node<T> head = new Node<>();
    private Node<T> tail = new Node<>();

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
        int index = indexOf(element);
        removeByIndex(index);
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= this.size) {
            return false;
        }

        Node node = this.head;
        if (index == 0) {
            if (this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head.next.prev = null;
                this.head = this.head.next;

            }
        } else if (index == (this.size - 1)) {
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        } else {
            Node previous = getNode(index - 1);
            previous.next = previous.next.next;
            previous.next.prev = previous;
        }
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size) {
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
        Node current = this.head;
        int position = 0;
        while (current != null) {
            if (element == null) {
                if (current.data == null) {
                    return position;
                }
            } else {
                if (element.equals(current.data)) {
                    return position;
                }
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    @Override
    public void set(int index, T data) {
        if (index < 0 || index > this.size) {
            return;
        }

        int position = 0;
        Node temp = this.head;
        while (position < index) {
            temp = temp.next;
            position++;
        }
        temp.data = data;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public void clear() {
        Node<T> current = this.head;
        while (current != null) {
            current.data = null;
            current = current.next;
        }
        this.head = null;
        this.size = 0;
    }

    @Override
    public Object[] toArray() {
        T[] result = (T[]) java.lang.reflect.Array.newInstance(this.get(0).getClass(), this.size);
        int position = 0;
        Node current = this.head;
        while (position < this.size) {
            result[position] = (T) current.data;
            current = current.next;
            position++;
        }
        return result;
    }

    public <T> T[] toArray(T[] array) {
        if (array.length < this.size) {
            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
        }

        int position = 0;
        Node current = this.head;
        while (position < this.size) {
            array[position] = (T) current.data;
            current = current.next;
            position++;
        }

        if (array.length > this.size) {
            array[this.size] = null;
        }
        return array;
    }

    @Override
    public Iterator iterator() {
        return new DoubleLinkedListIterator<>();
    }

    private class DoubleLinkedListIterator<T> implements Iterator<T> {
        private int step;

        @Override
        public boolean hasNext() {
            return step < size();
        }

        @Override
        public T next() {
            Node<T> node = getNode(step);
            step++;
            return node.data;
        }
    }
}
