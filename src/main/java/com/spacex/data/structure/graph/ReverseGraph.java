package com.spacex.data.structure.graph;

import java.util.LinkedList;

public class ReverseGraph {
    public static class Graph {
        private int vertices;
        private LinkedList[] adjList;

        public Graph(int vertices) {
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

        public Graph reverse(Graph graph) {
            Graph reverseGraph = new Graph(this.vertices);
            for (int i = 0; i < this.vertices; i++) {
                LinkedList<Integer> nodeList = this.adjList[i];
                int source = i;
                for (int j = 0; j < nodeList.size(); j++) {
                    int destination = nodeList.get(j);
                    // add reverse node
                    reverseGraph.addEdge(destination, source);
                }
            }
            return reverseGraph;
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
}
