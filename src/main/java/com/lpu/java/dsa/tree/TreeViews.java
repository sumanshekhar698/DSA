package com.lpu.java.dsa.tree;

import java.util.*;

/**
 * Utilities to compute different "views" of a binary tree.
 */
public final class TreeViews {

    private static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // ---------- LEFT VIEW ----------
    // First node you see at every level when looking from the left.
    public static List<Integer> leftView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (i == 0) res.add(cur.val);          // first node of this level
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }

    // ---------- RIGHT VIEW ----------
    // First node you see at every level when looking from the right.
    public static List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (i == sz - 1) res.add(cur.val);      // last node of this level
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }

    // Helper record/class to carry node + horizontal distance (hd)
    private static final class HdNode {
        TreeNode node;
        int hd;

        HdNode(TreeNode n, int h) {
            this.node = n;
            this.hd = h;
        }
    }

    // ---------- TOP VIEW ----------
    // For each horizontal distance, keep the first node we encounter (smallest level).
    public static List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> hdToVal = new TreeMap<>(); // keeps keys (hd) sorted
        Queue<HdNode> q = new ArrayDeque<>();
        q.offer(new HdNode(root, 0));

        while (!q.isEmpty()) {
            HdNode cur = q.poll();
            // only put if we haven't seen this horizontal distance yet
            hdToVal.putIfAbsent(cur.hd, cur.node.val);

            if (cur.node.left != null) q.offer(new HdNode(cur.node.left, cur.hd - 1));
            if (cur.node.right != null) q.offer(new HdNode(cur.node.right, cur.hd + 1));
        }

        res.addAll(hdToVal.values());
        return res;
    }

    // ---------- BOTTOM VIEW ----------
    // For each horizontal distance, keep the last node we encounter (deepest level in BFS order).
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, Integer> hdToVal = new TreeMap<>();
        Queue<HdNode> q = new ArrayDeque<>();
        q.offer(new HdNode(root, 0));

        while (!q.isEmpty()) {
            HdNode cur = q.poll();
            // overwrite every time; last seen at this hd will remain
            hdToVal.put(cur.hd, cur.node.val);

            if (cur.node.left != null) q.offer(new HdNode(cur.node.left, cur.hd - 1));
            if (cur.node.right != null) q.offer(new HdNode(cur.node.right, cur.hd + 1));
        }

        res.addAll(hdToVal.values());
        return res;
    }

    // ------------ demo ------------
    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6)));

        System.out.println("Left view:   " + leftView(root));    // [1, 2, 4]
        System.out.println("Right view:  " + rightView(root));   // [1, 3, 6]
        System.out.println("Top view:    " + topView(root));     // [4, 2, 1, 3, 6]
        System.out.println("Bottom view: " + bottomView(root));  // [4, 2, 5, 3, 6]
    }
}
