package com.spacex.data.structure.list;

import java.util.Arrays;

public class CustomArrayList<E> implements CustomList<E> {

    private E[] elements;
    private int size;

    public CustomArrayList() {
        this(10);
    }

    public CustomArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("illegal size:" + initSize);
        }
        this.elements = (E[]) new Object[initSize];
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
        if (index < 0 || index >= (this.size + 1)) {
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
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) {
                    fastRemove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    fastRemove(i);
                    return;
                }
            }
        }
    }

    private void fastRemove(int index) {
        int movedNumber = this.size - index - 1;
        if (movedNumber > 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, movedNumber);
        }
        this.elements[--this.size] = null;
    }

    @Override
    public E get(int index) {
        E e = this.elements[index];
        return e;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        this.elements[index] = element;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) {
            for (E e : this.elements) {
                if (e == null) {
                    return true;
                }
            }
        } else {
            for (E e : this.elements) {
                if (element.equals(e)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void clear() {
        this.elements = null;
        this.size = 0;
    }

    @Override
    public E[] toArray(E[] a) {
        return this.elements;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
