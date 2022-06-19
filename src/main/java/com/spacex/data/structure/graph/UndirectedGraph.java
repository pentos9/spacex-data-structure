package com.spacex.data.structure.graph;

import java.util.LinkedList;

public class UndirectedGraph {
    private int vertex;
    private LinkedList<Integer> list[];

    public UndirectedGraph(int vertex) {
        this.vertex = vertex;
        this.list = new LinkedList[vertex];
        for (int i = 0; i < this.vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        //add edge
        this.list[source].add(destination);

        // add back edge (for undirected graph)
        this.list[destination].add(source);
    }

    public void printGraph() {
        for (int i = 0; i < this.vertex; i++) {
            if (this.list[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to");

                for (int j = 0; j < this.list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }

                System.out.println();
            }
        }
    }
}
