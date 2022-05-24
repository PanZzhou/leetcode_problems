package com.pan.leetcode.everyday;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.*;

public class P_30串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return ret;
        int oneWord = words[0].length();
        int wordNum = words.length;
        int allLen = oneWord * wordNum;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        //分别从下标开始
        Map<String,Integer> tmpmap = new HashMap<>();
        for (int i = 0; i < oneWord; i++) {
            int left = i, right = i, count=0;
            tmpmap.clear();
            while(right + oneWord <= s.length()){
                String subStr = s.substring(right, right+oneWord);
                right += oneWord;
                if(!map.containsKey(subStr)){
                    tmpmap.clear();
                    count = 0;
                    left = right;
                    //优化一
                    if(left + allLen > s.length())
                        break;
                }else{
                    tmpmap.put(subStr, tmpmap.getOrDefault(subStr, 0)+1);
                    count++;
                    while(tmpmap.getOrDefault(subStr, 0) > map.getOrDefault(subStr, 0)){
                        String tmpStr = s.substring(left, left+oneWord);
                        left += oneWord;
                        count --;
                        tmpmap.put(tmpStr, tmpmap.get(tmpStr)-1);
                    }
                    if(count == wordNum) ret.add(left);
                    //优化二
                    if(left + allLen > s.length())
                        break;
                }
            }
        }
        return ret;
    }
}
