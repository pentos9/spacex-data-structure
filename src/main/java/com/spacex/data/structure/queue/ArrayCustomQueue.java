package com.spacex.data.structure.queue;

import java.util.Iterator;

public class ArrayCustomQueue<E> implements CustomQueue<E> {

    private E[] elementData;
    private int maxSize;
    private int size;
    private int front;
    private int rear;

    public ArrayCustomQueue(int maxSize) {
        this.elementData = (E[]) new Object[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
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
        return size() == this.maxSize;
    }

    @Override
    public boolean enQueue(E data) {
        if (isFull()) {
            return false;
        }

        if (rear == (maxSize - 1)) {
            rear = -1;
        }
        this.elementData[++this.rear] = data;
        this.size++;
        return true;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("deQueue failed,empty queue exception");
        }

        E item = this.elementData[front++];
        if (front == maxSize) {
            front = 0;
        }
        this.size--;
        return item;
    }

    private void fastRemoveFirst() {
        System.arraycopy(elementData, 1, this.elementData, 0, this.size - 1);
    }

    @Override
    public E peek() {
        E item = (E) this.elementData[front];
        return item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayCustomQueueIterator<>();
    }

    private class ArrayCustomQueueIterator<E> implements Iterator<E> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            E item = (E) elementData[cursor];
            cursor++;
            return item;
        }
    }
}
