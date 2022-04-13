package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer55_II平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root)>0;
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
