package com.pan.leetcode.array;

public class P_55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxStep = 0;
        for (int i = 0; i < len; i++) {
            if(i<=maxStep){
                maxStep = Math.max(maxStep,nums[i]+i);
                if(maxStep>=len-1)
                    return true;
            }
        }
        return false;
    }
}
