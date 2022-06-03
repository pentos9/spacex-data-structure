package com.spacex.data.structure.test.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursiveTest {

    @Test
    public void run() {
        int total = 10;
        System.out.println(recursive(total));
        System.out.println(fibonacci(5));

        print(20);
        initTree();
    }

    public int recursive(int number) {
        System.out.println("enter RecursiveTest#recursive:" + number);
        if (number <= 0) {
            return 0;
        }

        return number + recursive(--number);
    }

    public int fibonacci(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public void print(int count) {
        if (count <= 0) {
            System.out.println("THE END");
            return;
        }

        System.out.println("COUNT START:" + count);
        print(--count);
        System.out.println("COUNT END:" + count);
    }

    private class Node {
        private Node left;
        private Node right;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
    }

    private List<Object> visitList = new ArrayList<>();

    public void initTree() {
        Node root = new Node("0");
        Node left1 = new Node("1");
        root.left = left1;

        Node right1 = new Node("2");
        root.right = right1;

        Node left2 = new Node("3");
        left1.left = left2;

        Node right2 = new Node("4");
        left1.right = right2;

        Node left3 = new Node("5");
        right1.left = left3;

        Node right3 = new Node("6");
        right1.right = right3;

        System.out.println(preOrderTraverse(root));
        List<Object> list = new ArrayList<>();
        preOrderTraverseNonRecursive(root, list);
        System.out.println(list);
    }

    public List<Object> preOrderTraverse(Node root) {
        if (root == null) {
            return visitList;
        }

        System.out.println(root.data);
        visitList.add(root.data);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);

        return visitList;
    }

    /**
     * 非递归实现前序遍历 root -> left -> right
     *
     * @param root
     */
    public void preOrderTraverseNonRecursive(Node root, List<Object> visitedList) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                System.out.println("data:" + currentNode.data);
                visitedList.add(currentNode.data);
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            } else {
                Node node = stack.pop();
                currentNode = node.right;
            }
        }
    }
}
