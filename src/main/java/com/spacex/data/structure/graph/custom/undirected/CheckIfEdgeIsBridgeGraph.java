package com.spacex.data.structure.graph.custom.undirected;

public class CheckIfEdgeIsBridgeGraph extends AbstractUndirectedGraph {
    public CheckIfEdgeIsBridgeGraph(int vertices) {
        super(vertices);
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
