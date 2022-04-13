package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer55_I二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
