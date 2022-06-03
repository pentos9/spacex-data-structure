package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraph {
    private int v;
    private ArrayList<Integer>[] adjacentList;

    public SimpleGraph(int vertices) {
        this.v = vertices;
        this.initAdjacent();
    }

    private void initAdjacent() {
        this.adjacentList = new ArrayList[v];
        for (int i = 0; i < this.v; i++) {
            this.adjacentList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.adjacentList[u].add(v);
    }

    public void printAllPaths(int source, int destination) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        printAllPathsUtil(source, destination, isVisited, pathList);
    }

    /**
     * A recursive function to print all paths from 'u' to 'd'
     *
     * @param u
     * @param d
     * @param isVisited     keeps track of vertices in current path
     * @param localPathList stores actual vertices in the current path
     */
    private void printAllPathsUtil(Integer u,
                                   Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }

        isVisited[u] = true;
        for (Integer i : this.adjacentList[u]) {
            if (!isVisited[i]) {
                // store current node
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);

                // remove current node
                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }
}
