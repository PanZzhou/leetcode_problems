package com.pan.leetcode.hot100.medium;

import com.pan.leetcode.tree.TreeNode;

public class P_98验证二叉搜索树 {
    TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
        if(root != null){
            boolean left = isValidBST(root.left);
            if(!left || preNode != null && preNode.val >= root.val)
                return false;
            preNode = root;
            return isValidBST(root.right);
        }
        return true;
    }
}
