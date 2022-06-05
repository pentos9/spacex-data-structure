package com.spacex.data.structure.graph;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NonDirectedGraph {
    private class Vertex {
        private String vertexLabel;
        private List<Edge> adjEdges;
        private int distance;
        private Vertex preNode;

        public Vertex(String vertexLabel) {
            this.vertexLabel = vertexLabel;
            this.adjEdges = new LinkedList<>();
            this.distance = Integer.MAX_VALUE;
            preNode = null;
        }
    }

    private class Edge {
        private Vertex endVertex;

        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String, Vertex> nonDirectedGraph;
    private Vertex startVertex;

    public NonDirectedGraph(String graphContent) {
        this.nonDirectedGraph = new LinkedHashMap<>();
        buildGraph();
    }

    private void buildGraph() {

    }
}
