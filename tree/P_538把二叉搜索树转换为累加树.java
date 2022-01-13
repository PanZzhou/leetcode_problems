package com.pan.leetcode.tree;

import sun.reflect.generics.tree.Tree;

public class P_538把二叉搜索树转换为累加树 {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        sumSubBST(root);
        return root;
    }
    public void sumSubBST(TreeNode root){
        if(root == null)
            return;
        sumSubBST(root.right);
        sum += root.val;
        root.val = sum;
        sumSubBST(root.left);
    }
    //也可以用morris遍历
}
