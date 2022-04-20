package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer68_I二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
