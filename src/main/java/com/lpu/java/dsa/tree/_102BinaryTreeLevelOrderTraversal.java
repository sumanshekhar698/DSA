package com.lpu.java.dsa.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class _102BinaryTreeLevelOrderTraversal {


    public static void main(String[] args) {

    }

    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {


        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();//O(n) n/2
        if (root != null) {
            queue.addLast(root);
        }


        while (!queue.isEmpty()) {
            int size = queue.size();//size of the queue
            List<Integer> level = new ArrayList<>();//current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();//pop node from the left of the queue
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);

                }
            }

            if (!level.isEmpty()) {
                list.add(level);
            }
        }

        return list;


    }
}
