package com.spacex.data.structure.list;

import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CustomConcurrentArrayList<E> implements CustomList<E> {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private CustomList<E> customList;

    public CustomConcurrentArrayList(CustomList<E> customList) {
        this.customList = customList;
    }

    @Override
    public boolean isEmpty() {
        readWriteLock.readLock().lock();
        try {
            return customList.isEmpty();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public int size() {
        readWriteLock.readLock().lock();
        try {
            return customList.size();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public boolean add(E element) {
        readWriteLock.writeLock().lock();
        try {
            return customList.add(element);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public boolean add(int index, E element) {
        readWriteLock.writeLock().lock();
        try {
            return customList.add(index, element);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void remove(E element) {
        readWriteLock.writeLock().lock();
        try {
            customList.remove(element);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public E get(int index) {
        readWriteLock.readLock().lock();
        try {
            return customList.get(index);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public int indexOf(E element) {
        readWriteLock.readLock().lock();
        try {
            return customList.indexOf(element);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public void set(int index, E element) {
        readWriteLock.writeLock().lock();
        try {
            customList.set(index, element);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public boolean contains(E element) {
        readWriteLock.readLock().lock();
        try {
            return customList.contains(element);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public void clear() {
        readWriteLock.writeLock().lock();
        try {
            customList.clear();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public Object[] toArray() {
        readWriteLock.readLock().lock();
        try {
            return customList.toArray();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public Iterator<E> iterator() {
        readWriteLock.readLock().lock();
        try {
            return customList.iterator();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
