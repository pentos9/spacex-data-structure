package com.spacex.data.structure.btree;

public class BTreeTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        BTree<String, String> bTree = new BTree<>();
        bTree.put("www.cs.princeton.edu", "128.112.136.12");
        bTree.put("www.cs.washington.edu", "128.112.136.13");
        bTree.put("www.dgut.edu", "128.112.136.14");
        bTree.put("www.tsinghua.edu", "128.112.136.15");
        bTree.put("www.virginia.edu", "128.112.136.16");
        bTree.put("www.ts.edu", "128.112.136.17");
        bTree.put("www.daoye-tech.edu", "128.112.136.18");
        System.out.println(bTree.toString());
    }
}
