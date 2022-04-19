package com.spacex.data.structure.heap;

import java.util.NoSuchElementException;

public class SimpleHeap {
    private int[] heap;
    private int size;

    public SimpleHeap(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private int getRightChild(int index) {
        return 2 * index + 2;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.heap.length;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("heap is full");
        }

        this.heap[this.size] = value;
        shiftUp(this.size);
        this.size++;
    }

    private void shiftUp(int index) {
        int newValue = this.heap[index];

        while (index > 0 && newValue > this.heap[getParent(index)]) {
            this.heap[index] = this.heap[getParent(index)];
            index = getParent(index);
        }

        this.heap[index] = newValue;
    }

    /**
     * This will delete element at index x
     * Complexity: O(log N)
     */
    public int delete(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty,no space tp insert new element");
        }

        int key = this.heap[index];
        this.heap[index] = this.heap[this.size - 1];
        this.size--;
        shiftDown(index);
        return key;
    }

    private void shiftDown(int index) {

    }
}
