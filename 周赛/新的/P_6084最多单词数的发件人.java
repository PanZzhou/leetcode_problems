package com.pan.leetcode.周赛.新的;

import java.util.*;

public class P_6084最多单词数的发件人 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        int n = messages.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String m = messages[i], s = senders[i];
            int sendNum = map.getOrDefault(s, -1);
            int curNum = getBlank(m)+1;
            if(sendNum != -1)
                curNum += sendNum;
            map.put(s, curNum);
            if(curNum > max){
                ret.clear();
                ret.add(s);
                max = curNum;
            }else if(curNum == max){
                ret.add(s);
            }
        }
        int size = ret.size();
        String min = ret.get(0);
        for (int i = 1; i < size; i++) {
            String cur = ret.get(i);
            if(lower(min, cur))
                min = cur;
        }
        return min;
    }
    private int getBlank(String str){
        int n = str.length();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == ' ')
                ret++;
        }
        return ret;
    }
    private boolean lower(String min, String cur){
        int n = min.length(), m = cur.length();
        for (int i = 0; i < n && i < m; i++) {
            if(min.charAt(i) > cur.charAt(i))
                return false;
            else if(min.charAt(i) < cur.charAt(i))
                return true;
        }
        if(n <= m) return true;
        return false;
    }
}
