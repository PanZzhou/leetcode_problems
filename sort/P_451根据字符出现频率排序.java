package com.pan.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_451根据字符出现频率排序 {
    public String frequencySort(String s) {
        Map<Character, Integer> mMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            mMap.put(a, mMap.getOrDefault(a, 0) + 1);
        }
        ArrayList<Character> list = new ArrayList<>(mMap.keySet());
        //要掌握这种排序编写方式和lamda表达式写法
        Collections.sort(list, (a, b)-> mMap.get(b)-mMap.get(a));
        StringBuilder sb = new StringBuilder();
        for (char a : list) {
            int fre = mMap.get(a);
            while(fre>0){
                sb.append(a);
                fre--;
            }
        }
        return sb.toString();
    }
}
