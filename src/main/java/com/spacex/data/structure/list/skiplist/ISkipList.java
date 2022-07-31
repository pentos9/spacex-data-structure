package com.spacex.data.structure.list.skiplist;

public interface ISkipList<T extends Comparable<? super T>> {

    int LEVELS = 5;

    void add(T data);

    boolean delete(T target);

    SkipNode<T> search(T data);

    int size();

    void print();
}
