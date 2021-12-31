package com.spacex.data.structure.list;

import java.util.Arrays;

public class CustomArrayList<E> implements CustomList<E> {

    private E[] elements;
    private int size;

    public CustomArrayList() {
        this(10);
    }

    public CustomArrayList(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void ensureCapacity(int needCapacity) {
        if (needCapacity > elements.length) {
            Object[] oldElements = this.elements;
            int newSize = this.size * 2 + 1;
            this.elements = (E[]) new Object[newSize];
            this.elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(this.size + 1);
        elements[this.size++] = element;
        return true;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
    }

    @Override
    public boolean add(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        System.arraycopy(this.elements, index, elements, index + 1, size - index);
        elements[index] = element;
        this.size++;
        return true;
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public E get(int index) {
        E e = this.elements[index];
        return e;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void clear() {
        this.elements = null;
        this.size = 0;
    }

    @Override
    public E[] toArray(E[] a) {
        return null;
    }
}
