package com.spacex.data.structure.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BufferedStack<E> implements IStack<E> {

    private Queue<E> storeQueue;
    private Queue<E> bufferQueue;

    public BufferedStack() {
        this.storeQueue = new LinkedList<>();
        this.bufferQueue = new LinkedList<>();
    }

    @Override
    public void push(E item) {
        this.storeQueue.offer(item);
    }

    @Override
    public E pop() {
        if (this.storeQueue.isEmpty()) {
            return null;
        }

        // move item to buffered queue util storeQueue.size == 1
        refill(this.storeQueue, this.bufferQueue, 1);
        E lastItem = this.storeQueue.poll();// this is stack top

        // return items to storeQueue
        refill(this.bufferQueue, this.storeQueue);
        return lastItem;
    }

    /**
     * refill item from fromQueue to toQueue,and retain retainSize elements
     *
     * @param fromQueue
     * @param toQueue
     * @param retainSize
     */
    private void refill(Queue<E> fromQueue, Queue<E> toQueue, int retainSize) {
        while (fromQueue.size() != retainSize) {
            E item = fromQueue.poll();
            toQueue.offer(item);
        }
    }

    /**
     * refill all item to new toQueue
     *
     * @param fromQueue
     * @param toQueue
     */
    private void refill(Queue<E> fromQueue, Queue<E> toQueue) {
        refill(fromQueue, toQueue, 0);
    }

    @Override
    public int size() {
        return this.storeQueue.size();
    }
}
