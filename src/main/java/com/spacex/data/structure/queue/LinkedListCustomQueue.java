package com.spacex.data.structure.queue;

import java.util.Iterator;

public class LinkedListCustomQueue<E> implements CustomQueue<E> {

    private class Node<E> {
        private E data;
        private Node<E> next;
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedListCustomQueue() {
        this.size = 0;
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
        return false;
    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
