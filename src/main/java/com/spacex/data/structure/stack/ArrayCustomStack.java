package com.spacex.data.structure.stack;

import com.spacex.data.structure.stack.exception.StackOverFlowException;

import java.util.Iterator;

public class ArrayCustomStack<E> implements CustomStack<E> {

    private static final int DEFAULT_MAX_SIZE = 64;
    private E[] elementData;
    private int top;
    private int maxSize;

    public ArrayCustomStack() {
        this(DEFAULT_MAX_SIZE);
    }

    public ArrayCustomStack(int size) {
        this.elementData = (E[]) new Object[size];
        this.top = -1;
        this.maxSize = size;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public boolean push(E item) {
        ensureCapacity(this.size() + 1);
        this.elementData[++top] = item;
        return true;
    }

    private void ensureCapacity(int currentSize) {
        if (currentSize > this.maxSize) {
            throw new StackOverFlowException("overflow exception");
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = this.elementData[top];
        this.elementData[top--] = null;
        return item;
    }

    @Override
    public E peek() {
        return this.elementData[top];
    }

    @Override
    public int search(Object object) {
        return indexOf(object, 0);
    }

    private int indexOf(Object o, int startIndex) {
        if (o == null) {
            for (int i = startIndex; i < size(); i++) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i < size(); i++) {
                if (o.equals(this.elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.elementData.length; i++) {
            this.elementData[i] = null;
        }
        this.top = -1;
    }

    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator<>();
    }

    private class ArrayStackIterator<E> implements Iterator<E> {

        private int step = 0;

        @Override
        public boolean hasNext() {
            return step < size();
        }

        @Override
        public E next() {
            E item = (E) ArrayCustomStack.this.elementData[step++];
            return item;
        }
    }
}
