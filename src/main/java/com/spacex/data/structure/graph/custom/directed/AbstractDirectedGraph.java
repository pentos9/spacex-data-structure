package com.spacex.data.structure.graph.custom.directed;


import java.util.LinkedList;

public abstract class AbstractDirectedGraph {
    protected int vertices;
    protected LinkedList[] adjList;

    public AbstractDirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        // add forward edge
        adjList[source].addFirst(destination);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            LinkedList<Integer> nodeList = adjList[i];
            System.out.println("Vertex connected from vertex: " + i);

            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print("->" + nodeList.get(j));
            }
            System.out.println();
        }
    }
}
