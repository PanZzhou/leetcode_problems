package com.pan.leetcode.hot100.medium;

public class P_621任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] cnt = new int[26];
        int max = 0;
        for (int i = 0; i < tasks.length; i++) {
            cnt[tasks[i]-'A']++;
            max = Math.max(max, cnt[tasks[i]-'A']);
        }
        int ret = (max - 1)*(n+1);
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] == max)
                ret++;
        }
        return Math.max(ret, tasks.length);
    }
}
