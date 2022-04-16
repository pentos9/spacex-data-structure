package com.spacex.data.structure.heap;

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
}
