package com.pan.leetcode.剑指offer.medium;

import com.pan.leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class P_剑指Offer32_III从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean level = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> ans = new ArrayList<>(size);
            while(size-->0){
                TreeNode top;
                if(!level){
                    //从后面取
                    top = queue.pollFirst();
                    //从前面插入
                    if(top.left != null)//先左后右
                        queue.offerLast(top.left);
                    if(top.right != null)
                        queue.offerLast(top.right);
                }else{
                    //从前面取
                    top = queue.pollLast();
                    //从后面插入
                    if(top.right != null)//先右后左
                        queue.offerFirst(top.right);
                    if(top.left != null)
                        queue.offerFirst(top.left);
                }
                ans.add(top.val);
            }
            ret.add(ans);
            level = !level;
        }
        return ret;
    }
}
