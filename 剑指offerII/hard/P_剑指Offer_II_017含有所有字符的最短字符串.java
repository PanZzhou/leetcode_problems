package com.pan.leetcode.剑指offerII.hard;

public class P_剑指Offer_II_017含有所有字符的最短字符串 {
    //代码由题目 "剑指Offer II 014字符串中的变位词"官方解答代码修改得来
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        //用于保存字符串t中每个字符出现的次数
        //cnt[k] = m+i表示字符k+'a'出现i-1次。
        int[] cnt = new int[52];//小写字母和大写字母各26个
        if(m < n) return "";//s没有t长，返回空字符
        int inx;
        for (int i = 0; i < n; i++) {
            inx = getInx(t.charAt(i));
            if(cnt[inx] == 0)
                //s字符串中连续m个字符可能都同时为相同字符inx
                //给字符数量加上m+1可以保证任何情况cnt[inx]>0
                //这样可以表明此字符是字符串t中的字符，是需要我们关注的
                cnt[inx] = m+2;
            else
                ++cnt[inx];
        }
        for (int i = 0; i < n; i++) {
            inx = getInx(s.charAt(i));
            //cnt[inx]等于0，说明改字符不在字符串t中，不需要我们关注
            if(cnt[inx] > 0)
                --cnt[inx];
        }
        int diff = 0;
        for (int counts : cnt) {
            //大于m+1,说明滑动窗口内该字符还欠缺几个字符
            //等于m+1，说明滑动窗口内该字符数量正好满足
            //小于m+1,说明滑动窗口内该字符多了,数量管够
            //所以小于等于m+1时，该字符满足要求，
            //以上字符数量是以字符串t中该字符的数量为基准的
            if(counts > 0 && counts > m+1)
                diff++;//记录仍然欠缺字符的种类数量
        }
        if(diff == 0) return s.substring(0,n);
        int left = 0, right = n, ret_left = -1, ret_right = m+1;
        while(left < m){
            //记录不再缺字符种类时的边界
            if(diff == 0 && right > left && ret_right - ret_left > right - left){
                //记录新边界
                ret_right = right;
                ret_left = left;
            }
            //当右边界小于m 且 左右边界相等 或 窗口内仍缺字符种类时增大窗口
            if(right<m &&(right == left || diff != 0)){
                inx =getInx(s.charAt(right++));//获取字符在cnt中的下标
                if(cnt[inx]<=0)//该字符不再字符串t中
                    continue;//这是个臭虫，会跳过diff==0时的结果记录
                --cnt[inx];//加入滑动窗口后，减小该字符的数量
                if(cnt[inx] == m+1)//由m+2变为m+1,该字符不再缺(小于等于m+1时都不缺)
                    diff--;//减小缺字符种类数量
            }else{//否则，缩小窗口
                inx = getInx(s.charAt(left++));//获取字符在cnt中的下标
                if(cnt[inx]<=0)//该字符不在字符串t中
                    continue;//这是个臭虫，会跳过diff==0时的结果记录
                ++cnt[inx];//排出滑动窗口，增加该字符数量
                if(cnt[inx] == m+2)//由m+1变为m+2，说明窗口内该字符缺了一个(小于等于m+1时都不缺)
                    diff++;//增加缺字符种类数量
            }
        }
        //预定义边界没有变，没找到合适的边界
        if(ret_left == -1)
            return "";//返回空字符串
        return s.substring(ret_left, ret_right);
    }
    //由字符映射为数组下标，'a'到'z'下标为0到25，'A'到'Z'下标为26到51
    private int getInx(char a){
        if(a>='a' && a<='z')
            return a-'a';
        return a-'A'+26;
    }
}
