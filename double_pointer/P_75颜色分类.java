package com.pan.leetcode.double_pointer;


public class P_75颜色分类 {
    public void sortColors(int[] nums) {
        int first =0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                swap(nums,second,i);
                second++;
            }
            if(nums[i]==0){
                swap(nums,first,i);
                if(first<second){
                    swap(nums,second,i);
                }
                first++;
                second++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
