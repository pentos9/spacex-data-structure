package com.spacex.data.structure.list.skiplist;

public interface ISkipList<T extends Comparable<? super T>> {

    int LEVELs = 5;

    T add(T data);

    void delete(T target);

    SkipNode<T> search(T data);

    int size();

    void print();
}
