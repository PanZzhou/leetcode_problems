package com.pan.leetcode.剑指offer.medium;

import java.util.Arrays;

public class P_剑指Offer45把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        //数字不好做组合，可以先转换成字符串，字符串容易连接起来并且也容易比较大小
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
//        quickSort(str, 0, str.length-1);
        //内置排序函数写法，要掌握，解体的时候就不用费力写快排了
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    //复习快排
    private void quickSort(String[] str, int l, int r){
        if(l>=r)
            return;
        int i = l, j = r;
        String temp = str[i];
        while(i<j){
            //注意是小于等于
            //注意compareTo的字符串比较大小的方法
            while(i<j && (temp+str[j]).compareTo(str[j]+temp)<=0) j--;
            //注意不是str[i++] = str[i]
            str[i] = str[j];
            while(i<j && (temp+str[i]).compareTo(str[i]+temp)>=0) i++;
            str[j] = str[i];
        }
        str[i] = temp;
        quickSort(str, l, i-1);
        quickSort(str, i+1, r);
    }
}
