package com.pan.leetcode.everyday;

import com.pan.leetcode.tree.TreeNode;

public class P_965单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.left.val != root.val) return false;
        if(root.right != null && root.right.val != root.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
