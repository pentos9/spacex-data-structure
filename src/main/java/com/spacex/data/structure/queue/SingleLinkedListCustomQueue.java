package com.spacex.data.structure.queue;

import java.util.Iterator;

public class SingleLinkedListCustomQueue<E> implements CustomQueue<E> {

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public SingleLinkedListCustomQueue() {
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean enQueue(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            this.front = node;
        } else {
            this.rear.next = node;
        }

        this.rear = node;
        this.size++;
        return true;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("deQueue failed,empty queue exception!");
        }
        E result = front.data;
        this.size--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("peek() failed,the queue is empty!");
        }
        return front.data;
    }

    private Node getNode(int index) {
        int position = 0;
        Node<E> current = this.front;
        while (this.front != null) {
            if (position == index) {
                return current;
            }
            position++;
            current = current.next;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListCustomQueueIterator<>();
    }

    private class LinkedListCustomQueueIterator<E> implements Iterator<E> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            Node<E> node = getNode(cursor);
            this.cursor++;
            return (node == null) ? null : node.data;
        }
    }
}
