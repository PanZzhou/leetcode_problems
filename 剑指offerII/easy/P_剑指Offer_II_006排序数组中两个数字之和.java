package com.pan.leetcode.剑指offerII.easy;

public class P_剑指Offer_II_006排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1,sum;
        while(left < right){
            sum = numbers[left] + numbers[right];
            if(sum > target)
                right--;
            else if(sum < target)
                left++;
            else
                break;
        }
        if(left>=right)
            return new int[2];
        return new int[]{left, right};
    }
}
