package com.spacex.data.structure.queue.circular;

public class CircleBuffer<E> {
    private static final int DEFAULT_CAPACITY = 8;
    private final int capacity;
    private E[] data;
    private volatile int writeSequence;
    private volatile int readSequence;

    public CircleBuffer(int capacity) {
        this.capacity = capacity < 1 ? DEFAULT_CAPACITY : capacity;
        this.data = (E[]) new Object[this.capacity];
        this.readSequence = 0;
        this.writeSequence = 0;
    }

    public boolean offer(E element) {
        if (isNotFull()) {
            int nextWriteSeq = this.writeSequence + 1;
            this.data[nextWriteSeq % capacity] = element;
            this.writeSequence++;
            return true;
        }
        return false;
    }

    public E poll() {
        return null;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return (writeSequence - readSequence) + 1;
    }

    public boolean isEmpty() {
        return writeSequence < readSequence;
    }

    public boolean isFull() {
        return size() >= capacity;
    }

    private boolean isNotEmpty() {
        return !isEmpty();
    }

    private boolean isNotFull() {
        return !isFull();
    }
}
