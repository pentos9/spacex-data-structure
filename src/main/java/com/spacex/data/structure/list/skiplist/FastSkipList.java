package com.spacex.data.structure.list.skiplist;

import java.util.Random;

public class FastSkipList<T> {

    private SkipNode<T> headNode;
    private int highLevel;
    private Random random;
    final int MAX_LEVEL = 32;

    public FastSkipList() {
        this.random = new Random();
        this.headNode = new SkipNode<>(Integer.MIN_VALUE, null);
        this.highLevel = 0;
    }

    public void add(T data) {

    }


    public boolean delete(T target) {
        return false;
    }


    public SkipNode<T> search(int key) {
        SkipNode<T> temp = this.headNode;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            } else if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key > key) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
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