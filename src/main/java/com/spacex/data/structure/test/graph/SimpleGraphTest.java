package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.SimpleGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleGraphTest {

    private SimpleGraph simpleGraph;

    private static int TOTAL;

    @BeforeAll
    public static void initStatic() {
        TOTAL = ThreadLocalRandom.current().nextInt(100);
    }

    @BeforeEach
    public void init() {
        this.simpleGraph = new SimpleGraph(TOTAL);
    }

    @Test
    public void testGraph() {

    }

    @Test
    public void test() {
        this.simpleGraph = new SimpleGraph(4);

        simpleGraph.addEdge(0, 1);
        simpleGraph.addEdge(0, 2);
        simpleGraph.addEdge(0, 3);
        simpleGraph.addEdge(2, 0);

        simpleGraph.addEdge(2, 1);
        simpleGraph.addEdge(1, 3);

        int source = 2;
        int destination = 3;

        simpleGraph.printAllPaths(source, destination);
    }
}
