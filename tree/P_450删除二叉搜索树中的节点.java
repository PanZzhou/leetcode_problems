package com.pan.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class P_450删除二叉搜索树中的节点 {
    //遍历过程不能改变树结构：不能用morris遍历
    //只遍历一遍的话不能正确删除节点，用递归删除。
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        else{
            if(root.right == null && root.left == null) return null;
            else if(root.right != null){
                root.val = successor(root).val;
                root.right = deleteNode(root.right, root.val);
            }else {
                root.val = predecessor(root).val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    //找该节点的后继节点
    public TreeNode successor(TreeNode root){
        if(root==null)
            return null;
        TreeNode node = root.right;
        while(node!=null&&node.left!=null) node = node.left;
        return node;
    }

    //找该节点的前驱节点
    public TreeNode predecessor(TreeNode root){
        if(root==null)
            return null;
        TreeNode node = root.left;
        while(node!=null && node.right!=null) node = node.right;
        return node;
    }
}
