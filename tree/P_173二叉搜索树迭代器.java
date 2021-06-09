package com.pan.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class P_173二叉搜索树迭代器 {
    TreeNode cur;
    Deque<TreeNode> stack;
    public P_173二叉搜索树迭代器(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while(cur!=null){
            stack.push(cur);
            cur=cur.left;
        }
        cur=stack.pop();
        int res = cur.val;
        cur=cur.right;
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty()||cur!=null;
    }
}
