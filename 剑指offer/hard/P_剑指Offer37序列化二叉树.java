package com.pan.leetcode.剑指offer.hard;

import com.pan.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P_剑指Offer37序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            if(front != null){
                queue.offer(front.left);
                queue.offer(front.right);
                sb.append(front.val).append(',');
            }else
                sb.append("null,");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        //根据逗号把字符串拆分长字符串数组
        String[] split = data.split(",");
        //字符串转数字
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            if(split[i].equals("null")){
                front.left = null;
            }else{
                front.left = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(front.left);
            }
            i++;
            if(split[i].equals("null"))
                front.right = null;
            else{
                front.right = new TreeNode(Integer.parseInt(split[i]));
                queue.offer(front.right);
            }
            i++;
        }
        return root;
    }
}
