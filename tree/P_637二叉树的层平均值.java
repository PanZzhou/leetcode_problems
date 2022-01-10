package com.pan.leetcode.tree;

import java.util.*;

public class P_637二叉树的层平均值 {
    private List<Double> list;
    private Deque<TreeNode> q;
    public List<Double> averageOfLevels(TreeNode root) {
        list = new ArrayList<>();
        if(null==root)
            return list;
        q = new LinkedList<>();
        q.offer(root);
        average(1);
        return list;
    }
    private  void average(int count){
        double sum = 0;
        int old_count = count;
        int new_count = 0;
        TreeNode temp = null;
        while(count>0){
            temp = q.poll();
            if(temp!=null&&temp.left!=null){
                q.offer(temp.left);
                new_count++;
            }
            if(temp!=null&&temp.right!=null){
                q.offer(temp.right);
                new_count++;
            }
            sum+=temp.val;
            count--;
        }
        list.add(sum/old_count);
        if(!q.isEmpty())
            average(new_count);
    }
}
