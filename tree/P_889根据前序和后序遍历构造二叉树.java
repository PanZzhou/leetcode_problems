package com.pan.leetcode.tree;

public class P_889根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, 0, preorder.length);
    }
    private TreeNode build(int[] pre, int[] post, int preInx, int postInx, int len){
        if(len<=0)
            return null;
        TreeNode node = new TreeNode(pre[preInx]);
        if(len == 1)
            return node;
        int tarInx = postInx;
        for (int i = postInx; i < postInx+len; i++) {
            if(post[i] == pre[preInx+1]){
                tarInx = i;
                break;
            }
        }
        int preLen = tarInx - postInx + 1;
        node.left = build(pre, post, preInx+1, postInx, preLen);
        node.right = build(pre, post, preInx+preLen+1, postInx+preLen, len-preLen-1);
        return node;
    }
}
