package com.pan.leetcode.tree;

public class P_404左叶子之和 {
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        sumOfLeft(root, 0);
        return sum;
    }
    private void sumOfLeft(TreeNode node, int tag){
        if(node != null){
            if(node.left==null && node.right == null && tag == 1)
                sum+=node.val;
            sumOfLeft(node.left, 1);
            sumOfLeft(node.right, 0);
        }
    }
}
