package com.pan.leetcode.剑指offer.easy;

import java.util.ArrayList;
import java.util.List;

public class P_剑指Offer57_II和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> ans = new ArrayList<>();
        while(left<=target/2){
            if(sum < target){
                sum += right;
                right++;
            }else if(sum >target){
                sum -= left;
                left++;
            }else{
                int[] temp = new int[right - left];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left+i;
                }
                ans.add(temp);
                sum -= left;
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
