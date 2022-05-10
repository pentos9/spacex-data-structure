package com.spacex.data.structure.heap;

import java.util.NoSuchElementException;

public class SimpleHeap {

    private static final int d = 2;//
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

    /**
     * @param index
     * @param k
     * @return
     */
    private int kthChild(int index, int k) {
        return d * index + k;
    }

    public boolean isLeaf(int index) {
        if (index >= this.size / 2 && index <= this.size) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
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
        int child;
        int temp = this.heap[index];
        while (kthChild(index, 1) < this.size) {
            child = maxChild(index);
            if (temp < this.heap[child]) {
                this.heap[index] = this.heap[child];
            } else {
                break;
            }
            index = child;
        }

        this.heap[index] = temp;
    }

    private int maxChild(int index) {
        int leftChild = kthChild(index, 1);
        int rightChild = kthChild(index, 2);
        return this.heap[leftChild] > this.heap[rightChild] ? leftChild : rightChild;
    }

    public int findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("heap is empty");
        }
        return this.heap[0];
    }

    public void printHeap() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

}
