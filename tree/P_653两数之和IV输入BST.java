package com.pan.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class P_653两数之和IV输入BST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int high = list.size()-1;
        int low = 0;
        while(low<high){
            int sum = list.get(low) + list.get(high);
            if(sum==k)
                return true;
            else if(sum < k)
                low++;
            else
                high--;
        }
        return false;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root!=null){
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
