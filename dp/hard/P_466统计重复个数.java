package com.pan.leetcode.dp.hard;

import java.util.*;

public class P_466统计重复个数 {
    //不想做了，太复杂了
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(!isValid(s1,s2))
            return 0;
        int[] info = getEpoch(s1, s2);
//        System.out.println(info[0]+" "+ info[1]+" "+info[2] +" "+info[3]+" "+info[4]);
        //先处理非循环段
        int pre = info[3];
        if(info[2] != 0)
            pre++;
        if(n1 == pre) return info[4]/n2;
        if(n1<pre)
            return n1*info[4]/(pre*n2);
        int ret = info[4]/n2;
        int premod = info[4]%n2;
        if(ret == 0){
            premod = n2 - premod;//非循环段欠出来的s2数量
        }
        //再处理循环段
        n1 -= pre;
        int cnt = n1/info[0];//s1可以完整对几轮
        if(cnt == 0)//s1对不了完整的一轮
            return ret + (int)((double)n1*info[1]/(info[0]*n2) - (double)premod/n2);
        int mod = n1%info[0];//剩余的s1的数量
        int ccnt = (cnt*info[1] - premod)/n2;//s2*n2可以完整对几轮
        if(ccnt == 0)//s2对不了完整的一轮
            return ret + (int)((double)n1*info[1]/(info[0]*n2) - (double)premod/n2);
        int mmod = (cnt*info[1] - premod)%n2;//对齐ccnt后多出来的几个s2. 可能为零
        if(mmod == 0){
            if((mod*info[1]/info[0])>=n2)
                ccnt++;
        }else{
            double cur = (double) mod/mmod;
            double fix = (double) info[0]/info[1];
            if(cur < fix)
                ccnt--;
        }
        return ret + ccnt;
    }
    private int[] getEpoch(String s1, String s2){
        int epoch = 0, cnt=0;
        int lenS1 = s1.length(), lenS2 = s2.length();
        int i = 0, j = 0;
        Map<Integer, int[]> map = new HashMap();
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
                epoch++;
            }
        }
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() +" "+entry.getValue()[0]+" "+entry.getValue()[1]);
        }
//        epoch--;
        int[] cur = map.get(i);
        return new int[]{epoch-cur[0], cnt-cur[1], i, cur[0], cur[1]};
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
