package com.spacex.data.structure.stack;

import com.spacex.data.structure.stack.exception.EmptyStackException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class JdkDequeCustomStack<E> implements CustomStack<E> {

    private int top = -1;
    private Deque<E> deque;

    public JdkDequeCustomStack() {
        this.deque = new ArrayDeque<>();
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean push(E item) {
        deque.push(item);
        this.top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("pop an empty stack!");
        }
        this.top--;
        return deque.pop();
    }

    @Override
    public E peek() {
        return deque.peek();
    }

    @Override
    public int search(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        deque.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return deque.iterator();
    }
}
