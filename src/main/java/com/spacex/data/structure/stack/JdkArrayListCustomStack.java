package com.spacex.data.structure.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JdkArrayListCustomStack<E> implements CustomStack<E> {

    private int top;
    private List<E> list;

    public JdkArrayListCustomStack() {
        this.top = -1;
        this.list = new ArrayList<>();
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean push(E item) {
        list.add(item);
        top++;
        return true;
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            return null;
        }
        E item = list.remove(top);
        top--;
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
        this.top = -1;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
