package com.pan.leetcode.分治法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P_241为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<String> ex = new ArrayList<>();
        int i = 0;
        StringBuilder sum = new StringBuilder();
        while(i<expression.length()){
            char a = expression.charAt(i);
            if(a<'0' || a>'9'){
                if(sum.length() != 0){
                    ex.add(sum.toString());
                    sum.setLength(0);//清除缓冲区，设置长度为0即可
                }
                ex.add(Character.toString(a));
            } else{
                sum.append(a);
            }
            if(i==expression.length()-1 && sum.length()!=0){
                ex.add(sum.toString());
            }
            i++;
        }
        List<Integer> ret = new LinkedList<>();
        if(ex.size() == 0) return ret;
        if(ex.size() == 1) {
            int res = Integer.parseInt(ex.get(0));
            ret.add(res);
            return ret;
        }
        return diff(ex, 0, ex.size()-1);
    }
    private List<Integer> diff(List<String> ex, int s, int e){
        List<Integer> localRet = new ArrayList<>();
        if(s>e) return localRet;
        if(s==e){
            localRet.add(Integer.parseInt(ex.get(s)));
            return localRet;
        }
        for (int i = s; i <= e; i++) {
            String a = ex.get(i);
            if(isOpt(a)){
                List<Integer> left = diff(ex, s, i-1);
                List<Integer> right = diff(ex, i+1, e);
                System.out.println(left + "  "+ right);
                if(left.size() <= 0 || right.size() <= 0)
                    continue;
                for (Integer l : left) {
                    for (Integer r : right) {
                        int res = 0;
                        switch (a){
                            case "+": res = l + r; break;
                            case "-": res = l - r; break;
                            case "*": res = l * r; break;
                            case "/": if(r != 0)  res = l / r; break;
                            default: break;
                        }
                         localRet.add(res);
                    }
                }
            }
        }
        return localRet;
    }
    private boolean isOpt(String opt){
        return opt.equals("+") || opt.equals("-") || opt.equals("*") || opt.equals("/");
    }
}
