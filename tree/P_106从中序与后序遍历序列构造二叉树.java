package com.pan.leetcode.tree;

public class P_106从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, 0, inorder.length);
    }
    private TreeNode build(int[] in, int[] post, int inInx, int postInx, int len){
        if(len<=0)
            return null;
        int nodeVal = post[postInx+len-1];
        TreeNode node = new TreeNode(nodeVal);
        if(len==1)
            return node;
        int tarInx = inInx;
        for (int i = inInx; i < inInx+len; i++) {
            if(in[i] == nodeVal){
                tarInx = i;
                break;
            }
        }
        int preLen = tarInx - inInx;
        node.left = build(in, post, inInx, postInx, preLen);
        node.right = build(in, post, tarInx+1, postInx+preLen, len - preLen -1);
        return node;
    }
}
