package com.pan.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_94二叉树的中序遍历 {
    private List<Integer> ret;
    public List<Integer> inorderTraversal(TreeNode root) {
        ret = new ArrayList<>();
//        inorder(root);    //递归形式。
//        inorderstack(root);  //非递归栈形式
        inordermorris(root);
        return ret;
    }

    //morris中序遍历
    private void inordermorris(TreeNode node){
        TreeNode cur = node;
        TreeNode mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right!=null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else
                    mostRight.right = null;
            }
            ret.add(cur.val);
            cur = cur.right;
        }
    }

    private void inorderstack(TreeNode node){
        if(node==null)
            return;
        Deque<TreeNode> stack = new LinkedList<>();
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            ret.add(node.val);
            node=node.right;
        }
    }

    private void inorder(TreeNode root, List<Integer> ret){
        if(root==null)
            return;
        inorder(root.left,ret);
        ret.add(root.val);
        inorder(root.right,ret);
    }
}
