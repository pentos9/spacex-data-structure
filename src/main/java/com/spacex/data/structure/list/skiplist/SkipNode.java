package com.spacex.data.structure.list.skiplist;

public class SkipNode<T extends Comparable<? super T>> {

    private T data;
    private SkipNode<T>[] next = (SkipNode<T>[]) new SkipNode[ISkipList.LEVELs];

    public SkipNode(T data) {
        this.data = data;
    }

    public void refreshAfterDelete(int level) {
        SkipNode<T> current = this;
        while (current != null && current.getNext(level) != null) {
            if (current.getNext(level).data == null) {
                SkipNode<T> successor = current.getNext(level).getNext(level);
                current.setNext(successor, level);
                return;
            }
            current = current.getNext(level);
        }
    }

    public void setNext(SkipNode<T> next, int level) {
        this.next[level] = next;
    }

    public SkipNode<T> getNext(int level) {
        return this.next[level];
    }

    public SkipNode<T> search(T data, int level, boolean print) {
        if (print) {
            System.out.println("searching for: " + data + "at");
            print(level);
        }

        SkipNode<T> result = null;
        SkipNode<T> current = this.getNext(level);
        while (current != null && current.data.compareTo(data) < 1) {
            if (current.data.equals(data)) {
                result = current;
                break;
            }

            current = current.getNext(level);
        }
        return result;
    }

    public void insert(SkipNode<T> skipNode, int level) {
        SkipNode<T> current = this.getNext(level);

        if (current == null) {
            this.setNext(skipNode, level);
            return;
        }

        if (skipNode.data.compareTo(data) < 1) {
            this.setNext(skipNode, level);
            skipNode.setNext(current, level);
            return;
        }

        while (current.getNext(level) != null
                && current.data.compareTo(data) < 1
                && (current.getNext(level).data.compareTo(skipNode.data) < 1)) {

            current = current.getNext(level);
        }

        SkipNode<T> successor = current.getNext(level);
        current.setNext(skipNode, level);
        skipNode.setNext(successor, level);

    }

    public void print(int level) {
        System.out.print("level " + level + "[");
        int length = 0;

        SkipNode<T> current = this.getNext(level);
        while (current != null) {
            length++;
            System.out.print(current.data + " ");
            current = current.getNext(level);
        }

        System.out.print("],length" + length);
    }
}
