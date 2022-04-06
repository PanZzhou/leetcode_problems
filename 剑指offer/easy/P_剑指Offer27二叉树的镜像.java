package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return root;
        dealTree(root);
        return root;
    }
    private void dealTree(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            dealTree(root.left);
            dealTree(root.right);
        }
    }
}
