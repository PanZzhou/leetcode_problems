package com.pan.leetcode.二分;

public class P_34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binary(nums, target, true);
        int rightIndex = binary(nums, target, false);
        if(leftIndex!= -1 &&nums[leftIndex] != target)
            leftIndex = -1;
        if(rightIndex != -1 && nums[rightIndex] != target)
            rightIndex = -1;
        return new int[]{leftIndex,rightIndex};
    }

    private int binary(int[] nums, int target, boolean lower){
        int low = 0, high = nums.length-1, mid, ret = -1;
        while (low<=high){
            mid = (low + high)>>1;
            boolean isFit = false;
            //注意下面两种情况各种边界条件是怎么设置的
            if(lower){//如果是找不小于target的最左边的数
                if(nums[mid] >= target){//大于等于的就记录下来并往左移动
                    ret = mid;//记录当前下标
                    high = mid - 1;
                }else
                    low = mid + 1;
            }else{//如果是找不大于target的最右边的数
                if(nums[mid] <= target){//小于等于的就记录下来并往右移动
                    ret = mid;//记录当前下标
                    low = mid + 1;
                }else
                    high = mid - 1;
            }
        }
        return ret;
    }
}
