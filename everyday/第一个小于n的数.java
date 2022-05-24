package com.pan.leetcode.everyday;

public class 第一个小于n的数 {
    public String firstLower(char[] s, int n){
        String str = String.valueOf(n);
        char[] num =str.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(s, num, sb, 0, false);
        if(sb.length() == 0) return "-1";
        return sb.toString();
    }
    private void dfs(char[] s, char[] num, StringBuilder sb, int inx, boolean lower){
        if(sb.length() == num.length) return;
        if(inx >= num.length) return;
        if(lower){
            sb.append(s[s.length-1]);
            dfs(s, num, sb, inx+1, lower);
            return;
        }
        char a = num[inx];
        //在s中二分找到不大于a的数字下标
        int left = 0, right = s.length - 1, max = -1, mid;
        while(left<=right){
            mid = (left+right)>>1;
            if(s[mid] <= a){
                max = mid;
                left = mid+1;
            }else
                right = mid-1;
        }
        //从max到0尝试在当前位置依次放入s[max]
        while(max>=0){
            //若当前位置是最后一位，尝试放入小于a的最大的数
            if(inx == num.length - 1 && s[max] == a){
                max--;
                continue;
            }
            sb.append(s[max]);
            if(s[max] < a){//当前位放入了小的数，后面的数就一直放最大的数
                dfs(s, num, sb, inx+1, true);
            }else{//当前为放入相等的数
                dfs(s, num, sb, inx+1, lower);
            }
            //找到了结果，直接返回
            if(sb.length() == num.length) return;
            //未找到结果，回退，进行下一轮迭代尝试放入更小的数
            sb.deleteCharAt(sb.length()-1);
            max--;
        }
    }
}
