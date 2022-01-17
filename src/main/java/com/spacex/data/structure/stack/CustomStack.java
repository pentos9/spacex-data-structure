package com.spacex.data.structure.stack;

import java.util.Iterator;

/**
 * 栈可以通过数组和链表来实现
 * 1.利用数组来创建栈，可以得到连续的内存空间，但是扩容的时候会比较麻烦。
 * 2.利用链表来实现栈时扩容简单，但是内存空间不连续。
 *
 * @param <E>
 */
public interface CustomStack<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean push(E item);

    E pop();

    E peek();// returns the last inserted element without removing it

    int search(Object o);

    void clear();
}
