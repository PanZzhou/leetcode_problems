package com.pan.leetcode.剑指offer;

public class P_剑指Offer14_1剪绳子 {

    //这题就是纯数学问题
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int a= n/3, b=n%3;
        //绳子均分的话乘积最大；绳子长度为3时，乘积最大
        if(b==0) return (int)Math.pow(3, a);//正好绳子被均分
        if(b==1) return (int)Math.pow(3, a-1)*4;//绳子按长度为3分开但留了一段
        return (int)Math.pow(3, a)*2;//绳子长度剩余2
    }
}
