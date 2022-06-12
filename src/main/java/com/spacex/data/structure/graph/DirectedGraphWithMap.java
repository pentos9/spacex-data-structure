package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    }

    private Map<Vertex, List<Vertex>> adjancentVertices;

    public DirectedGraphWithMap() {
        this.adjancentVertices = new HashMap<>();
    }

    public void addVertex(String label) {
        this.adjancentVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjancentVertices.values().forEach(e -> e.remove(v));
        this.adjancentVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2) {

    }

    public void removeEdge(String label1, String label2) {

    }
}
