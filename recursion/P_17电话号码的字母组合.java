package com.pan.leetcode.recursion;

import java.time.temporal.ChronoField;
import java.util.*;

public class P_17电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if(len==0)
            return list;
        Map<Character,String> myMap = new HashMap<Character,String>();
        myMap.put('2', "abc");
        myMap.put('3', "def");
        myMap.put('4', "ghi");
        myMap.put('5', "jkl");
        myMap.put('6', "mno");
        myMap.put('7', "pqrs");
        myMap.put('8', "tuv");
        myMap.put('9', "wxyz");

        backTrace(list,myMap,digits,0,new StringBuilder());
        return list;
    }
    private void backTrace(List<String> list, Map<Character,String> map,String digits, int index, StringBuilder sb){
        if(index==digits.length()){
            list.add(sb.toString());
        }else{
            char digit = digits.charAt(index);
            String alpt = map.get(digit);
            for(int i=0;i<alpt.length();++i){
                sb.append(alpt.charAt(i));
                backTrace(list,map,digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
