package com.pan.leetcode.dp.hard;

import java.util.*;

public class P_466统计重复个数 {
    //不想做了，太复杂了
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(!isValid(s1,s2))
            return 0;
        int lenS1 = s1.length(), lenS2 = s2.length();
        Map<Integer, int[]> map = new HashMap<>();
        int epoch = 0, cnt=0, ret = 0;
        int i = 0, j = 0;
        while(!(!map.isEmpty() && j==0 && map.containsKey(i))){
            if(s1.charAt(i) == s2.charAt(j)){
                if(map.containsKey(i) && j == 0) break;
                if(j == 0){
                    map.put(i,new int[]{epoch, cnt});
                }
                if(++j>=lenS2){
                    j = 0;
                    cnt++;
                }
            }
            if(++i>=lenS1){
                i = 0;
                if(++epoch == n1)//未到达循环节，直接返回现已匹配了的
                    return cnt/n2;
            }
        }
//        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
//            System.out.print(entry.getKey() +" "+entry.getValue()[0]+" "+entry.getValue()[1]);
//            System.out.println();
//        }
        int[] cur = map.get(i); //前一个循环节信息
        epoch  -= cur[0]; //循环节中s1个数
        cnt -= cur[1];//循环节中s2个数

        n1 -= cur[0]; //循环部分总长度
        n1--;//剪掉开头的那部分
        int times = n1/epoch; //循环节数量
        int resdual = n1%epoch+1; //剩余s1的数量，加1是要加上之前剪掉的那部分
        int more = 0;
        while(resdual > 0){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
                if(j>=s2.length()){
                    j=0;
                    more++;
                }
            }
            i++;
            if(i>=s1.length()){
                i=0;
                resdual--;
            }
        }
        return (cur[1] + times*cnt + more)/n2;
    }

    private boolean isValid(String s1, String s2){
        boolean[] vis = new boolean[26];
        Arrays.fill(vis, false);
        for (int i = 0; i < s1.length(); i++) {
            vis[s1.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < s2.length(); i++) {
            if(!vis[s2.charAt(i) - 'a'])
                return false;
        }
        return true;
    }
}
