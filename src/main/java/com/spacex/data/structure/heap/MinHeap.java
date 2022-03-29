package com.spacex.data.structure.heap;

import java.lang.reflect.Array;

public class MinHeap<T extends Comparable<T>> {
    public static final int INITIAL_SIZE = 16;
    private Class<T> type;
    private T[] heap;
    private int size;

    public MinHeap() {
    }

    public MinHeap(Class<T> type) {
        this.heap = (T[]) Array.newInstance(type, INITIAL_SIZE);
        this.type = type;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void checkSize() {
        if (this.size > this.heap.length / 2) {
            T[] newHeap = (T[]) Array.newInstance(type, INITIAL_SIZE * 2);
            System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
            this.heap = newHeap;
        }
    }

    public int getParent(int index) {
        return (index + 1) / 2 - 1;
    }

    public int getLeftChild(int index) {
        return (index + 1) * 2 - 1;
    }

    public int getRightChild(int index) {
        return (index + 1) * 2;
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

            buildHeap(parentIndex);
        }
    }

    private void swap(int a, int b) {
        T temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
    }

    public void clear() {
        this.heap = (T[]) Array.newInstance(type, INITIAL_SIZE);
        this.size = 0;
    }

    public T min() {
        return this.heap[0];
    }

    public int getElement(T item) {
        for (int i = 0; i < this.size; i++) {
            if (this.heap[i].equals(item)) {
                return i;
            }
        }
        return 0;
    }

    private boolean contains(T t) {
        for (int i = 0; i < this.size; i++) {
            if (this.heap[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    public T getParentElement(T t) {
        boolean exist = contains(t);
        int index = getElement(t);
        if (!exist) {
            return null;
        } else if (index == 0) {
            return this.heap[0];
        } else {
            return this.heap[index];
        }
    }

    public T getLeftChildElement(T t) {
        boolean exist = contains(t);
        int index = getElement(t);
        if (!exist) {
            return null;
        } else if (getLeftChild(index) >= this.size) {
            return null;
        } else {
            return this.heap[getLeftChild(index)];
        }
    }

    public T getRightChildElement(T t) {
        boolean exist = contains(t);
        int index = getElement(t);
        if (!exist) {
            return null;
        } else if (getRightChild(index) > this.size) {
            return null;
        } else {
            return this.heap[getRightChild(index)];
        }
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }

        removeInternal(index);
        return true;
    }

    private int indexOf(T element) {
        return 0;
    }

    private void removeInternal(int index) {

    }

    public void printPreOrder() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.heap[i]);
        }
    }
}
