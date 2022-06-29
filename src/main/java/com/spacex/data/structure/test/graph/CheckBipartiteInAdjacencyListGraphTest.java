package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.CheckBipartiteInAdjacencyListGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBipartiteInAdjacencyListGraphTest {

    @Test
    public void test() {
        CheckBipartiteInAdjacencyListGraph graph = createNonBipartiteGraph();
        Assertions.assertFalse(graph.isBipartite());
    }

    private CheckBipartiteInAdjacencyListGraph createNonBipartiteGraph() {
        CheckBipartiteInAdjacencyListGraph graph = new CheckBipartiteInAdjacencyListGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        return graph;
    }

    private CheckBipartiteInAdjacencyListGraph createBipartiteGraph() {
        CheckBipartiteInAdjacencyListGraph graph = new CheckBipartiteInAdjacencyListGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        return graph;
    }

    @Test
    public void testIsBipartiteWithBFS() {
        CheckBipartiteInAdjacencyListGraph graph = createBipartiteGraph();
        Assertions.assertTrue(graph.isBipartiteWithBFS());
    }
}
