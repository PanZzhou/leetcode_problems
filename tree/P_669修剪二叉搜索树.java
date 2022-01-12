package com.pan.leetcode.tree;

public class P_669修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(null == root) return root;
        if(root.val < low) return trimBST(root.right, low, high);//如果当前节点值小于范围值，那么其左子树一定都小于范围值，所以返回右子树即可；
        if(root.val > high) return trimBST(root.left, low, high);//如果当前节点值大于范围值，那么其右子树一定都大于范围值，所以返回左子树即可

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
