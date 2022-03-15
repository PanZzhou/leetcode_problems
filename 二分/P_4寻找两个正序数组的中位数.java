package com.pan.leetcode.二分;

public class P_4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int midS1 = 0, midS2 = 0;
        //low = -1, high = m-1也可以，也就是说指针指到的元素也包含在下半区
        int low = 0, high = m ;//这里就是指针指到的元素包含在上半区（分界点）
        while(low <= high){
            int i = (low+high)>>1;//nums1[0...i-1]
            int j = (m+n+1)/2 - i; //nums2[0...j-1]

            int nums1_l = i==0?Integer.MIN_VALUE:nums1[i-1];
            int nums1_r = i==m?Integer.MAX_VALUE:nums1[i];
            int nums2_l = j==0?Integer.MIN_VALUE:nums2[j-1];
            int nums2_r = j==n?Integer.MAX_VALUE:nums2[j];
             if(nums1_l <= nums2_r){
                 //nums1向后移动的话，nums2就会向前移动，使得nums1_r更靠近nums2_l
                 midS1 = Math.max(nums1_l, nums2_l);//直接比较四个数即可
                 midS2 = Math.min(nums1_r, nums2_r);
                 low = i + 1;
             }else
                 high = i - 1;
        }
        return (m+n)%2==0?(midS1+midS2)/2.0:midS1;
    }
}
