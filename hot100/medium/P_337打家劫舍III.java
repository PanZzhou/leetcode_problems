package com.pan.leetcode.hot100.medium;

import com.pan.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class P_337打家劫舍III {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] neighbour = curse(root);
        return Math.max(neighbour[1], neighbour[0]);
    }
    private int[] curse(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] left = curse(root.left);
        int[] right = curse(root.right);
        int nei = root.val + left[1]+ right[1];
        int notnei = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        return new int[]{nei, notnei};
    }
}
