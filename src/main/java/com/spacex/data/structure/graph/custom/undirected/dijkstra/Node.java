package com.spacex.data.structure.graph.custom.undirected.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private String name;
    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        this.adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + ", shortestPath=" + shortestPath + '}';
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "name='" + name + '\'' +
//                ", shortestPath=" + shortestPath +
//                ", distance=" + distance +
//                ", adjacentNodes=" + adjacentNodes +
//                '}';
//    }
}
