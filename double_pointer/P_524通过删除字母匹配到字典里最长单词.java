package com.pan.leetcode.double_pointer;

import java.util.List;

public class P_524通过删除字母匹配到字典里最长单词 {
    public String findLongestWord(String s, List<String> dictionary) {
        if(s == null || s.length()==0) return "";
        int inx = -1;
        for (int i = 0; i < dictionary.size(); i++) {
            String dict = dictionary.get(i);
            if(isMatch(s, dict)){
                if(inx == -1 || lessThan(dict, dictionary.get(inx)))
                    inx = i;
            }
        }
        if(inx == -1) return "";
        return dictionary.get(inx);
    }

    private boolean isMatch(String str, String pattern){
        int strL = 0, patL = 0;
        while(strL < str.length() && patL < pattern.length()){
            if(str.charAt(strL) == pattern.charAt(patL)){
                strL++;
                patL++;
            }else{
                strL++;
            }
        }
        return patL >= pattern.length();
    }

    private boolean lessThan(String str, String pat){
        if(str.length() > pat.length()) return true;
        if(str.length() < pat.length()) return false;
        int sL = 0, pL = 0;
        for (; sL<str.length() && pL<pat.length(); sL++, pL++) {
            char strC = str.charAt(sL);
            char patC = pat.charAt(pL);
            if(strC < patC)
                return true;
            if(strC > patC)
                return false;
        }
        return sL < str.length();
    }
}
