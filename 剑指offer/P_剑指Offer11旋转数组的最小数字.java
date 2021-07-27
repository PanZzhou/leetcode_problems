package com.pan.leetcode.剑指offer;

public class P_剑指Offer11旋转数组的最小数字 {
    //O(n)的时间复杂度
//    public int minArray(int[] numbers) {
//        int min = Integer.MAX_VALUE;
//        for (int number : numbers) {
//            if(number<min)
//                min = number;
//        }
//        return min;
//    }
    //二分法
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length-1;
        while(low<high){
            int mid = (low+high)>>1;
            if(numbers[mid]>numbers[high])
                low=mid+1;
            else if(numbers[mid]<numbers[high])
                high=mid;
            else
                high -= 1;
        }
        return numbers[low];
    }
}
