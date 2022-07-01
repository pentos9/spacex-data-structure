package com.spacex.data.structure.graph.custom.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ArticulationPointGraph extends AbstractUndirectedGraph {

    private int time = 0;
    private ArrayList<Integer> articulationResult = new ArrayList<>();

    public ArticulationPointGraph(int vertices) {
        super(vertices);
    }

    public void findArticulationPoints() {
        int vertices = this.vertices;
        Map<Integer, Integer> visitTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();


        // create visit array
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visitTime, lowTime, visited, parent);
            }
        }

        if (articulationResult.size() > 0) {
            System.out.println("Articulation Points are:" + Arrays.toString(articulationResult.toArray()));
        } else {
            System.out.println("no Articulation point in the Given graph");
        }

    }

    private void dfs(int currentVertex, Map<Integer, Integer> discoveryTime,
                     Map<Integer, Integer> lowTime, boolean[] visited,
                     Map<Integer, Integer> parent) {
        LinkedList<Integer>[] adjList = this.adjList;
        int childCount = 0;
        boolean canArticulationPoint = false;
        visited[currentVertex] = true;
        discoveryTime.put(currentVertex, this.time);
        lowTime.put(currentVertex, this.time);
        time++;

        for (int i = 0; i < adjList[currentVertex].size(); i++) {
            int adjacentVertex = adjList[currentVertex].get(i);
            if (!visited[currentVertex]) {
                parent.put(adjacentVertex, currentVertex);
                childCount++;

                dfs(adjacentVertex, discoveryTime, lowTime, visited, parent);

                if (discoveryTime.get(currentVertex) <= lowTime.get(adjacentVertex)) {
                    canArticulationPoint = true;
                } else {
                    int currLowTime = lowTime.get(currentVertex);
                    lowTime.put(currentVertex, Math.min(currLowTime, lowTime.get(adjacentVertex)));
                }
            } else {
                int currLowTime = lowTime.get(currentVertex);
                lowTime.put(currentVertex, Math.min(currLowTime, (discoveryTime.get(adjacentVertex) == null ? 0 : discoveryTime.get(adjacentVertex))));
            }
        }

        // after visiting all the adjacent vertices check if current vertex is articulation point
        if ((parent.get(currentVertex) == null && childCount > 1)
                || (parent.get(currentVertex) != null && canArticulationPoint)) {
            //current vertex is AP, add it to the list
            articulationResult.add(currentVertex);
        }
    }
}