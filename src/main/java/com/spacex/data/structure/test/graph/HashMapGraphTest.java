package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.directed.HashMapDirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class HashMapGraphTest {

    @Test
    public void test() {
        LinkedList<Object> vertices = new LinkedList<>();

        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        vertices.add("D");
        vertices.add("E");
        vertices.add("F");
        vertices.add("G");

        HashMapDirectedGraph graph = new HashMapDirectedGraph(vertices);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        graph.addEdge("G", "E");
        graph.addEdge("A", "G");

        graph.printGraph();

        System.out.println("-----DFS start----");
        graph.dfs();
    }
}
