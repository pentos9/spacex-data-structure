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
        if (element == null) {
            return -1;
        }

        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.heap[i])) {
                return i;
            }
        }
        return -1;
    }

    private int indexOf2(T element) {
        int start = 0;
        int node = 1;
        while (start < this.size) {
            start = node - 1;
            int end = start + node;
            int count = 0;

            while (start < this.size && start < end) {
                if (start == 0) {
                    if (element.compareTo(this.heap[start]) == 0) {
                        return start;
                    } else if (element.compareTo(this.heap[start]) < 0) {
                        return -1;
                    }
                } else {
                    if (element.compareTo(this.heap[start]) == 0) {
                        return start;
                    } else if (element.compareTo(this.heap[start]) < 0
                            && element.compareTo(this.heap[getParent(start)]) > 0) {
                        count++;
                    }
                }
                start++;
            }

            if (start == node) {
                return -1;
            } else {
                node = node * 2;
            }
        }
        return -1;
    }

    private void removeInternal(int index) {
        //
        this.heap[index] = this.heap[--index];
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        while (left < this.size && (
                this.heap[index].compareTo(this.heap[left]) > 0 ||
                        this.heap[index].compareTo(this.heap[left]) < 0)) {

            if (this.heap[left].compareTo(this.heap[right]) < 0) {
                swap(index, left);
                index = left;
            } else {
                swap(index, right);
                index = right;
            }

            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public void printPreOrder() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.heap[i]);
        }

    }
}
