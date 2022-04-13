package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P_剑指Offer54二叉搜索树的第k大节点 {
    private int ret;
    private int num;
    public int kthLargest(TreeNode root, int k) {
        num = k;
        kth(root);
        return ret;
    }
    private void kth(TreeNode root){
        if(root == null || num == 0) return;
        kth(root.right);//从右边开始遍历，因为是要找到第k大的数字
        //采用中序遍历
        num--;
        if(num == 0){
            ret = root.val;
            return;
        }
        kth(root.left);
    }
}
