package com.pan.leetcode.剑指offer.hard;

public class P_剑指Offer51数组中的逆序对 {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length-1);
    }
    private int merge(int[] nums, int i, int j){
        if(i>=j) return 0;
        int mid = (i+j)/2;
        int left = merge(nums, i, mid);
        int right = merge(nums, mid+1, j);
        int[] temp = new int[j-i+1];
        int l = i, r=mid+1, inx=0, ret=0;
        while(l<=mid || r<=j){
            if(l>mid || r<=j && nums[l]>nums[r]){
                temp[inx++] = nums[r++];
                ret += mid - l + 1;
            }else
                temp[inx++] = nums[l++];
        }
        for (int k = i; k <= j; k++) {
            nums[k] = temp[k-i];
        }
        return left+right+ret;
    }
}
