package com.spacex.data.structure.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class JdkLinkedListCustomQueue<E> implements CustomQueue<E> {

    private int size;
    private LinkedList<E> list;

    public JdkLinkedListCustomQueue() {
        this.size = 0;
        this.list = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean enQueue(E data) {
        this.list.addLast(data);
        this.size++;
        return true;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("deQueue failed, queue is empty!");
        }
        return this.list.removeLast();
    }

    @Override
    public E peek() {
        return this.list.peek();
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
