package com.spacex.data.structure.queue;

import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayCustomBlockingQueue<E> implements BlockingQueue<E> {

    private E[] elementData;
    private int size;
    private int maxSize;
    private int front;
    private int rear;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    public ArrayCustomBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.elementData = (E[]) new Object[this.maxSize];
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
        lock.lock();
        try {
            while (this.size == this.elementData.length) {
                // queue is full, producers need to wait
                notFull.await();
            }

            if (this.rear == (maxSize - 1)) {
                this.rear = -1;
            }

            this.elementData[++this.rear] = data;
            this.size++;
            notEmpty.signal();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public E deQueue() {
        lock.lock();
        E item = null;
        try {
            while (this.size == 0) {
                notEmpty.await();
            }

            item = this.elementData[front++];
            if (this.front == (this.elementData.length)) {
                this.front = 0;
            }

            this.size--;
            notFull.signal();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } finally {
            lock.unlock();
        }
        return item;
    }

    @Override
    public E peek() {
        return this.elementData[front];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayCustomBlockingQueueIterator<>();
    }

    private class ArrayCustomBlockingQueueIterator<E> implements Iterator<E> {
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
