package com.spacex.data.structure.queue.circular;

import com.spacex.data.structure.queue.CustomQueue;

import java.util.Iterator;

public class ArrayCircleQueue<E> implements CustomQueue<E> {
    private E[] array;
    private int maxSize;
    private int rear;
    private int front;
    private int size;

    // 当front赶上rear，说明队列满，令flag=0；
    // 当rear赶上front，说明队列空，令flag=1
    //private int empty;

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
        return false;
    }

    @Override
    public E deQueue() {
        return null;
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
