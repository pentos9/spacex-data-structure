package com.spacex.data.structure.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class ListDirectGraph<V> implements IDirectGraph<V> {

    private List<GraphNode<V>> graphNodeList;

    public ListDirectGraph() {
        this.graphNodeList = new ArrayList<>();
    }

    @Override
    public void addVertex(V v) {
        GraphNode<V> graphNode = new GraphNode<>(v);
        this.graphNodeList.add(graphNode);
    }

    /**
     * 移除一个顶点，所有和这个顶点关联的边，都要被移除
     *
     * @param v
     * @return
     */
    @Override
    public boolean removeVertex(V v) {
        Iterator<GraphNode<V>> edgeIterator = this.graphNodeList.iterator();
        while (edgeIterator.hasNext()) {
            GraphNode<V> graphNode = edgeIterator.next();
            if (v.equals(graphNode.getVertex())) {
                edgeIterator.remove();
            }
        }
        return true;
    }

    @Override
    public V getVertex(int index) {
        return this.graphNodeList.get(index).getVertex();
    }

    /**
     * 如果新增一条边，就遍历整个列表。
     * 如果存在这条起始节点，则新增这条边；
     * 如果不存在，则可以报错。
     *
     * @param edge
     */
    @Override
    public void addEdge(Edge<V> edge) {
        for (GraphNode<V> graphNode : this.graphNodeList) {
            V from = edge.getFrom();
            V vertex = graphNode.getVertex();
            if (from.equals(vertex)) {
                graphNode.getEdgeSet().add(edge);
            }
        }
    }

    @Override
    public boolean removeEdge(Edge<V> edge) {
        GraphNode<V> graphNode = getGraphNode(edge);
        if (graphNode != null) {
            graphNode.remove(edge.getTo());
        }
        return true;
    }

    /**
     * 获取图节点
     *
     * @param edge
     * @return
     */
    private GraphNode<V> getGraphNode(Edge<V> edge) {
        for (GraphNode<V> graphNode : this.graphNodeList) {
            final V from = edge.getFrom();
            if (graphNode.getVertex().equals(from)) {
                return graphNode;
            }
        }
        return null;
    }

    @Override
    public Edge<V> getEdge(int from, int to) {
        V toVertex = getVertex(to);
        GraphNode<V> fromNode = this.graphNodeList.get(from);
        return fromNode.get(toVertex);
    }

    public List<V> bfs(final V root) {
        List<V> visitedList = new ArrayList<>();
        Queue<V> visitingQueue = new LinkedList<>();

        visitingQueue.offer(root);
        V vertex = visitingQueue.poll();

        while (vertex != null) {
            GraphNode<V> graphNode = getGraphNode(vertex);
            if (graphNode != null) {
                Set<Edge<V>> edgeSet = graphNode.getEdgeSet();
                for (Edge<V> edge : edgeSet) {
                    V target = edge.getTo();
                    if (!visitedList.contains(target)
                            && !visitingQueue.contains(target)) {
                        visitingQueue.offer(target);
                    }
                }
            }

            visitedList.add(vertex);
            vertex = visitingQueue.poll();
        }
        return visitedList;
    }

    private GraphNode<V> getGraphNode(V vertex) {
        for (GraphNode<V> node : this.graphNodeList) {
            if (vertex.equals(node.getVertex())) {
                return node;
            }
        }
        return null;
    }

    public List<V> dfs(final V root) {
        List<V> visitedList = new ArrayList<>();
        Stack<V> visitingStack = new Stack<>();

        // 顶点压入栈顶
        visitingStack.push(root);

        while (!visitingStack.isEmpty()) {
            V visitingVertex = visitingStack.peek();
            GraphNode<V> graphNode = getGraphNode(visitingVertex);
            boolean hasPush = false;
            if (graphNode != null) {
                Set<Edge<V>> edgeSet = graphNode.getEdgeSet();
                for (Edge<V> edge : edgeSet) {
                    V to = edge.getTo();
                    if (!visitedList.contains(to)
                            && !visitingStack.contains(to)) {
                        visitingStack.push(to);
                        hasPush = true;
                        break;
                    }
                }
            }

            if (!hasPush) {
                visitedList.add(visitingStack.pop());
            }
        }

        return visitedList;
    }
}
