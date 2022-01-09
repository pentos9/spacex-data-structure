package com.spacex.data.structure.list;

import java.util.Iterator;

public class CustomSingleLinkedList<T> implements CustomList<T> {

    //单向链表是链表的一种，其特点是链表的链接方向是单向的，链表的遍历要从头部开始顺序读取；
    // 结点构成，head指针指向第一个成为表头结点，终止于最后一个指向NULL的指针。

    private class Node {// 单向链表结点
        private T data;
        private Node next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private int size = 0;

    public CustomSingleLinkedList() {
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(T element) {
        Node newNode = new Node(element);

        // 头结点为空，则该原始第一个元素，该节点为头结点
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        this.size++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        Node newNode = new Node(element);

        if (index == 0) {
            Node temp = this.head;
            this.head = newNode;
            this.head.next = temp;
        } else {
            Node previous = this.getNode(index - 1);
            Node temp = previous.next;//current
            if (temp != null) {
                newNode.next = temp.next;
            }
            previous.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public void remove(T element) {
        int index = indexOf(element);
        this.removeByIndex(index);
    }

    public void removeByIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        if (this.head == null) {//如果链表为空，则什么都不做
            return;
        }

        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node previous = getNode(index - 1);
            previous.next = previous.next.next;
        }
        this.size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        Node current = this.head;
        int currentPosition = 0;
        while (currentPosition < index) {
            current = current.next;
            currentPosition++;
        }
        return current;
    }

    @Override
    public T get(int index) {//根据位置返回元素
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("illegal argument index:" + index);
        }

        Node node = getNode(index);
        return node.data;
    }

    @Override
    public int indexOf(T element) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (element == null) {
                if (current.data == null) {
                    return index;
                }
            } else {
                if (element.equals(current.data)) {
                    return index;
                }
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("illegal index:" + index + ",current size:" + this.size);
        }

        Node temp = this.head;
        int position = 0;
        while (position < index) {
            temp = temp.next;
            position++;
        }
        temp.data = element;
    }

    @Override
    public boolean contains(T element) {
        int index = indexOf(element);
        return index != -1;
    }

    @Override
    public void clear() {
        Node temp = this.head;
        while (temp != null) {
            temp.data = null;
            temp = temp.next;
        }
        this.head = null;
        this.size = 0;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[this.size];
        Node temp = this.head;
        int position = 0;
        while (position < this.size) {
            result[position] = temp.data;
            temp = temp.next;
            position++;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<>();
    }

    private class SingleLinkedListIterator<T> implements Iterator<T> {
        private int step = 0;

        @Override
        public boolean hasNext() {
            return this.step < size();
        }

        @Override
        public T next() {
            Node node = getNode(step);
            step++;
            return (T) node.data;
        }
    }
}
