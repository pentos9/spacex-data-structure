package com.spacex.data.structure.graph.custom.undirected.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
