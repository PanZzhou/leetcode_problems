package com.pan.leetcode.剑指offer;

import com.pan.leetcode.linkedlist.ListNode;
import com.pan.leetcode.tree.TreeNode;

public class P_剑指Offer07重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rebuildTree(preorder,inorder,0,0,preorder.length);
    }
    protected TreeNode rebuildTree(int[] preorder, int[] inorder, int preIndex, int inIndex, int len){
        if(len<=0)
            return null;
        int val = preorder[preIndex];
        int oppoIndex=inIndex,leftLen,rightLen;
        for (int i = inIndex; i < inIndex+len; i++) {
            if(val==inorder[i]){
                oppoIndex=i;
                break;
            }
        }
        leftLen=oppoIndex-inIndex;
        rightLen=len-leftLen-1;
        TreeNode node = new TreeNode(val, null, null);
        node.left = rebuildTree(preorder,inorder,preIndex+1,inIndex,leftLen);
        node.right = rebuildTree(preorder,inorder,preIndex+leftLen+1,oppoIndex+1,rightLen);
        return node;
    }
}
