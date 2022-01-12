package com.pan.leetcode.tree;

public class P_236二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = hasChild(root, p, q);
        if(null == ret)
            return root;
        return ret;
    }
    private TreeNode hasChild(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return root;
        TreeNode left = hasChild(root.left, p, q);
        TreeNode right = hasChild(root.right, p, q);
        if(left!=null && right!=null)
            return root;
        if(left!=null || right!=null){
            if(root.val == p.val || root.val == q.val)
                return root;
            else
                return left==null?right:left;
        }
        if(root.val != p.val && root.val != q.val)
            return null;
        return root;
    }
}
