package com.spacex.data.structure.list.skiplist;

import java.util.Random;

public class SkipList<T extends Comparable<? super T>> implements ISkipList<T> {

    private final SkipNode<T> head = new SkipNode<>(null);
    private final Random random = new Random();
    private int size;

    @Override
    public void add(T data) {
        SkipNode<T> skipNode = new SkipNode<>(data);
        for (int i = 0; i < LEVELS; i++) {
            if (random.nextInt((int) Math.pow(2, i)) == 0) {
                // insert with prob 1/(2^i)
                insert(skipNode, i);
            }
        }

        this.size++;
    }

    private void insert(SkipNode<T> skipNode, int level) {
        this.head.insert(skipNode, level);
    }

    @Override
    public boolean delete(T target) {
        System.out.println("Deleting: " + target);
        SkipNode<T> victim = search(target, true);
        if (victim == null) {
            return false;
        }

        victim.setData(null);

        for (int i = 0; i < LEVELS; i++) {
            victim.refreshAfterDelete(i);
        }

        this.size--;
        return true;
    }

    @Override
    public SkipNode<T> search(T data) {
        return search(data, true);
    }

    private SkipNode<T> search(T data, boolean print) {
        SkipNode<T> result = null;
        for (int i = LEVELS - 1; i > 0; i--) {
            if ((result = this.head.search(data, i, true)) != null) {
                if (print) {
                    System.out.println("Found " + data.toString() + " at level:" + i + ",so stop!");
                    System.out.println();
                }
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print() {
        for (int i = LEVELS - 1; i > 0; i--) {
            this.head.print(i);
        }
        System.out.println();
    }
}
