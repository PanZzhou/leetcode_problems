package com.pan.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
//        inorder(root,ret);    //递归形式。
        if(root==null)
            return ret;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            ret.add(root.val);
            root=root.right;
        }
        return ret;
    }
    private void inorder(TreeNode root, List<Integer> ret){
        if(root==null)
            return;
        inorder(root.left,ret);
        ret.add(root.val);
        inorder(root.right,ret);
    }
}
