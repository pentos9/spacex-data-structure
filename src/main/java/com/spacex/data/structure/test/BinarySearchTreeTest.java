package com.spacex.data.structure.test;

import com.spacex.data.structure.bst.BinarySearchTree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BinarySearchTree<String, String> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < 100; i++) {
            binarySearchTree.put("Tree-" + i, "Tree-" + String.valueOf(i));
        }

        System.out.println(binarySearchTree);
        for (String key : binarySearchTree.levelOrder()) {
            System.out.println(key);
        }

        System.out.println("Tree Max:" + binarySearchTree.max());
        System.out.println("Tree size:" + binarySearchTree.size());
        System.out.println("Tree isEmpty:" + binarySearchTree.isEmpty());
    }
}
