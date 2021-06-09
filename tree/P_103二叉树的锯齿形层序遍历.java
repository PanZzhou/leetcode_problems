package com.pan.leetcode.tree;

import java.util.*;

public class P_103二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean zigLeft = true;
        TreeNode top;
        int nums = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            while(nums-->0){
                top = queue.poll();
                level.add(top.val);
                if(top.left!=null)
                    queue.offer(top.left);
                if(top.right!=null)
                    queue.offer(top.right);
            }
            if(!zigLeft)
                Collections.reverse(level);
            res.add(new ArrayList<>(level));
            level.clear();
            zigLeft=!zigLeft;
            nums=queue.size();
        }
        return res;
    }
}
