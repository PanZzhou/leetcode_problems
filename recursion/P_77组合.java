package com.pan.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class P_77组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res,ans,1,n,k);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer> one,int now, int n, int k){
        if(one.size()==k){
            res.add(new ArrayList<>(one));
            return;
        }
        if(now>n)
            return;
        for (int i = now; n-i+one.size()+1>=k; i++) {
            one.add(i);
            dfs(res,one,i+1,n,k);
            one.remove(one.size()-1);
        }
    }
}
