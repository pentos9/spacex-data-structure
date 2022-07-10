package com.spacex.data.structure.graph.custom.undirected;

import com.spacex.data.structure.graph.custom.directed.AbstractDirectedGraph;

import java.util.Objects;

public class EdgesToMakeAcyclicGraph extends AbstractDirectedGraph {
    public EdgesToMakeAcyclicGraph(int vertices) {
        super(vertices);
    }

    public static class ValuePair<T1, T2> {
        private T1 value1;
        private T2 value2;

        public ValuePair(T1 value1, T2 value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public T1 getValue1() {
            return value1;
        }

        public T2 getValue2() {
            return value2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ValuePair)) return false;
            ValuePair<?, ?> valuePair = (ValuePair<?, ?>) o;
            return Objects.equals(value1, valuePair.value1) &&
                    Objects.equals(value2, valuePair.value2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value1, value2);
        }

        @Override
        public String toString() {
            return "ValuePair{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }

    public ValuePair<Integer, Integer> findMaximumNumberEdgesToMakeAcyclicGraph() {

        // for undirected graph
        int edgesForUndirectedGraph = getVerticesNumberForUndirectedGraph(this.vertices);
        System.out.println("Maximum edges to make Acyclic Undirected Graph with " + vertices + " vertices are: " + edgesForUndirectedGraph);

        // for directed graph
        int edgesForDirectedGraph = getVerticesNumberForDirectedGraph(this.vertices);
        System.out.println("Maximum edges to make Acyclic Directed Graph with " + vertices + " vertices are: " + edgesForDirectedGraph);

        return new ValuePair<>(edgesForUndirectedGraph, edgesForDirectedGraph);
    }

    private int getVerticesNumberForUndirectedGraph(int vertices) {
        return vertices - 1;
    }

    private int getVerticesNumberForDirectedGraph(int vertices) {
        return vertices * (vertices - 1) / 2;
    }
}
