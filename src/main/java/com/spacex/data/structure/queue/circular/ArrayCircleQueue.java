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
    private int empty;

    public ArrayCircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = (E[]) new Object[this.maxSize];
        this.front = 0;
        this.rear = 0;
        this.empty = 1;
    }

    @Override
    public int size() {
        if (this.rear > this.front) {
            return this.rear - this.front;
        }
        return this.rear + maxSize - this.front;
    }

    @Override
    public boolean isEmpty() {
        return (this.front == this.rear) && (this.empty == 1);
    }

    @Override
    public boolean isFull() {
        return this.front == this.rear && this.empty == 0;
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
