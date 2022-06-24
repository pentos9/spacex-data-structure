package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.CheckUndirectedDisconnectedGraph;
import org.junit.jupiter.api.Test;

public class CheckUndirectedDisconnectedGraphTest {

    @Test
    public void test() {
        CheckUndirectedDisconnectedGraph graph = new CheckUndirectedDisconnectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);

        System.out.println(graph.isConnected());

        graph.addEdge(3, 4);
        System.out.println(graph.isConnected());
    }
}
