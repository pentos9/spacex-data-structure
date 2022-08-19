package com.spacex.data.structure.queue.circular;

import com.spacex.data.structure.queue.CustomQueue;

import java.util.Iterator;

public class ArrayCircleQueue<E> implements CustomQueue<E> {
    private E[] array;
    private int maxSize;
    private int rear;// 指向队列的最后一个元素的后一个位置，希望空出一个空间作为约定。初始值0
    private int front;// 指向队列的第一个元素，arr[front]就是队列的第一个元素。初始值0

    /**
     * 因此，环形队列是逻辑上将数组元素array[0]和array[maxSize - 1]连接，
     * 形成一个存放队列的环形空间。
     *
     * @param maxSize
     */
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
        return new ArrayCircleQueueIterator<>();
    }

    private class ArrayCircleQueueIterator<E> implements Iterator<E> {
        private int step;

        @Override
        public boolean hasNext() {
            return size() == step;
        }

        @Override
        public E next() {
            E element = (E) ArrayCircleQueue.this.array[step];
            step++;
            return element;
        }
    }
}
