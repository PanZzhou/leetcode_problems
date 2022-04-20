package com.pan.leetcode.剑指offer.medium;

public class P_剑指Offer64求1加2加到n {
    //求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    //公式、迭代、递归，只能选择递归
    //递归的终止条件有if，可以使用&&等符号的短路效应来替代if
    private int ret;
    public int sumNums(int n) {
        ret = 0;
        sumCur(n);
        return ret;
    }
    private boolean sumCur(int n){
        ret += n;
        return n>0 && sumCur(n-1);
    }
}
