package com.spacex.data.structure.map;

import java.util.Arrays;

public class CustomizedHashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16

    private int size = 0;

    public CustomizedHashMap() {
        this(INITIAL_CAPACITY);
    }

    public CustomizedHashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public int size() {
        return this.size;
    }

    /**
     * this version has no resize method
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> existing = this.buckets[bucket];
        if (existing == null) {
            this.buckets[bucket] = entry;
            this.size++;
        } else {
            // compare the keys to see if the key exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                this.size++;
            }
        }
    }


    private int getBucketSize() {
        return this.buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    public V get(K key) {
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> bucketEntry = this.buckets[bucket];
        while (bucketEntry != null) {
            if (bucketEntry.key == key) {
                return bucketEntry.value;
            }
            bucketEntry = bucketEntry.next;
        }
        return null;
    }

//    public V removeXXXX(K key) {
//        int bucket = getHash(key) % getBucketSize();
//        Entry<K, V> bucketEntry = this.buckets[bucket];
//        Entry<K, V> currentEntry = bucketEntry;
//        Entry<K, V> prevEntry = null;
//        while (currentEntry != null) {
//            if (currentEntry.key.equals(key)) {
//                // get and do delete
//                // how to delete
//                V value = currentEntry.value;
//                if (prevEntry != null) {
//                    prevEntry.next = currentEntry.next;// delete target node directly
//                } else {
//                    currentEntry = null;// this is the head, delete:no previous and set currentEntry to null
//                }
//                this.buckets[bucket] = currentEntry;// reset bucket
//                this.size--;
//                return value;
//            }
//            prevEntry = currentEntry;
//            currentEntry = currentEntry.next;
//        }
//        return null;
//    }

    public V remove(K key) {
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> bucketEntry = this.buckets[bucket];
        Entry<K, V> currentEntry = bucketEntry;
        Entry<K, V> prevEntry = null;


        // CASE 1:
        // If head node itself holds the key to be deleted
        if (currentEntry != null && currentEntry.key.equals(key)) {
            System.out.println(key + " found and deleted");
            this.buckets[bucket] = currentEntry.next;
            this.size--;
            return currentEntry.value;
        }

        // CASE 2:
        // If the key is somewhere other than at head
        while (currentEntry != null && !currentEntry.key.equals(key)) {
            prevEntry = currentEntry;
            currentEntry = currentEntry.next;
        }

        //
        if (currentEntry != null) {
            V value = currentEntry.value;
            prevEntry.next = currentEntry.next;
            // Display the message
            System.out.println(key + " found and deleted");
            this.buckets[bucket] = currentEntry;
            this.size--;
            return value;
        }

        // CASE 3:The key is not present
        if (currentEntry == null) {
            System.out.println(key + " is not found");
        }
        return null;
    }

    @Override
    public String toString() {
        return "CustomizedHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                ", size=" + size +
                '}';
    }
}
