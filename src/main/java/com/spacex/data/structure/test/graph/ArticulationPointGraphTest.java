package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.ArticulationPointGraph;
import org.junit.jupiter.api.Test;

public class ArticulationPointGraphTest {

    @Test
    public void test() {
        ArticulationPointGraph graph = new ArticulationPointGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(5, 6);
        graph.findArticulationPoints();
    }
}
