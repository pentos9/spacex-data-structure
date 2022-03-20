package com.spacex.data.structure.heap;

import java.lang.reflect.Array;

public class MinHeap<T extends Comparable<T>> {
    public static final int INITIAL_SIZE = 16;
    private Class<T> type;
    private T[] heap;
    private int size;

    public MinHeap() {
        this.size = INITIAL_SIZE;
        this.heap = (T[]) Array.newInstance(type, INITIAL_SIZE);
    }

    public int size() {
        return this.size;
    }

    public void checkSize() {

    }

    public T getParent(int index) {
        return null;
    }

    public void insert(T value) {

    }

    public void clear() {

    }
}
