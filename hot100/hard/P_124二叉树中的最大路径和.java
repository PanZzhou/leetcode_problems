package com.pan.leetcode.hot100.hard;

import com.pan.leetcode.tree.TreeNode;

public class P_124二叉树中的最大路径和 {
    private int ret;
    public int maxPathSum(TreeNode root) {
        ret = Integer.MIN_VALUE;
        if(root == null) return ret;
        maxDeepSum(root);
        return ret;
    }
    private int maxDeepSum(TreeNode root){
        ret = Math.max(root.val, ret);
        if(root.left == null && root.right == null) return root.val;
        int left = 0, right = 0;
        if(root.left != null){
            left = maxDeepSum(root.left);
            ret = Math.max(left, ret);
            ret = Math.max(left+root.val, ret);
        }
        if(root.right != null){
            right = maxDeepSum(root.right);
            ret = Math.max(right, ret);
            ret = Math.max(right+root.val,ret);
        }
        if(root.left != null && root.right != null)
            ret = Math.max(left+right+root.val, ret);
        if(left<0 && right<0)
            return root.val;
        return Math.max(left, right) + root.val;
    }
}
