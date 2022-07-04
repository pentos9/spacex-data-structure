package com.spacex.data.structure.graph.custom.directed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapDirectedGraph {
    private Map<Object, LinkedList<Object>> adjList = new HashMap<>();
    private Map<Object, Integer> indexes = new HashMap<>();
    private int index = -1;

    public HashMapDirectedGraph(List<Object> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            Object vertex = vertices.get(i);
            LinkedList<Object> list = new LinkedList<>();
            this.adjList.put(vertex, list);
            this.indexes.put(vertex, ++this.index);
        }
    }

    public void addEdge(Object source, Object destination) {
        LinkedList<Object> adjVertexList = this.adjList.get(source);
        adjVertexList.addFirst(destination);
        this.adjList.put(source, adjVertexList);
    }

    public boolean isVertexExist(Object vertex) {
        return this.adjList.keySet().contains(vertex);
    }

    public void dfs() {
        int vertices = this.adjList.size();
        boolean[] visited = new boolean[vertices];
        for (Map.Entry<Object, LinkedList<Object>> entry : this.adjList.entrySet()) {
            Object source = entry.getKey();
            if (!visited[this.indexes.get(source)]) {
                dfs(source, visited);
            }
            //System.out.println("Key=" + entry.getKey() + ",Value = " + entry.getValue());
        }
    }

    private void dfs(Object source, boolean[] visited) {
        // mark this visited
        visited[this.indexes.get(source)] = true;
        System.out.print(source + " ");

        LinkedList<Object> list = this.adjList.get(source);
        for (int i = 0; i < list.size(); i++) {
            Object destination = list.get(i);
            if (!visited[this.indexes.get(destination)]) {
                dfs(destination, visited);
            }
        }
    }

    public void printGraph() {
        Set<Object> set = this.adjList.keySet();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            Object vertex = iterator.next();
            System.out.print("Vertex " + vertex + " is connected to:");
            LinkedList<Object> list = this.adjList.get(vertex);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }

            System.out.println();
        }
    }
}
