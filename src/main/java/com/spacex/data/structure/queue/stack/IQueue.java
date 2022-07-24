package com.spacex.data.structure.queue.stack;

public interface IQueue<E> {
    void enQueue(E element);

    E deQueue();

    int size();
}
