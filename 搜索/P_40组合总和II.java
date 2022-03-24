package com.pan.leetcode.搜索;

import javax.xml.namespace.QName;
import java.util.*;

public class P_40组合总和II {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.sort(candidates);//相同的数就挨着
//        boolean[] vis = new boolean[candidates.length];
//        List<Integer> path = new ArrayList<>();
//        dfs(candidates, vis, 0, ret, path, 0, target);
//        return ret;
//    }
//    private void dfs(int[] candidates, boolean[] vis, int inx, List<List<Integer>> ret, List<Integer> path, int total, int target){
//        if(total == target){
//            ret.add(new ArrayList<>(path));
//            return;
//        }
//        if(total > target)
//            return;
//
//        for (int i = 0; i < candidates.length; i++) {
//            if(vis[i] || (i>0 && candidates[i]==candidates[i-1] && !vis[i-1]))
//                continue;
//            vis[i] = true;
//            path.add(candidates[i]);
//            dfs(candidates, vis, inx+1, ret, path, total+candidates[i], target);
//            path.remove(inx);
//            vis[i] = false;
//        }
//    }

    List<List<Integer>> ret;
    List<Integer> seq;
    List<int[]> freq;//统计每个数字出现的频率
    Map<Integer, Integer> nums;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<>();
        seq = new ArrayList<>();
        freq = new ArrayList<>();
        nums = new HashMap<>();
        int pos = 0;
        for (int num : candidates) {
            if(nums.isEmpty() || !nums.containsKey(num)){
                nums.put(num, pos++);
                freq.add(new int[]{num, 1});
            }else
                freq.get(nums.get(num))[1]++;
        }
        dfs(0, target);
        return ret;
    }
    private void dfs(int pos, int target){
        if(target==0){
            ret.add(new ArrayList<>(seq));
            return;
        }
        if(pos==freq.size()){
            return;
        }
        //不加入这个数
        dfs(pos+1, target);
        int batch = Math.min(target/freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= batch; i++) {
            seq.add(freq.get(pos)[0]);
            dfs(pos+1, target-i*freq.get(pos)[0]);
        }
        for (int i = 1; i <= batch; i++) {
            seq.remove(seq.size() - 1);
        }
    }
}
