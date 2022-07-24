package com.spacex.data.structure.queue.stack;

import java.util.Stack;

public class FastBufferedQueue<E> implements IQueue<E> {

    private Stack<E> storeStack;
    private Stack<E> bufferedStack;

    public FastBufferedQueue() {
        this.storeStack = new Stack<>();
        this.bufferedStack = new Stack<>();
    }

    @Override
    public void enQueue(E element) {
        if (!this.storeStack.isEmpty()) {
            this.storeStack.push(element);
        } else {
            if (!this.bufferedStack.isEmpty()) {
                E top = this.bufferedStack.pop();
                this.storeStack.push(top);
            }
            this.storeStack.push(element);
        }
    }

    /**
     * 出队时判断bufferedStack是否为空：
     * 若不为空，则直接弹出栈顶元素；
     * 若为空，则将storeStack的元素全部往bufferedStack'倒'，并把最后一个元素弹出并返回，出队；
     *
     * @return
     */
    @Override
    public E deQueue() {
        if (!this.bufferedStack.isEmpty()) {
            return this.bufferedStack.pop();
        }

        while (!this.storeStack.isEmpty()) {
            E item = this.storeStack.pop();
            this.bufferedStack.push(item);
        }

        E firstElementOfQueue = safePop(this.bufferedStack);// target
        E secondElementOfQueue = safePop(this.bufferedStack);

        refill(this.bufferedStack, this.storeStack);// time complexity T(n)=O(n)
        if (secondElementOfQueue != null) {
            this.bufferedStack.push(secondElementOfQueue);
        }
        return firstElementOfQueue;
    }

    /**
     * Java的stack如果为空,调用pop()方法会抛异常
     * 为了安全调用，因此需要有此方法
     *
     * @param stack
     * @return
     */
    private E safePop(Stack<E> stack) {
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    /**
     * 往storedStack 重新填充即可
     *
     * @param fromStack
     * @param toStack
     */
    private void refill(Stack<E> fromStack, Stack<E> toStack) {
        while (!fromStack.isEmpty()) {
            E item = fromStack.pop();
            toStack.push(item);
        }
    }

    @Override
    public int size() {
        return this.storeStack.size() + this.bufferedStack.size();
    }
}