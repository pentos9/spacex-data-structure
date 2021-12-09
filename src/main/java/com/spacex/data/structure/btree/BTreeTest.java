package com.spacex.data.structure.btree;

public class BTreeTest {
    public static void main(String[] args) {
        run();
        build();
        buildBigTree(200, "A", "A-");
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

        System.out.println("www.cs.princeton.edu: " + bTree.getValue("www.cs.princeton.edu"));
        System.out.println("www.ts.edu:           " + bTree.getValue("www.ts.edu"));
        System.out.println("www.daoye-tech.edu:   " + bTree.getValue("www.daoye-tech.edu"));

        System.out.println(bTree.size());
        System.out.println(bTree.height());
        System.out.println();
    }

    public static void build() {
        BTree<String, String> bTree = new BTree<>();
        bTree.put("A1", "A-1");
        bTree.put("A2", "A-2");
        bTree.put("A3", "A-3");
        bTree.put("A4", "A-4");
        bTree.put("A5", "A-5");
        bTree.put("A6", "A-6");
        bTree.put("A7", "A-7");
        bTree.put("A8", "A-8");
        System.out.println(bTree.toString());

    }

    public static void buildBigTree(int total, String nodePrefix, String leafPostfix) {
        BTree<String, String> bTree = new BTree<>();

        for (int i = 0; i < total; i++) {
            bTree.put(nodePrefix + i, leafPostfix + i);
        }
        System.out.println(bTree.toString());

        bTree.put("www.cs.princeton.edu", "128.112.136.12");
        bTree.put("www.cs.washington.edu", "128.112.136.13");
        bTree.put("www.dgut.edu", "128.112.136.14");
        bTree.put("www.tsinghua.edu", "128.112.136.15");
        bTree.put("www.virginia.edu", "128.112.136.16");
        bTree.put("www.ts.edu", "128.112.136.17");
        bTree.put("www.daoye-tech.edu", "128.112.136.18");
        bTree.put("www.harvardsucks.com", "128.112.136.19");
        System.out.println("cs.princeton.edu:  " + bTree.getValue("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + bTree.getValue("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + bTree.getValue("www.simpsons.com"));
    }


}
