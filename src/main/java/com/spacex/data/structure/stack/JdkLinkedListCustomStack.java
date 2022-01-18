package com.spacex.data.structure.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JdkLinkedListCustomStack<E> implements CustomStack<E> {

    private int top;
    private List<E> list;

    public JdkLinkedListCustomStack() {
        this.top = -1;
        this.list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean push(E item) {
        list.add(item);
        this.top++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = list.remove(top);
        this.top--;
        return item;
    }

    @Override
    public E peek() {
        return list.get(top);
    }

    @Override
    public int search(Object o) {
        return list.indexOf(o);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
