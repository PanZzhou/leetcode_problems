package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer28对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSym(root.left, root.right);
    }
    private boolean isSym(TreeNode first, TreeNode second){
        if(first == null && second == null)
            return true;
        if(first == null || second == null)
            return false;
        return first.val == second.val && isSym(first.left, second.right) && isSym(first.right, second.left);
    }
}
