package com.spacex.data.structure.queue.circular;

public class CircleBuffer<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private final int capacity;
    private E[] data;
    private volatile int writeSequence;
    private volatile int readSequence;

    public CircleBuffer(int capacity) {
        this.capacity = capacity;
    }

    public boolean offer(E element) {
        return true;
    }

    public E poll() {
        return null;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    private boolean isNotEmpty() {
        return !isEmpty();
    }

    private boolean isNotFull() {
        return !isFull();
    }
}
