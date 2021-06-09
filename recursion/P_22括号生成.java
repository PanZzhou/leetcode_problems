package com.pan.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class P_22括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrace(res, n,0,0, new StringBuilder());
        return res;
    }
    private void backTrace(List<String> res, int count,int index, int over, StringBuilder sb){
        if(sb.length() == count*2){
            res.add(sb.toString());
        }else{
            if(over==0){
                sb.append('(');
                backTrace(res,count,index+1,over+1,sb);
                sb.deleteCharAt(2*index-over);
            }else if(count==index){
                sb.append(')');
                backTrace(res,count,index,over-1,sb);
                sb.deleteCharAt(2*index-over);
            }else{
                sb.append('(');
                backTrace(res,count,index+1,over+1,sb);
                sb.deleteCharAt(2*index-over);
                sb.append(')');
                backTrace(res,count,index,over-1,sb);
                sb.deleteCharAt(2*index-over);
            }
        }
    }
}
