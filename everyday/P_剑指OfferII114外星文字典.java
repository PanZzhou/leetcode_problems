package com.pan.leetcode.everyday;

import java.util.*;

class Node{
    public Node[] alpha;
    public char cur;
    public Node(){
        alpha = new Node[26];
    }
    public Node(char a){
        cur = a;
        alpha = new Node[26];
    }
}

public class P_剑指OfferII114外星文字典 {
    public String alienOrder(String[] words) {
        int n = words.length;
        if(n == 0) return "";
        String pre = words[0],cur;
        int prelen = pre.length(), curlen;
        Map<Character, Node> map = new HashMap<>();
        int[] degrees = new int[26];
        Arrays.fill(degrees, -1);
        for(int i =0;i<prelen;i++){
            char a = pre.charAt(i);
            Node less = map.getOrDefault(a, null);
            if(less == null){
                less = new Node(a);
                map.put(a, less);
                degrees[a-'a'] = 0;
            }
        }
        for(int i=1; i<n; i++){
            cur = words[i];
            curlen = cur.length();
            int inx = 0;
            boolean found = false;
            while(inx<prelen || inx<curlen){
                if(!found && inx >= curlen) return "";
                char a = '0',b = '0';
                Node less = null, more = null;
                //还要遍历完所有的字母。
                if(inx < prelen){
                    a = pre.charAt(inx);
                    less = map.get(a);
                }
                if(inx < curlen){
                    b = cur.charAt(inx);
                    more = map.getOrDefault(b, null);
                    if(more == null){
                        more = new Node(b);
                        map.put(b, more);
                        degrees[b-'a'] = 0;
                    }
                }
                //已找到小于关系的，或者已超出其中之一的长度
                if(found || a == '0' || b == '0'){
                    inx++;
                    continue;
                }
                if(a != b){//说明a<b
                    if(less.alpha[b-'a'] == null){
                        less.alpha[b-'a'] = more;//标记下来，值小的指向大的
                        //入度加1
                        ++degrees[b-'a'];
                    }
                    //break;//跳出循环
                    found = true;
                }
                inx++;
            }
            pre = cur;
            prelen = curlen;
        }
        int all_alpha = map.size();
        //拓扑排序
        Deque<Node> queue = new ArrayDeque<>();
        for(int i =0;i<26;i++){
            if(degrees[i] == 0){
                queue.offer(map.get((char)('a' + i)));
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k =0; k<size; k++){
                Node zero = queue.poll();
                ret.append(zero.cur);
                for(int i=0; i<26; i++){
                    if(zero.alpha[i]!=null){
                        --degrees[zero.alpha[i].cur - 'a'];
                        if(degrees[zero.alpha[i].cur - 'a'] == 0)
                            queue.offer(zero.alpha[i]);
                        zero.alpha[i] = null;//取消指向
                    }
                }
            }
        }
        //存在环
        if(all_alpha > ret.length())
            return "";
        return ret.toString();
    }
}
