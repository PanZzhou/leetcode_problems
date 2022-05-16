package com.pan.leetcode.everyday;

import com.pan.leetcode.tree.TreeNode;

public class P_面试题04_06后继者  {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null, cur = root;
        while(cur != null){
            if(cur.val < p.val){
                cur = cur.right;
            }else if(cur.val > p.val){
                pre = cur;
                cur = cur.left;
            } else{
                if(cur.right == null)
                    return pre;
                cur = cur.right;
                break;
            }
        }
        while(cur.left != null)
            cur = cur.left;
        return cur;
    }
}
