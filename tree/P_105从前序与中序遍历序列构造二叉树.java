package com.pan.leetcode.tree;

public class P_105从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, preorder.length);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preinx, int ininx, int prelen){
        if(prelen<=0)
            return null;
        TreeNode node = new TreeNode(preorder[preinx]);
        int tarinx = ininx;
        for (int i = ininx; i < ininx+prelen; i++) {
            if(inorder[i] == preorder[preinx]){
                tarinx = i;
                break;
            }
        }
        int newprelen = tarinx-ininx;
        int newpostlen = prelen-newprelen-1;
        node.left = build(preorder, inorder, preinx+1, ininx, newprelen);
        node.right = build(preorder, inorder, preinx+newprelen+1, tarinx+1, newpostlen);
        return node;
    }
}
