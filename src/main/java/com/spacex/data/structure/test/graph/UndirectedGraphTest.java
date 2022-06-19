package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

public class UndirectedGraphTest {

    private UndirectedGraph undirectedGraph;

    @Test
    public void print() {
        this.undirectedGraph = new UndirectedGraph(5);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(0, 4);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(1, 4);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 4);

        undirectedGraph.printGraph();
    }
}
