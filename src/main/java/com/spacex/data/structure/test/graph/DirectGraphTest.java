package com.spacex.data.structure.test.graph;

import com.spacex.data.structure.graph.direct.Edge;
import com.spacex.data.structure.graph.direct.ListDirectGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        int total = ThreadLocalRandom.current().nextInt(100);
        List<String> vertexList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            vertexList.add(String.valueOf(i));
            directGraph.addVertex(String.valueOf(i));
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(vertexList.size());
        for (int i = 0; i < total; i++) {
            String randomFrom = String.valueOf(ThreadLocalRandom.current().nextInt(100));
            if (i % 3 == 0) {
                randomFrom = String.valueOf(randomIndex);
            }
            String randomTo = String.valueOf(ThreadLocalRandom.current().nextInt(100));
            directGraph.addEdge(new Edge<>(randomFrom, randomTo));
        }


        String randomRoot = vertexList.get(randomIndex);
        List<String> bfsList = directGraph.bfs(randomRoot);
        for (String vertex : bfsList) {
            System.out.print(vertex + "\t");
        }
    }

    @Test
    public void test() {
        // init vertex

        directGraph.addVertex("1");
        directGraph.addVertex("2");
        directGraph.addVertex("3");
        directGraph.addVertex("4");
        directGraph.addVertex("5");

        directGraph.addEdge(new Edge<>("1", "2"));
        directGraph.addEdge(new Edge<>("1", "3"));
        directGraph.addEdge(new Edge<>("1", "4"));
        directGraph.addEdge(new Edge<>("2", "3"));
        directGraph.addEdge(new Edge<>("3", "4"));
        directGraph.addEdge(new Edge<>("4", "5"));

        Edge<String> edge = directGraph.getEdge(0, 1);
        Edge<String> edgeNotExist = directGraph.getEdge(1, 4);
        Assertions.assertNotNull(edge);
        Assertions.assertNull(edgeNotExist);
    }

    @Test
    public void testRemove() {
        int total = ThreadLocalRandom.current().nextInt(100);
        String root = "root";
        directGraph.addVertex(root);
        for (int i = 0; i < total; i++) {
            directGraph.addVertex(String.valueOf(i));
        }

        directGraph.addEdge(new Edge<>(root, String.valueOf(1)));

        for (int i = 1; i < total; i++) {
            directGraph.addEdge(new Edge<>(String.valueOf(i), String.valueOf(i + 1)));
            directGraph.addEdge(new Edge<>(String.valueOf(i + 1), String.valueOf(i + 2)));
        }
        List<String> bfsList = directGraph.bfs(root);
        for (String vertex : bfsList) {
            System.out.print(vertex + "\t");
        }

        directGraph.removeVertex(root);
        System.out.println("====== DFS ======");
        bfsList = directGraph.dfs("1");
        for (String vertex : bfsList) {
            System.out.print(vertex + "\t");
        }
    }
}
