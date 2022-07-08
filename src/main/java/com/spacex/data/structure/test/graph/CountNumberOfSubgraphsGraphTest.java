package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.undirected.CountNumberOfSubgraphsGraph;
import org.junit.jupiter.api.Test;

public class CountNumberOfSubgraphsGraphTest {

    @Test
    public void test() {
        CountNumberOfSubgraphsGraph graph = new CountNumberOfSubgraphsGraph(4);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(0, 1);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(2, 3);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        System.out.println("Number of Subgraphs: " + graph.countConnectedComponents());
    }
}
