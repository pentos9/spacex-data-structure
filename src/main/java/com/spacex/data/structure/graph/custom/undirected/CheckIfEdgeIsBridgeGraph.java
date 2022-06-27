package com.spacex.data.structure.graph.custom.undirected;

public class CheckIfEdgeIsBridgeGraph extends AbstractUndirectedGraph {
    public CheckIfEdgeIsBridgeGraph(int vertices) {
        super(vertices);
    }

    public int countConnectedComponents() {
        boolean[] visited = new boolean[this.vertices];
        int count = 0;
        int index;
        while ((index = checkGraphIsVisited(visited)) != -1) {
            dfs(index, visited);
            count++;
        }
        return count;
    }

    public int checkGraphIsVisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private void dfs(int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < this.adjList[start].size(); i++) {
            int destination = adjList[start].get(i);
            if (!visited[destination]) {
                dfs(destination, visited);
            }
        }
    }

    public boolean edgeIsBridge(int source, int destination) {
        // count the connected components
        int count = countConnectedComponents();

        // remove the given edge
        this.removeEdge(source, destination);

        int newCount = countConnectedComponents();

        if (count == newCount) {
            System.out.println("Given edge (" + source + "-" + destination + ") is NOT a bridge");
            return false;
        } else {
            System.out.println("Given edge (" + source + "-" + destination + ") is a bridge");
            // add the given edge back to graph
            this.addEdge(source, destination);

            return true;
        }
    }
}
