package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.directed.HashMapDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

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

    @Test
    public void testDFS() {
        LinkedList<Object> vertices = new LinkedList<>();
        int total = 10;
        String vertexPrefix = "v-";
        for (int i = 0; i < total; i++) {
            vertices.add(String.valueOf(vertexPrefix + i));
        }

        HashMapDirectedGraph graph = new HashMapDirectedGraph(vertices);
        for (int i = 0; i < vertices.size(); i++) {
            int randomEdgeIndex = ThreadLocalRandom.current().nextInt(vertices.size());
            Assertions.assertTrue(graph.isVertexExist(vertices.get(randomEdgeIndex)));
            graph.addEdge(vertices.get(i), vertices.get(randomEdgeIndex));

            randomEdgeIndex = ThreadLocalRandom.current().nextInt(vertices.size());
            if (randomEdgeIndex % 2 == 0) {
                Assertions.assertTrue(graph.isVertexExist(vertices.get(randomEdgeIndex)));
                graph.addEdge(vertices.get(i), vertices.get(randomEdgeIndex));
            }
        }

        graph.printGraph();
        System.out.println("-----DFS----");
        graph.dfs();

        System.out.println();
        System.out.println("-----Degree--");
        for (Object vertex : vertices) {
            System.out.println("in=" + graph.findInDegree(vertex) + ",out=" + graph.findOutDegree(vertex));
        }
    }
}
