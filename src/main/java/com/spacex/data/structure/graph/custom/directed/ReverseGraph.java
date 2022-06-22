package com.spacex.data.structure.graph.custom.directed;

import java.util.LinkedList;

public class ReverseGraph extends AbstractDirectedGraph {

    public ReverseGraph(int vertices) {
        super(vertices);
    }

    public AbstractDirectedGraph reverse(AbstractDirectedGraph graph) {
        AbstractDirectedGraph reverseGraph = new ReverseGraph(this.vertices);
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
}
