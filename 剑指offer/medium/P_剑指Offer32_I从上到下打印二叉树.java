package com.pan.leetcode.剑指offer.medium;

import com.pan.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P_剑指Offer32_I从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        int size = dfs(root);
        Deque<TreeNode> queue = new ArrayDeque<>();
        int ret[] = new int[size];
        queue.offer(root);
        int inx = 0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            ret[inx++] = top.val;
            if(top.left != null)
                queue.offer(top.left);
            if(top.right != null)
                queue.offer(top.right);
        }
        return ret;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        return 1+dfs(root.left)+dfs(root.right);
    }
}
