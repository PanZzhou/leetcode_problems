package com.pan.leetcode.二分;

public class P_81搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return false;
        if(n==1) return nums[0]==target;
        int low=0, high=n-1, mid=-1;
        while(low<=high){
            mid = (low+high)>>1;
            if(nums[mid] == target)//找到值直接返回
                return true;
            //当前三个指针的值都一致，无法选择任意个区间，那么就缩小两边
            if(nums[low] == nums[mid] && nums[high] == nums[mid]){
                low++;
                high--;
                //区分mid的两种状态：
                //1.要不前半部分单调不减，
                //2.要不后半部分单调不减
            }else if(nums[low] <= nums[mid]){//前半部分单调不减
                //target位于前半部分时
                if(nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else{//后半部分单调不减
                //target位于后半部分时
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }
        }
        return false;
    }
}
