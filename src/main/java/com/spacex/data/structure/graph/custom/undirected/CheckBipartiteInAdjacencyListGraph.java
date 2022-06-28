package com.spacex.data.structure.graph.custom.undirected;

public class CheckBipartiteInAdjacencyListGraph extends AbstractUndirectedGraph {
    enum Color {
        WHITE, RED, GREEN;
    }

    public CheckBipartiteInAdjacencyListGraph(int vertices) {
        super(vertices);
    }

    public boolean isBipartite() {
        if (this.vertices == 0) {
            return true;
        }

        Color[] colors = new Color[this.vertices];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = Color.WHITE;
        }

        for (int i = 0; i < this.vertices; i++) {
            if (colors[i] == Color.WHITE) {
                boolean result = isBipartite(i, colors);
                if (result == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int source, Color[] colors) {

        //if is it first vertex, mark it RED
        if (source == 0) {
            colors[source] = Color.RED;
        }

        // travel all adjacent vertices
        for (int i = 0; i < this.adjList[source].size(); i++) {
            int vertex = this.adjList[source].get(i);
            if (colors[vertex] == Color.WHITE) {
                //color is with the alternate color of
                if (colors[source] == Color.RED) {
                    colors[vertex] = Color.GREEN;
                } else if (colors[source] == Color.GREEN) {
                    //if source is in red, make vertex green
                    colors[vertex] = Color.RED;
                }
                return isBipartite(vertex, colors);
            } else if (colors[source] == colors[vertex]) {
                return false;
            }// end else if
        }
        return false;
    }
}
