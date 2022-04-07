package com.pan.leetcode.剑指offer.medium;

import com.pan.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P_剑指Offer34二叉树中和为某一值的路径 {
    List<List<Integer>> ret;
    List<Integer> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ret = new ArrayList<>();
        ans = new ArrayList<>();
        if(root == null) return new ArrayList<>(ret);
        path(root, target, 0);
        return ret;
    }
    private void path(TreeNode root, int target, int sum){
        if(root.left == null && root.right == null){
            if(target == sum+root.val){
                ans.add(root.val);
                ret.add(new ArrayList<>(ans));
                ans.remove(ans.size()-1);
            }
        }else{
            ans.add(root.val);
            if(root.left != null)
                path(root.left, target, sum+root.val);
            if(root.right != null)
                path(root.right, target, sum+root.val);
            ans.remove(ans.size()-1);
        }
    }
}
