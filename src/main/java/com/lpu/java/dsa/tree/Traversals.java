package com.lpu.java.dsa.tree;

import java.util.*;

public class Traversals {

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

    // ---------- Recursive ----------
    public static List<Integer> preorderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderRec(root, res);
        return res;
    }

    private static void preorderRec(TreeNode n, List<Integer> res) {
        if (n == null) return;
        res.add(n.val);
        preorderRec(n.left, res);
        preorderRec(n.right, res);
    }

    public static List<Integer> inorderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderRec(root, res);
        return res;
    }

    private static void inorderRec(TreeNode n, List<Integer> res) {
        if (n == null) return;
        inorderRec(n.left, res);
        res.add(n.val);
        inorderRec(n.right, res);
    }

    public static List<Integer> postorderRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderRec(root, res);
        return res;
    }

    private static void postorderRec(TreeNode n, List<Integer> res) {
        if (n == null) return;
        postorderRec(n.left, res);
        postorderRec(n.right, res);
        res.add(n.val);
    }

    // ---------- Iterative ----------
    public static List<Integer> preorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
        return res;
    }

    public static List<Integer> inorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    // One-stack postorder (push right child marker) or two-stack version.
    // Here’s the common two-stack version (simple & clear):
    public static List<Integer> postorderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }
        while (!s2.isEmpty()) res.add(s2.pop().val);
        return res;
    }

    // ---------- Generic DFS using a stack (preorder order) ----------
    public static List<Integer> dfs(TreeNode root) {
        return preorderIter(root); // preorder is a DFS
    }

    // ---------- (Optional) BFS / level-order ----------
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>(sz);
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        // Build a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6)));

//        PreOrder :: Root L R`
//        InOrder  :: L Root R
//        Post Order :: L R Root


        System.out.println("Preorder  (rec): " + preorderRec(root));   // [1,2,4,5,3,6]
        System.out.println("Inorder   (rec): " + inorderRec(root));    // [4,2,5,1,3,6]
        System.out.println("Postorder (rec): " + postorderRec(root));  // [4,5,2,6,3,1]

        System.out.println("Preorder  (iter): " + preorderIter(root)); // [1,2,4,5,3,6]
        System.out.println("Inorder   (iter): " + inorderIter(root));  // [4,2,5,1,3,6]
        System.out.println("Postorder (iter): " + postorderIter(root));// [4,5,2,6,3,1]

        System.out.println("DFS (stack/preorder): " + dfs(root));      // [1,2,4,5,3,6]
        System.out.println("Level order (BFS): " + levelOrder(root));  // [[1],[2,3],[4,5,6]]
    }
}
