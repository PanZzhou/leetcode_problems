package com.pan.leetcode.剑指offer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_剑指Offer38字符串的排列 {
//    List<String> ans;
//    public String[] permutation(String s) {
//        char[] str = s.toCharArray();
//        ans = new ArrayList<>();
//        permu(str, 0);
//        String[] ret = new String[ans.size()];
//        for (int i = 0; i < ans.size(); i++) {
//            ret[i] = ans.get(i);
//        }
//        return ret;
//    }
//    private void permu(char[] str, int start){
//        if(start >= str.length){
//            ans.add(String.copyValueOf(str));
//            return;
//        }
//        for (int i = start; i < str.length; i++) {
//            swap(str, start, i);
//            permu(str, start+1);
//            swap(str, start, i);
//        }
//    }
//    private void swap(char[] str, int i, int j){
//        char temp = str[i];
//        str[i] = str[j];
//        str[j] = temp;
//    }
    List<String> ans;
    public String[] permutation(String s) {
        ans = new ArrayList<>();
        char[] str = s.toCharArray();
        //对数组进行排序
        Arrays.sort(str);

        boolean[] vis = new boolean[str.length];
        char[] blank = new char[str.length];
        permu(str, vis, blank, 0);

        String[] ret = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
    private void permu(char[] str, boolean[] vis, char[] blank, int index){
        if(index >= str.length){
            ans.add(String.copyValueOf(blank));
            return;
        }
        for (int i = 0; i < str.length; i++) {
            //当前元素已访问过 或者 前一个相同元素还未访问
            if(vis[i] || (i>0 && str[i] == str[i-1] && !vis[i-1]))
                continue;
            blank[index] = str[i];
            vis[i] = true;
            permu(str, vis, blank, index+1);
            vis[i] = false;
        }
    }
}
