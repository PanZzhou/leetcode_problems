package com.pan.leetcode.剑指offer.medium;

import com.pan.leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

public class P_剑指Offer26树的子结构 {
    //自己本身也要递归，分别对每个节点的子树递归
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    //判断当前节点递归次数是否符合
    private boolean hasSubStructure(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null || A.val != B.val)
            return false;
        return hasSubStructure(A.left, B.left) && hasSubStructure(A.right, B.right);
    }
}
