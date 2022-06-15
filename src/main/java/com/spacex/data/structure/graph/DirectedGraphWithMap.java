package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DirectedGraphWithMap {
    private class Vertex {
        String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public String toString() {
            return this.label;
        }

        private DirectedGraphWithMap getOuterType() {
            return DirectedGraphWithMap.this;
        }
    }

    private Map<Vertex, List<Vertex>> adjacentVertices;

    public DirectedGraphWithMap() {
        this.adjacentVertices = new HashMap<>();
    }

    public void addVertex(String label) {
        this.adjacentVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        this.adjacentVertices.values().forEach(e -> e.remove(v));
        this.adjacentVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        this.adjacentVertices.get(v1).add(v2);
        this.adjacentVertices.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = this.adjacentVertices.get(v1);
        List<Vertex> eV2 = this.adjacentVertices.get(v2);

        if (eV1 != null) {
            eV1.remove(v2);
        }

        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    public List<Vertex> getVertices(String label) {
        return this.adjacentVertices.get(new Vertex(label));
    }

    public String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex vertex : this.adjacentVertices.keySet()) {
            sb.append(vertex);
            sb.append(adjacentVertices.get(vertex));
        }
        return sb.toString();
    }

    /**
     * perform the depth-first traversal
     *
     * @param graph
     * @param root
     * @return
     */
    public static Set<String> depthFirstTraversal(DirectedGraphWithMap graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
            }
            for (Vertex v : graph.getVertices(vertex)) {
                stack.push(v.label);
            }
        }
        return visited;
    }

    /**
     * perform the breadth-first traversal
     *
     * @param graph
     * @param root
     * @return
     */
    public static Set<String> breathFirstTraversal(DirectedGraphWithMap graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : graph.getVertices(vertex)) {
                if (!visited.contains(v)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
}
