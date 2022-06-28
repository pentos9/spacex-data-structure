package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.CheckIfEdgeIsBridgeGraph;
import org.junit.jupiter.api.Test;

public class CheckIfEdgeIsBridgeGraphTest {

    @Test
    public void test() {
        CheckIfEdgeIsBridgeGraph graph = new CheckIfEdgeIsBridgeGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.edgeIsBridge(0, 1);
        graph.edgeIsBridge(3, 4);
        graph.edgeIsBridge(2, 3);
    }
}
