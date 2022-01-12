package com.pan.leetcode.tree;

public class P_617合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        int sum = 0;
        TreeNode l1 = null,l2 = null,r1 = null,r2 = null;
        if(root1!=null){
            sum += root1.val;
            l1 = root1.left;
            r1 = root1.right;
        }
        if(root2 != null){
            sum += root2.val;
            l2 = root2.left;
            r2 = root2.right;
        }

        TreeNode node = new TreeNode(sum);
        node.left = mergeTrees(l1, l2);
        node.right = mergeTrees(r1, r2);
        return node;
    }
}
