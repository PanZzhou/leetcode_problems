package com.pan.leetcode.double_pointer;

public class P_167两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        if(n<=1) return new int[2];
        int ret[] = new int[2];
        int low = 0, high = n-1;
        while(low<high){
            int sum = numbers[low] + numbers[high];
            if(sum < target)
                low++;
            else if(sum > target)
                high --;
            else{
                ret[0] = low + 1;
                ret[1] = high + 1;
                break;
            }
        }
        return ret;
    }
}
