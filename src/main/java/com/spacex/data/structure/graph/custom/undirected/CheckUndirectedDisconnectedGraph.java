package com.spacex.data.structure.graph.custom.undirected;

import java.util.LinkedList;

public class CheckUndirectedDisconnectedGraph extends AbstractUndirectedGraph {
    public CheckUndirectedDisconnectedGraph(int vertices) {
        super(vertices);
    }

    /**
     * If each vertex of a graph is connected to one or multiple vertices
     * then the graph is called a Connected graph
     * whereas
     * if there exists even one vertex which is not connected to any vertex of the graph
     * then it is called Disconnect or not connected graph.
     *
     * @return
     */
    public boolean isConnected() {
        int vertices = this.vertices;
        LinkedList<Integer>[] adjList = this.adjList;
        boolean[] visited = new boolean[vertices];

        // start the DFS from 0
        dfs(0, adjList, visited);

        // check if all the vertices are visited,if yes and then graph is connected
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }

        if (vertices == count) {
            System.out.println("Given graph is connected!");
            return true;
        } else {
            System.out.println("Given graph is not connected!");
            return false;
        }
    }

    public void dfs(int source, LinkedList<Integer>[] adjList, boolean[] visited) {
        // mark the vertex visited
        visited[source] = true;

        //travel the neighbour
        for (int i = 0; i < adjList[source].size(); i++) {
            int neighbour = adjList[source].get(i);
            if (visited[neighbour] == false) {// if neighbour hasn't been visited
                //make recursive call from neighbor
                dfs(neighbour, adjList, visited);
            }
        }
    }
}
