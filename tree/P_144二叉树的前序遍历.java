package com.pan.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P_144二叉树的前序遍历 {
    List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<>();
//        preorder(root);//递归版本
//        preorderStack(root);
        preordermorris(root);
        return list;
    }

    private void preordermorris(TreeNode root){
        TreeNode cur = root;
        TreeNode mostRight = null;
        while(cur!=null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right!=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    list.add(cur.val);
                    cur = cur.left;
                    continue;
                }else
                    mostRight.right = null;
            }else
                list.add(cur.val);
            cur = cur.right;
        }
    }

    //非递归版本：栈
    private void preorderStack(TreeNode node){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode topNode = node;
        while(topNode!=null || !stack.isEmpty()){
            while(topNode!=null){
                stack.push((topNode));
                list.add(topNode.val);
                topNode = topNode.left;
            }
            topNode = stack.pop();
            topNode = topNode.right;
        }
    }

    //递归版本
    private void preorder(TreeNode node){
        if(null!=node){
            list.add(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
