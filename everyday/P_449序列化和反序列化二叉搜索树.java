package com.pan.leetcode.everyday;

import com.pan.leetcode.tree.TreeNode;

import java.util.*;

public class P_449序列化和反序列化二叉搜索树 {
    List<Integer> ans;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ans = new ArrayList<>();
        postOrder(root);
        String str = ans.toString();
        return str.substring(1,str.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] str = data.split(", ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++) {
            stack.push(Integer.parseInt(str[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        ans.add(root.val);
    }

    private TreeNode construct(int low, int high, Deque<Integer> stack){
        if(stack.isEmpty() || stack.peek()<low || stack.peek() > high || low > high)
            return null;
        int cur = stack.poll();
        TreeNode root = new TreeNode(cur);
        root.right = construct(cur, high, stack);
        root.left = construct(low, cur, stack);
        return root;
    }
}
