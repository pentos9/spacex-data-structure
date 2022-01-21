package com.spacex.data.structure.queue;

public interface CustomQueue<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean isFull();

    boolean enQueue(E data);

    E deQueue();

    E peek();
}
