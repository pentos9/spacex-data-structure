package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.List;

public class ListDirectGraph<V> implements IDirectGraph<V> {

    private List<GraphNode<V>> graphNodeList;

    public ListDirectGraph() {
        this.graphNodeList = new ArrayList<>();
    }

    @Override
    public void addVertex(V v) {
        GraphNode<V> graphNode = new GraphNode<>(v);
        this.graphNodeList.add(graphNode);
    }

    @Override
    public boolean removeVertex(V v) {
        return false;
    }

    @Override
    public V getVertex(int index) {
        return null;
    }

    @Override
    public void addEdge(Edge<V> edge) {

    }

    @Override
    public boolean removeEdge(Edge<V> edge) {
        return false;
    }

    @Override
    public Edge<V> getEdge(int from, int to) {
        return null;
    }
}
