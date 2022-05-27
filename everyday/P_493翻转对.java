package com.pan.leetcode.everyday;

public class P_493翻转对 {
    private int ret;
    public int reversePairs(int[] nums) {
        ret = 0;
        mergeSort(nums, 0, nums.length-1);
        return ret;
    }
    private void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = (left + right)>>1;
        mergeSort(nums,left, mid);
        mergeSort(nums,mid+1, right);
        int i = left, j = mid+1;
        //要先统计，再合并
        while(i<=mid){
            while(j<=right && (long)nums[i]<=(long)2*nums[j]) j++;
            ret += right - j + 1;
            i++;
        }
        int[] temp = new int[right - left + 1];
        int l=left, r=mid+1, inx=0;
        while(l<=mid || r<=right){
            if(l>mid)
                temp[inx++] = nums[r++];
            else if(r>right)
                temp[inx++] = nums[l++];
            else{
                if(nums[l]>=nums[r])
                    temp[inx++] = nums[l++];
                else
                    temp[inx++] = nums[r++];
            }
        }
        inx = 0;
        for (int k = left; k <= right; k++) {
            nums[k] = temp[inx++];
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+" ");
//        }
//        System.out.println("  "+ret);
    }
}
