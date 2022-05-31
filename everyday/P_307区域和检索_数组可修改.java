package com.pan.leetcode.everyday;

public class P_307区域和检索_数组可修改 {
    private int[] nums;
    private int[] tree;
    private int n;
    public P_307区域和检索_数组可修改(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        //tree数组下标要从1开始，所以是n+1的大小
        this.tree = new int[n+1];
        for(int i=0;i<n;i++)
            add(i+1, nums[i]);
    }

    //关键函数1
    private int lowerDigit(int x){
        return x & -x;
    }
    //关键函数二
    //给tree数组增加一个增量，value是修改的增量
    private void add(int x, int value){
        while(x<=n){
            tree[x] += value;
            x += lowerDigit(x);
        }
    }
    //关键函数三
    //查找下标x-1的前缀和
    private int query(int x){
        int ans = 0;
        while(x > 0){
            ans += tree[x];
            x -= lowerDigit(x);
        }
        return ans;
    }

    public void update(int index, int val) {
        //tree中的增量是：val-nums[index]
        add(index+1,val-nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }
}
