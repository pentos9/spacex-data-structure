package com.spacex.data.structure.test.tree;

import java.util.ArrayDeque;

public class SameTreeTest {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (!check(p, q)) {
            return false;
        }

        ArrayDeque<TreeNode> depP = new ArrayDeque<>();
        ArrayDeque<TreeNode> depQ = new ArrayDeque<>();

        depP.addLast(p);
        depQ.addLast(q);

        while (!depP.isEmpty()) {
            p = depP.removeFirst();
            q = depQ.removeFirst();

            if (!check(p, q)) {
                return false;
            }

            if (p != null) {
                if (!check(p.left, q.left)) {
                    return false;
                }

                if (p.left != null) {
                    depP.addLast(p.left);
                    depQ.addLast(q.left);
                }

                if (!check(p.right, q.right)) {
                    return false;
                }

                if (p.right != null) {
                    depP.addLast(p.right);
                    depQ.addLast(q.right);
                }
            }
        }

        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        return isCorrect(left, right);
    }

    private boolean isCorrect(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val
                && isCorrect(left.left, right.right)
                && isCorrect(left.right, right.left);
    }
}