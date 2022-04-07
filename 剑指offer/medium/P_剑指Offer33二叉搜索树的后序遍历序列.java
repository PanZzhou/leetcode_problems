package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer33二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length-1);
    }
    private boolean recur(int[] postorder, int i, int j){
        if(i>=j) return true;
        int targetInx = i, next;
        while(targetInx < j && postorder[targetInx]<postorder[j]) targetInx++;
        next = targetInx;
        while(next<j){
            if(postorder[next] < postorder[j])
                return false;
            next++;
        }
        return recur(postorder, i, targetInx-1) && recur(postorder, targetInx, j-1);
    }
}
