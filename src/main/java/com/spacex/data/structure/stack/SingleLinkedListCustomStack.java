package com.spacex.data.structure.stack;

import com.spacex.data.structure.stack.exception.EmptyStackException;

import java.util.Iterator;

public class SingleLinkedListCustomStack<E> implements CustomStack<E> {

    private class Node<E> {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private int size;
    private Node top;

    public SingleLinkedListCustomStack() {
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("pop an empty stack!");
            //return null;
        }

        Node<E> currentTop = this.top;
        this.top = currentTop.next;
        this.size--;
        return currentTop.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException("stack is empty!");
        }

        Node<E> currentTop = this.top;
        return currentTop.data;
    }

    @Override
    public int search(Object o) {
        Node<E> current = this.top;
        int position = 0;
        while (current != null) {
            if (o == null) {
                if (current.data == null) {
                    return position;
                }
            } else {
                if (o.equals(current.data)) {
                    return position;
                }
            }
            position++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.top = null;
    }

    private Node getNode(int index) {
        if (index >= size) {
            return null;
        }

        int position = 0;
        Node<E> current = this.top;
        while (position < this.size) {
            if (position == index) {
                return current;
            }
            current = current.next;
            position++;
        }
        return null;
    }


    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<>();
    }

    private class CustomIterator<E> implements Iterator<E> {

        private int step;

        @Override
        public boolean hasNext() {
            this.step++;
            return this.step < size();
        }

        @Override
        public E next() {
            Node<E> item = getNode(step);
            if (item == null) {
                return null;
            }
            return item.data;
        }
    }
}
