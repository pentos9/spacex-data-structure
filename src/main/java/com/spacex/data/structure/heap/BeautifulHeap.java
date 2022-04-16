package com.spacex.data.structure.heap;

public class BeautifulHeap<T extends Comparable> {
    private T[] elements;
    private int size;
    private int capacity;

    public BeautifulHeap() {
        this.size = 0;
        this.capacity = 0;
    }

    public int size() {
        return this.size;
    }

    private boolean isFull() {
        return this.size() >= this.capacity;
    }

    private boolean isEmpty() {
        return this.size() == 0;
    }

    private void buildHeap() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty,cannot handle buildHeap operation!");
        }

        for (int i = this.size / 2; i > 0; --i) {
            adjustHeap(i);
        }
    }

    private void adjustHeap(int root) {
        T parentValue = this.elements[root];

        int parentIndex = root;
        while (parentIndex * 2 <= this.size) {
            int childIndex = parentIndex * 2;
            if (childIndex != this.size && this.elements[childIndex].
                    compareTo(this.elements[childIndex + 1]) < 0) {
                childIndex++;
            }

            if (parentValue.compareTo(this.elements[childIndex]) > 0) {
                break;
            } else {
                this.elements[parentIndex] = this.elements[childIndex];
            }

            parentIndex = childIndex;
        }

        this.elements[parentIndex] = parentValue;
    }

    public void insert(T data) {

        if (data == null) {
            return;
        }

        if (isFull()) {
            throw new RuntimeException("heap is full,cannot insert item any more");
        }

        int nextIndex = ++this.size;

        while (this.elements[nextIndex / 2].compareTo(data) < 0) {
            this.elements[nextIndex] = this.elements[nextIndex / 2];
            nextIndex /= 2;
        }

        this.elements[nextIndex] = data;
    }

    public T deleteMaxElement() {
        if (isEmpty()) {
            throw new RuntimeException("heap is empty,cannot handle delete operation!");
        }

        T maxItem = this.elements[1];
        T lastItem = this.elements[this.size];

        int insertIndex = 1;

        while (insertIndex * 2 <= this.size) {
            int childIndex = insertIndex * 2;
            if (childIndex != this.size && this.elements[childIndex].compareTo(this.elements[childIndex + 1]) < 0) {
                childIndex++;
            }

            if (lastItem.compareTo(this.elements[childIndex]) > 0) {
                break;
            } else {
                this.elements[insertIndex] = this.elements[childIndex];
            }

            insertIndex = childIndex;
        }

        this.elements[insertIndex] = lastItem;
        return maxItem;
    }
}
