package com.spacex.data.structure.heap;

import java.lang.reflect.Array;

public class MinHeap<T extends Comparable<T>> {
    public static final int INITIAL_SIZE = 16;
    private Class<T> type;
    private T[] heap;
    private int size;

    public MinHeap() {
        this.size = INITIAL_SIZE;
        this.heap = (T[]) new Object[INITIAL_SIZE];
    }

    public int size() {
        return this.size;
    }

    public void checkSize() {
        if (this.size > this.heap.length / 2) {
            T[] newHeap = (T[]) Array.newInstance(type, INITIAL_SIZE * 2);
            System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
            this.heap = newHeap;
        }
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public void insert(T value) {
        checkSize();
        this.heap[this.size] = value;
        buildHeap(this.size);
        this.size++;
    }

    private void buildHeap(int index) {
        if (index > 0) {
            int parentIndex = getParent(index);
            T parent = this.heap[parentIndex];
            if (this.heap[index].compareTo(parent) < 0) {
                swap(index, parentIndex);
            }

            buildHeap(index);
        }
    }

    private void swap(int a, int b) {
        T temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }

    public void clear() {

    }
}
