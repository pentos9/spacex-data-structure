package com.spacex.data.structure.graph.direct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphNode<V> {
    private V vertex;

    private Set<Edge<V>> edgeSet;

    public GraphNode(V vertex) {
        this.vertex = vertex;
        this.edgeSet = new HashSet<>();
    }

    public void add(final Edge<V> edge) {
        this.edgeSet.add(edge);
    }

    public Edge<V> get(final V to) {
        for (Edge<V> edge : this.edgeSet) {
            V dest = edge.getTo();
            if (dest.equals(to)) {
                return edge;
            }
        }
        return null;
    }

    public Edge<V> remove(final V to) {
        Iterator<Edge<V>> iterator = this.edgeSet.iterator();
        while (iterator.hasNext()) {
            Edge<V> next = iterator.next();
            if (to.equals(next.getTo())) {
                iterator.remove();
                return next;
            }
        }

        return null;
    }

    public V getVertex() {
        return vertex;
    }

    public Set<Edge<V>> getEdgeSet() {
        return edgeSet;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "vertex=" + vertex +
                ", edgeSet=" + edgeSet +
                '}';
    }
}
