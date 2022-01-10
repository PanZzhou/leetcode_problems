package com.pan.leetcode.tree;

public class P_99恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        morris(root);
    }
    private void morris(TreeNode node){
        TreeNode cur = node;
        TreeNode mostRight = null;
        TreeNode visited = null;
        TreeNode tar1 = null;
        TreeNode tar2 = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if(mostRight.right != cur){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else
                    mostRight.right = null;
            }
            if(visited!=null && visited.val>cur.val){
                if (tar1==null){
                    tar1 = visited;
                    tar2 = cur;
                }else{
                    tar2 = cur;
                }
            }
            visited = cur;
            cur = cur.right;
        }
        int temp = tar1.val;
        tar1.val = tar2.val;
        tar2.val = temp;
    }
}
