package com.spacex.data.structure.bag;

import java.util.Collection;
import java.util.Iterator;

public class Bag<E> implements IBag<E> {

    private Node<E> first;
    private int size = 0;

    public Bag() {
        this.first = null;
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
    public boolean contains(Object o) {
        Node<E> head = this.first;
        Node<E> current = head;

        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new BagIterator<>();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        int position = 0;
        Node<E> current = this.first;
        while (position < this.size) {
            array[position] = current;
            current = current.next;
            position++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> oldFirst = this.first;
        Node<E> first = new Node<>(e);
        first.next = oldFirst;
        this.first = first;
        this.size++;
        return true;
    }

    private Node<E> getNode(int index) {
        int position = 0;
        Node<E> current = this.first;
        while (current != null) {
            if (position == index) {
                return current;
            }
            position++;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E item : collection) {
            if (item != null) {
                this.add(item);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation not supported!");
    }

    @Override
    public void clear() {
        this.first = null;
    }

    private class BagIterator<E> implements Iterator<E> {
        private int step = 0;

        @Override
        public boolean hasNext() {
            return step < size();
        }


        @Override
        public E next() {
            Node node = getNode(this.step);
            this.step++;
            return node == null ? null : (E) node.data;
        }
    }

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
