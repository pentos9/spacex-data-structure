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
        buildGraph(graphContent);
    }

    private void buildGraph(String graphConteng) {
        String[] lines = graphConteng.split("\n");
        String startNodeLable, endNodeLabel;
        Vertex startNode, endNode;
        for (int i = 0; i < lines.length; i++) {
            String[] nodesInfo = lines[i].split(",");
            startNodeLable = nodesInfo[1];
            endNodeLabel = nodesInfo[2];

            endNode = nonDirectedGraph.get(endNodeLabel);
            if (endNode == null) {
                endNode = new Vertex(endNodeLabel);
                nonDirectedGraph.put(endNodeLabel, endNode);
            }

            startNode = nonDirectedGraph.get(startNodeLable);
            if (startNode == null) {
                startNode = new Vertex(startNodeLable);
                nonDirectedGraph.put(startNodeLable, startNode);
            }

            // 对于无向图来书来说，起点和终点都要添加边
            Edge edge = new Edge(endNode);
            endNode.adjEdges.add(edge);
            startNode.adjEdges.add(edge);
        }

        startVertex = nonDirectedGraph.get(lines[0].split(",")[1]);
    }
}
