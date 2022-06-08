package com.spacex.data.structure.graph;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    public void unweightedShortestPath() {
        unweightedShortestPath(startVertex);
    }

    /**
     * 计算源点S到无向图各个顶点的最短路径
     * 需要一个队列保存图中顶点，初始时，源点入队列，
     * 然后以广度的形式向外扩散求解其他顶点的最短路径
     *
     * @param startVertex
     */
    private void unweightedShortestPath(Vertex startVertex) {
        // init

        Queue<Vertex> queue = new LinkedList<>();
        startVertex.distance = 0;
        queue.offer(startVertex);//将源点dist设置为0并入队列

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            for (Edge edge : vertex.adjEdges) {
                if (edge.endVertex.distance == Integer.MAX_VALUE) {
                    edge.endVertex.distance = vertex.distance + 1;
                    queue.offer(edge.endVertex);
                    edge.endVertex.preNode = vertex;//设置该顶点的前驱
                }// end if

            }// end for
        }// end while

    }
}
