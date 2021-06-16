package com.pan.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class P_331验证二叉树的前序序列化 {
    //这种方法太费时
//    public boolean isValidSerialization(String preorder) {
//        if(preorder.length()<=1)
//            return preorder.equals("#");
//        String[] strs = preorder.split(",");
//        int len = strs.length;
//        Deque<String> stack = new LinkedList<>();
//        for (int i = 0; i < len; i++) {
//            String str = strs[i];
//            if(!str.equals("#") || stack.isEmpty() || !stack.peek().equals("#"))
//                stack.push(str);
//            else{
//                while(!stack.isEmpty()&&stack.peek().equals("#")){
//                    stack.pop();
//                    if(!stack.isEmpty())
//                        stack.pop();
//                    else
//                        return false;
//                }
//                stack.push("#");
//            }
//        }
//        return stack.size()==1&&stack.peek().equals("#");
//    }
    public boolean isValidSerialization(String preorder) {
        int len = preorder.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        for (int i = 0; i < len;) {
            char ch = preorder.charAt(i);
            if(stack.isEmpty())
                return false;
            if(ch==',')
                i++;
            else if(ch=='#'){
                int top = stack.pop()-1;
                if(top>0)
                    stack.push(top);
                i++;
            }else{
                while(i<len&&preorder.charAt(i)!=',')
                    i++;
                int top = stack.pop()-1;
                if(top>0)
                    stack.push(top);
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
