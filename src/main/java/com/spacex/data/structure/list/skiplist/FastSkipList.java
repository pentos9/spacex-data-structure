package com.spacex.data.structure.list.skiplist;

public class FastSkipList<T> {

    public void add(T data) {

    }


    public boolean delete(T target) {
        return false;
    }


    public Object search(T data) {
        return null;
    }


    public int size() {
        return 0;
    }

    public void print() {

    }

    private static class SkipNode<T> {
        int key;
        T value;
        SkipNode right, down;

        public SkipNode(int key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}