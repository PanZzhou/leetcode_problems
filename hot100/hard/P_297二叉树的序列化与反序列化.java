package com.pan.leetcode.hot100.hard;

import com.pan.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P_297二叉树的序列化与反序列化 {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        sb.append(root.val);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left == null)
                sb.append(",null");
            else{
                queue.offer(cur.left);
                sb.append(',').append(cur.left.val);
            }
            if(cur.right == null)
                sb.append(",null");
            else{
                queue.offer(cur.right);
                sb.append(',').append(cur.right.val);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split(",");
        if(datas.length == 0 || datas[0].equals("")) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.offer(root);
        int inx = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!datas[inx].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(datas[inx]));
                cur.left = left;
                queue.offer(left);
            }
            ++inx;
            if(!datas[inx].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(datas[inx]));
                cur.right = right;
                queue.offer(right);
            }
            ++inx;
        }
        return root;
    }
}
