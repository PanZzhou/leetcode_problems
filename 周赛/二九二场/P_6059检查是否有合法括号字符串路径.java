package com.pan.leetcode.周赛.二九二场;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class P_6059检查是否有合法括号字符串路径 {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0) return true;
        if(grid[0][0] == ')' || grid[m-1][n-1]=='(' || (m+n)%2 == 0)
            return false;
        HashSet<Integer>[] cnset = new HashSet[n];
        HashSet<Integer> cur = new HashSet<>(), pre;
        cur.add(1);
        cnset[0] = cur;
        for (int i = 1; i < n; i++) {
            pre = cnset[i-1];
            cur = new HashSet<>();
            add(pre, cur, grid[0][i],m+n-i);
            cnset[i] = cur;
        }
        int row = 1;
        cur = new HashSet<>();
        while(row<m){
            for (int i = 0; i < n; i++) {
                add(cnset[i], cur, grid[row][i], m-row+n-i);
                if(i>0)
                    add(cnset[i-1], cur, grid[row][i], m-row+n-i);
                pre = cnset[i];
                cnset[i] = cur;
                cur = pre;
                cur.clear();
            }
//            print(cnset);
            row++;
        }
        return cnset[n-1].contains(0);
    }
    private void add(Set<Integer> pre, Set<Integer> cur, char a, int res){
        if(a == '('){
            for (int cnt : pre) {
                if(cnt <= res - 2)
                    cur.add(cnt+1);
            }
        }else{
            for (int cnt : pre) {
                if(cnt>0 && cnt <= res)
                    cur.add(cnt-1);
            }
        }
    }
    private void print(HashSet<Integer>[] set){
        for (int i = 0; i < set.length; i++) {
            for (Integer num : set[i]) {
                System.out.print(num+" ");
            }
            System.out.print(" ||| ");
        }
        System.out.println();
    }
}
