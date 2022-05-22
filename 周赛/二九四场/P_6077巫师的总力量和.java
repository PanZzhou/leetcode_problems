package com.pan.leetcode.周赛.二九四场;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_6077巫师的总力量和 {
    int mod = 1000000007;
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int[] left = new int[n], right = new int[n], sum = new int[n], ssum = new int[n];
        int ret=0,cur;
        Deque<Integer> minstack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!minstack.isEmpty() && strength[minstack.peek()] > strength[i]){
                cur = minstack.pop();
                right[cur] = i;
            }
            if(minstack.isEmpty())
                left[i] = -1;
            else
                left[i] = minstack.peek();
            minstack.push(i);
        }
        while(!minstack.isEmpty()){
            right[minstack.pop()] = n;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(left[i]+" "+right[i]);
//        }
        sum[0] = strength[0];
        ssum[0] = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = (sum[i-1] + strength[i])%mod;
            ssum[i] = (ssum[i-1] + sum[i])%mod;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(sum[i]+" "+ssum[i]);
//        }

        for (int i = 0; i < n; i++) {
            int l = left[i]+1, r = right[i] - 1;
            long sleft = ((long)getPower(ssum, l-2, i-1)*(r-i+1)%mod);//乘之后容易超出范围，所以需要long类型
            long sright = ((long)getPower(ssum, i-1, r)*(i-l+1)%mod);
            ret += strength[i] * (((sright - sleft) + mod)%mod)%mod;
            ret %= mod;
        }
        return ret;
    }
    private int getPower(int[] ssum, int left, int right){
        if(right < 0)
            return 0;
        if(left < 0)
            return ssum[right];
        return (ssum[right] - ssum[left] + mod)%mod;//加上mod的目的是怕后者比前者大
    }

//    public int totalStrength(int[] strength) {
//        int n = strength.length;
//        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE,ret=0, mod = 1000000007;
//        while(left<n){
//            if(right<n){
//                sum += strength[right];
//                min = Math.min(min, strength[right]);
//                ret = (ret + min * sum)%mod;
//                right++;
//            }else{
//                left++;
//                right = left;
//                sum = 0;
//                min = Integer.MAX_VALUE;
//            }
//        }
//        return ret;
//    }
}
