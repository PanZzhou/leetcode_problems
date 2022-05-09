package com.pan.leetcode.周赛.二九二场;

import com.pan.leetcode.tree.TreeNode;

public class P_6057统计值等于子树平均值的节点数 {
    private int ret;
    public int averageOfSubtree(TreeNode root) {
        ret = 0;
        curse(root);
        return ret;
    }
    private int[] curse(TreeNode root){
        if(root == null) return new int[]{0,0};
        int[] left = curse(root.left);
        int[] right = curse(root.right);
        int all_value = left[0]+right[0]+root.val;
        int nums = left[1]+right[1]+1;
        if(all_value / nums == root.val)
            ret++;
        return new int[]{all_value, nums};
    }
}
