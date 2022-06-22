package com.spacex.data.structure.graph.custom.undirected;

import java.util.LinkedList;

public abstract class AbstractUndirectedGraph {
    protected int vertices;
    protected LinkedList<Integer>[] adjList;

    public AbstractUndirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; i++) {
            this.adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int source, int destination) {
        // add forward edge
        this.adjList[source].addFirst(destination);

        // add backward edge
        this.adjList[destination].addFirst(source);
    }

    public void printGraph() {
        for (int i = 0; i < this.vertices; i++) {
            LinkedList<Integer> nodeList = this.adjList[i];
            System.out.println("Vertex connected from vertex: " + i);
            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print("->" + nodeList.get(j));
            }
            System.out.println();
        }
    }
}
