package com.pan.leetcode.double_pointer;

import java.util.HashMap;
import java.util.Map;

public class P_76最小覆盖子串 {
    public String minWindow(String s, String t) {
        if(t==null || s == null || t.length()==0 || t.length() > s.length()) return "";
        if(s.length() == 1)
            return t.charAt(0)==s.charAt(0)?s:"";
        Map<Character, Integer> mMap = new HashMap<>();
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            char a = t.charAt(i);
            Integer num = mMap.getOrDefault(a, null);
            if(num != null)
                mMap.put(a, num + 1);
            else
                mMap.put(a, 1);
        }
        int slow = 0, fast = -1, sInx = 0, eInx = Integer.MAX_VALUE / 2;
        while(slow < s.length()){
            char a;
            Integer num;
            if(count > 0 && fast < s.length() - 1){
                fast++;
                a = s.charAt(fast);
                num = mMap.getOrDefault(a, null);
                if(num != null){
                    mMap.put(a, num-1);
                    if(num > 0)
                        count--;
                }
            }else{
                a = s.charAt(slow);
                num = mMap.getOrDefault(a, null);
                if(num != null){
                    mMap.put(a, num+1);
                    if(num >= 0)
                        count++;
                }
                slow++;
            }
            if(count == 0 && eInx - sInx > fast - slow){
                sInx = slow;
                eInx = fast;
            }
        }
        if (eInx >= s.length())
            return "";
        else
            return s.substring(sInx, eInx+1);
    }
}
