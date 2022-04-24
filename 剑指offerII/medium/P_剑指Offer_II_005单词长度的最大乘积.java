package com.pan.leetcode.剑指offerII.medium;

import org.omg.PortableInterceptor.INACTIVE;

public class P_剑指Offer_II_005单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        int[] vis = new int[words.length];
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                vis[i] |= (1<<(words[i].charAt(j)-'a'));
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((vis[i]&vis[j]) == 0){
                    int len =  words[i].length()*words[j].length();
                    if(len > ret)
                        ret = len;
                }
            }
        }
        return ret;
    }
}
