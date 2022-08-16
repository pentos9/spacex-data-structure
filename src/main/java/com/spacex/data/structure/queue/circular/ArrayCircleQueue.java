package com.spacex.data.structure.queue.circular;

import com.spacex.data.structure.queue.CustomQueue;

import java.util.Iterator;

public class ArrayCircleQueue<E> implements CustomQueue<E> {
    private E[] array;
    private int maxSize;
    private int rear;
    private int front;

    public ArrayCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = (E[]) new Object[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public int size() {
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public boolean isFull() {
        return (this.rear + 1) % maxSize == this.front;
    }

    @Override
    public boolean enQueue(E data) {
        if (isFull()) {
            System.out.println("queue is full!");
            return false;
        }
        this.array[this.rear] = data;
        this.rear = (this.rear + 1) % this.maxSize;
        return true;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        E frontElement = this.array[this.front];
        this.front = (this.front + 1) % this.maxSize;
        return frontElement;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        return this.array[this.front];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
