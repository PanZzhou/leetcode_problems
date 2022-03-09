package com.pan.leetcode.double_pointer;

public class P_633平方数之和 {
    public boolean judgeSquareSum(int c) {
        long slow = 0, fast = (long) Math.sqrt(c);
        while(slow <= fast){
            long s = slow * slow;
            long f = fast * fast;
            if(s+f > c)
                fast--;
            else if(s+f < c)
                slow++;
            else
                return true;
        }
        return false;
    }
}
