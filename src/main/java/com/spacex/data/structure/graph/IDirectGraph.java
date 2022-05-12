package com.spacex.data.structure.graph;

public interface IDirectGraph<V> {
    void addVertex(final V v);

    boolean removeVertex(final V v);

    V getVertex(final int index);

    void addEdge(final Edge<V> edge);

    boolean removeEdge(final Edge<V> edge);

    Edge<V> getEdge(final int from, final int to);
}
