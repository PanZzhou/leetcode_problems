package com.pan.leetcode.搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        //从int[]放到List中方便new一个新的ArrayList
        for (int num : nums) {
            ans.add(num);
        }
        backTrace(ret, ans, 0, nums.length);
        return ret;
    }

    private void backTrace(List<List<Integer>> ret, List<Integer> ans, int inx, int len){
        if(inx == len)
            ret.add(new ArrayList<>(ans));
        //对每个下标，都与其后的下标们互换位置
        for (int i = inx; i < len; i++) {
            //修改输出方式
            //与后面的坐标依次交换位置
            Collections.swap(ans, inx, i);
            //当前下标向前推进，推进到len即可加入List
            backTrace(ret, ans, inx+1, len);
            //交换回原来的位置
            Collections.swap(ans, inx, i);
        }
    }
}
