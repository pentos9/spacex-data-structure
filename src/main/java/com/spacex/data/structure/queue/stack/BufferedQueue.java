package com.spacex.data.structure.queue.stack;

import java.util.Stack;

public class BufferedQueue<E> implements IQueue<E> {
    private Stack<E> storeStack;
    private Stack<E> bufferStack;

    public BufferedQueue() {
        this.storeStack = new Stack<>();
        this.bufferStack = new Stack<>();
    }

    @Override
    public void enQueue(E element) {
        this.storeStack.push(element);
    }

    @Override
    public E deQueue() {
        if (this.storeStack.isEmpty()) {
            return null;
        }

        while (!this.storeStack.isEmpty()) {
            E item = this.storeStack.pop();
            this.bufferStack.push(item);
        }

        E head = this.bufferStack.pop();
        // refill store stack
        refillStack(bufferStack, storeStack);
        return head;
    }

    private void refillStack(Stack<E> fromStack, Stack<E> toStack) {
        while (!fromStack.isEmpty()) {
            E item = fromStack.pop();
            toStack.push(item);
        }
    }

    @Override
    public int size() {
        return this.storeStack.size();
    }
}
