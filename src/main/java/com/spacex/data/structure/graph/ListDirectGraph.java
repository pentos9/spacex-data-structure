package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.Iterator;
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

    /**
     * 移除一个顶点，所有和这个顶点关联的边，都要被移除
     *
     * @param v
     * @return
     */
    @Override
    public boolean removeVertex(V v) {
        Iterator<GraphNode<V>> edgeIterator = this.graphNodeList.iterator();
        while (edgeIterator.hasNext()) {
            GraphNode<V> graphNode = edgeIterator.next();
            if (v.equals(graphNode.getVertex())) {
                edgeIterator.remove();
            }
        }
        return true;
    }

    @Override
    public V getVertex(int index) {
        return this.graphNodeList.get(index).getVertex();
    }

    /**
     * 如果新增一条边，就遍历整个列表。
     * 如果存在这条起始节点，则新增这条边；
     * 如果不存在，则可以报错。
     *
     * @param edge
     */
    @Override
    public void addEdge(Edge<V> edge) {
        for (GraphNode<V> graphNode : this.graphNodeList) {
            V from = edge.getFrom();
            V vertex = graphNode.getVertex();
            if (from.equals(vertex)) {
                graphNode.getEdgeSet().add(edge);
            }
        }
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
