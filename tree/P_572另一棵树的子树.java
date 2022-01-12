package com.pan.leetcode.tree;

public class P_572另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        return isSub(root, subRoot);
    }

    private boolean isSub(TreeNode root, TreeNode subRoot){
        return subtree(root, subRoot) || (root!=null && (isSub(root.left, subRoot) || isSub(root.right, subRoot)));
    }

    private boolean subtree(TreeNode node, TreeNode subNode){
        if(subNode == null && node == null)
            return true;
        if(node == null || subNode == null)
            return false;
        if(node.val != subNode.val)
            return false;
        return subtree(node.left, subNode.left) && subtree(node.right, subNode.right);
    }
}
