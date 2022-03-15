package com.pan.leetcode.sort;

public class P_215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) return Integer.MIN_VALUE;
        buildHeap(nums);
        for (int i = nums.length; i > nums.length - k + 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i - 1];
            nums[i - 1] = temp;
            adjustHeap(nums, 1, i - 1);
        }
        //建立的是大顶堆，初始时堆顶就是最大值，调一次之后堆顶就是第二大值
        return nums[0];
    }

    private void buildHeap(int[] nums){
        for (int i = nums.length/2; i > 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    private void adjustHeap(int[] nums, int k, int end){
        int temp = nums[k-1];
        for (int i = 2*k; i <= end; i*=2) {
            if(i<end && nums[i-1]<nums[i]) i++;
            if(temp > nums[i-1]) break;
            else{
                nums[k-1] = nums[i-1];
                k = i;
            }
        }
        //别忘了把这个空位设置好
        nums[k-1] = temp;
    }
}
