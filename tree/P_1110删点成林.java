package com.pan.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class P_1110删点成林 {
    private boolean[] del_set = new boolean[1001];
    List<TreeNode> list = new LinkedList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int num:to_delete)
            del_set[num] = true;
        if(!del_set[root.val])
            list.add(root);
        del(root);
        return list;
    }
    private TreeNode del(TreeNode node){
        if(null==node)
            return node;
        node.left = del(node.left);//子节点被删除就直接赋值null
        node.right = del(node.right);
        if(del_set[node.val]) {
            if (node.left != null && !del_set[node.left.val]) {
                list.add(node.left);
                node.left = null;
            }
            if (node.right != null && !del_set[node.right.val]) {
                list.add(node.right);
                node.right = null;
            }
            return null;//被删除了之后就直接返回null
        }
        return node;
    }
}
