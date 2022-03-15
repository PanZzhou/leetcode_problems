package com.pan.leetcode.sort;

public class P_75颜色分类 {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length-1;
        for (int i = 0; i <= high; i++) {
            while(i<=high && nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[high];
                nums[high] = temp;
                high--;
            }
            //要保持i不落后于low
            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[low];
                nums[low] = temp;
                low++;
            }
        }
    }
}
