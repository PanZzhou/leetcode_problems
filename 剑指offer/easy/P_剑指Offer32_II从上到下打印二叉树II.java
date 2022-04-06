package com.pan.leetcode.剑指offer.easy;

import com.pan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_剑指Offer32_II从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            while(size-->0){
                TreeNode top = queue.poll();
                ans.add(top.val);
                if(top.left != null)
                    queue.offer(top.left);
                if(top.right != null)
                    queue.offer(top.right);
            }
            ret.add(ans);
        }
        return ret;
    }
}
