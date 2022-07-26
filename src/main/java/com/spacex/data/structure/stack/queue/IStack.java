package com.spacex.data.structure.stack.queue;

public interface IStack<E> {
    void push(E item);

    E pop();

    int size();
}
