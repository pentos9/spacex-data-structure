package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.EdgesToMakeAcyclicGraph;
import org.junit.jupiter.api.Test;

public class EdgesToMakeAcyclicGraphTest {

    @Test
    public void testMaximumNumberEdgesToMakeAcyclicGraph() {
        int vertices = 3;
        EdgesToMakeAcyclicGraph graph = new EdgesToMakeAcyclicGraph(vertices);
        graph.findMaximumNumberEdgesToMakeAcyclicGraph();

        vertices = 4;
        graph = new EdgesToMakeAcyclicGraph(vertices);
        graph.findMaximumNumberEdgesToMakeAcyclicGraph();

        vertices = 5;
        graph = new EdgesToMakeAcyclicGraph(vertices);
        graph.findMaximumNumberEdgesToMakeAcyclicGraph();
    }
}
