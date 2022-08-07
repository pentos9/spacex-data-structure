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


    public void delete(int key) {
        SkipNode<T> tempNode = this.headNode;
        while (tempNode != null) {
            if (tempNode.right == null) {
                tempNode = tempNode.down;
            } else if (tempNode.right.key == key) {
                tempNode.right = tempNode.right.right;
                tempNode = tempNode.down;
            } else if (tempNode.right.key > key) {
                tempNode = tempNode.down;
            } else {
                tempNode = tempNode.right;
            }
        }
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
        SkipNode<T> tempNode = this.headNode;
        int index = 1;
        SkipNode<T> last = tempNode;
        while (last != null) {
            last = last.down;
        }

        while (tempNode != null) {
            SkipNode<T> enumNode = tempNode.right;
            SkipNode<T> enumLast = last.right;

            while (enumLast != null && enumNode != null) {
                if (enumLast.key == enumNode.key) {
                    System.out.printf("%-5s", enumLast.key + "->");
                    enumLast = enumLast.right;
                    enumNode = enumNode.right;
                } else {
                    enumLast = enumLast.right;
                    System.out.printf("%-s", "");
                }
            }

            tempNode = tempNode.down;
            index++;
            System.out.println();
        }
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