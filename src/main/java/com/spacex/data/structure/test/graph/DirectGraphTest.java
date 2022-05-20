package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.Edge;
import com.spacex.data.structure.graph.IDirectGraph;
import com.spacex.data.structure.graph.ListDirectGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DirectGraphTest {

    private static int CAPACITY;
    private ListDirectGraph<String> directGraph;

    @BeforeAll
    public static void initStatic() {
        CAPACITY = ThreadLocalRandom.current().nextInt(100);
    }

    @BeforeEach
    public void init() {
        directGraph = new ListDirectGraph<>();
    }

    @Test
    public void testGeneral() {
        // init vertex

        directGraph.addVertex("1");
        directGraph.addVertex("2");
        directGraph.addVertex("3");
        directGraph.addVertex("4");
        directGraph.addVertex("5");
        directGraph.addVertex("6");
        directGraph.addVertex("7");
        directGraph.addVertex("8");


        // init edge
        directGraph.addEdge(new Edge<>("1", "2"));
        directGraph.addEdge(new Edge<>("1", "3"));

        directGraph.addEdge(new Edge<>("2", "4"));
        directGraph.addEdge(new Edge<>("2", "5"));

        directGraph.addEdge(new Edge<>("3", "6"));
        directGraph.addEdge(new Edge<>("3", "7"));

        directGraph.addEdge(new Edge<>("4", "8"));

        directGraph.addEdge(new Edge<>("8", "5"));
        directGraph.addEdge(new Edge<>("6", "7"));

        List<String> bfsList = directGraph.bfs("1");
        for (String vertex : bfsList) {
            System.out.print(vertex + "\t");
        }

        System.out.println();
        List<String> dfsList = directGraph.dfs("1");
        for (String vertex : dfsList) {
            System.out.print(vertex + "\t");
        }
    }

    @Test
    public void testAddVertex() {

    }
}
