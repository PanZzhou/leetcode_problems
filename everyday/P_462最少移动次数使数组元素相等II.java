package com.pan.leetcode.everyday;

import java.util.Arrays;
import java.util.Random;

public class P_462最少移动次数使数组元素相等II {
    //写法一 全排序
    //    public int minMoves2(int[] nums) {
//        int n = nums.length;
//        int target = (n-1)/2;
//        Arrays.sort(nums);
//        int ret = 0;
//        for (int i = 0; i < n; i++) {
//            ret += Math.abs(nums[i] - nums[target]);
//        }
//        return ret;
//    }

    //写法二  时间较大
//    private int ret;
//    public int minMoves2(int[] nums) {
//        int n = nums.length;
//        int target = (n - 1) / 2;
//        ret = -1;
//        quick(nums, 0, nums.length-1, target);
//        return ret;
//    }
//    private void quick(int[] nums, int start, int end, int target){
////        System.out.println(start+" "+end+" "+ target);
//        if(ret != -1) return;
//        if(start > end) return;
//        int temp = nums[start];
//        int left = start, right = end;
//        while(left<right){
//            while(left<right && nums[right] >= temp) right--;
//            nums[left] = nums[right];
//            while(left<right && nums[left] <= temp) left++;
//            nums[right] = nums[left];
//        }
//        nums[left] = temp;
////        System.out.println(left+" "+nums[left]);
//        if(left == target){
//            ret = 0;
//            for (int i = 0; i < nums.length; i++) {
//                ret += Math.abs(nums[i] - nums[target]);
//            }
//        }else if(left > target)
//            quick(nums, start, left-1, target);
//        else
//            quick(nums, left+1, end, target);
//    }

    //写法三，此方法最快，随机选择partition的元素
    Random random = new Random();

    public int minMoves2(int[] nums) {
        int n = nums.length, x = quickSelect(nums, 0, n - 1, n / 2), ret = 0;
        for (int i = 0; i < n; ++i) {
            ret += Math.abs(nums[i] - x);
        }
        return ret;
    }

    public int quickSelect(int[] nums, int left, int right, int index) {
        int q = randomPartition(nums, left, right);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, right, index) : quickSelect(nums, left, q - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int x = nums[right], i = left - 1;
        for (int j = left; j < right; ++j) {
            //若i停下来了的话，那么i+1位置的元素就是比nums[right]更大的数
            if (nums[j] <= x) {
                ++i;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
