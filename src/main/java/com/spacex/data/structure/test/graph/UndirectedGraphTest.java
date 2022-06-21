package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.custom.directed.AbstractDirectedGraph;
import com.spacex.data.structure.graph.custom.directed.ReverseGraph;
import com.spacex.data.structure.graph.custom.undirected.UndirectedGraph;
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

    @Test
    public void testReverse() {
        ReverseGraph graph = new ReverseGraph(5);
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        System.out.println("---------------Original UndirectedGraph---------------------------");
        graph.printGraph();
        AbstractDirectedGraph reverseGraph = graph.reverse(graph);
        System.out.println("---------------Reverse UndirectedGraph---------------------------");
        reverseGraph.printGraph();
    }


}
