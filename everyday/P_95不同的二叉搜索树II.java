package com.pan.leetcode.everyday;

import com.pan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_95不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if(n == 0)
            return ret;
        return generateTrees(1,n);
    }
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> ret = new ArrayList<>();
        if(start > end){
            ret.add(null);
            return ret;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
