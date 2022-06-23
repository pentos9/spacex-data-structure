package com.spacex.data.structure.graph.custom.undirected;

public class CheckIfTreeGraph extends AbstractUndirectedGraph {

    public CheckIfTreeGraph(int vertices) {
        super(vertices);
    }

    /**
     * if cycle is presented and graph is connected,it is a tree
     */
    public boolean CheckIfTree() {
        printGraph();

        // create visited array
        boolean[] visited = new boolean[this.vertices];

        // is cycled

        // DFS for original graph from first vertices
        boolean isCycled = isCycled(0, visited, -1);

        if (isCycled) {
            System.out.println("it is not a tree");
            return false;
        }

        for (int i = 0; i < this.vertices; i++) {
            if (!visited[i]) {
                System.out.println("it is not a tree");
                return false;
            }
        }

        System.out.println("it is a tree");
        return true;
    }

    protected boolean isCycled(int currentVertex, boolean[] visited, int parent) {
        // add this vertex to visited vertex array
        visited[currentVertex] = true;

        // visit neighbors except its direct parent
        for (int i = 0; i < this.adjList[currentVertex].size(); i++) {
            int vertex = this.adjList[currentVertex].get(i);
            if (vertex != parent) {
                //if here means this destination vertex is already visited
                //means cycle has been detected
                if (visited[vertex]) {
                    return true;
                }
            } else {
                //recursion from destination node
                if (isCycled(currentVertex, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }
}