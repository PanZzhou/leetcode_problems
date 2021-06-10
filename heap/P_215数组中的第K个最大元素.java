package com.pan.leetcode.heap;

//法一：基于快速排序的方法
//法二：基于堆排序的方法
public class P_215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);
        for (int i = nums.length; i >nums.length-k+1; --i) {
            int temp = nums[0];
            nums[0]=nums[i-1];
            nums[i-1] = temp;
            adjustHeap(nums,1,i-1);
        }
        return nums[0];
    }
    private void buildHeap(int[] nums){
        for (int i = nums.length/2; i > 0; --i)
            adjustHeap(nums,i,nums.length);
    }
    private void adjustHeap(int[] nums,int index,int end){
        int k=nums[index-1];
        for (int i = index*2; i <= end; i=index*2) {
            if(i<end&&nums[i]>nums[i-1]) ++i;
            if(k>nums[i-1]) break;
            nums[index-1] = nums[i-1];
            index=i;
        }
        nums[index-1]=k;
    }
}
