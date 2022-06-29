package com.spacex.data.structure.graph.custom.undirected;

import java.util.LinkedList;
import java.util.Queue;

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
        return true;
    }

    public boolean isBipartiteWithBFS() {
        // check if graph is empty
        if (this.vertices == 0) {
            return true;
        }

        Color[] colors = new Color[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            colors[i] = Color.WHITE;
        }

        Queue<Integer> queue = new LinkedList<>();
        // start coloring vertices , this code will handle the disconnected graph as well
        // color the first vertex withe RED
        for (int source = 0; source < this.vertices; source++) {
            if (colors[source] == Color.WHITE) {
                colors[source] = Color.RED;

                // add it to queue for bfs
                queue.offer(source);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int i = 0; i < this.adjList[v].size(); i++) {
                        int dest = this.adjList[v].get(i);
                        if (colors[dest] == Color.WHITE) {
                            //color is with the alternate color of vertex v
                            if (colors[v] == Color.RED) {
                                colors[dest] = Color.GREEN;
                            } else if (colors[v] == Color.GREEN) {
                                colors[dest] = Color.RED;
                            }

                            // add vertex dest to queue
                            queue.add(dest);
                        } else if (colors[v] == colors[dest]) {
                            // means vertex v and dest are in same color, so graph is not bipartite
                            return false;
                        }
                    }
                }
            }
        }

        // if here means graph is successfully colored in two color, RED & GREEN
        // graph is bipartite

        return true;
    }
}
