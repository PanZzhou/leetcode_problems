package com.pan.leetcode.搜索;

import java.util.*;

public class P_126单词接龙II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //解法：先从beginWord使用广度优先遍历构建层次图，再使用深度优先遍历找到所有节点
        //难点：如何存储搜索路劲：dfs遍历的同时使用栈记录路径
        //难点：广度优先遍历中如何存储图结构：运用map记录每个字符串节点的所有前继节点，并使用另一个map记录它的层数
        //难点：如何快速找到某个单词之差一个字母的所有单词：把单词中的每个字符换成其他26个字符，然后判断新单词是否存在字典中
        //技巧：可使用List初始set；deque可用于初始化List；deque可用于栈；字符串与字符数组相互转化；
        //技巧：广度优先遍历到endWord即可结束遍历，因为bfs中越早遍历到越靠近源点；
        //技巧：深度优先遍历时应从endword开始遍历，因为存储的图结构中每个单词节点只记录了它的前继节点
        //技巧：此题中的深度优先应该是一个全排列的写法
        HashSet<String> dict = new HashSet<>(wordList);//字典,直接使用wordList初始化
        List<List<String>> ret = new ArrayList<>();
        if(!dict.contains(endWord)) return ret;//当前字典不包含endWord,直接返回
        dict.remove(beginWord);//beginWord先移除字典
        Map<String,List<String>> from = new HashMap<>(); //用于记录当前字符串能够从哪些字符串扩展开来
        Map<String,Integer> levels = new HashMap<>(); //记录当前字符串在BFS中的第几层被发现
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(beginWord);
        int level = 1;
        boolean found = false;
        int wordLen = beginWord.length();

        //广度优先遍历
        while(!bfs.isEmpty()){
            int wordNum = bfs.size();
            while(wordNum-->0){
                String curStr = bfs.poll();
                char[] charArray = curStr.toCharArray();
                for (int i = 0; i < wordLen; i++) { //字典中每个单词的长度都与beginWord的相同
                    char origin = charArray[i]; //记录原来的字符
                    for (char j = 'a'; j <= 'z'; j++) {
                        charArray[i] = j;
                        String nextWord = String.valueOf(charArray); //把字符数组转换成字符串的方法
                        if(levels.containsKey(nextWord) && level == levels.get(nextWord)){
                            from.get(nextWord).add(curStr);//加入字符串来源列表
                        }
                        if(!dict.contains(nextWord))
                            continue;
                        dict.remove(nextWord); //遍历过此单词后就把此单词冲单词表里移除
                        bfs.offer(nextWord);
                        from.putIfAbsent(nextWord, new ArrayList<>());
                        from.get(nextWord).add(curStr);
                        levels.put(nextWord, level);
                        if(nextWord.equals(endWord))
                            found = true;
                    }
                    charArray[i] = origin;
                }
            }
            level++;
            if(found) break; //因为是广度优先，所以先找到的一定距离更短。
        }

        //找到的话，开始深度优先遍历，从endWord开始往回找
        if(found){
            //使用深度优先遍历时，同时记录遍历路径(deque)
            Deque<String> path = new ArrayDeque<>(); //用于记录整个路径
            path.add(endWord);
            dfs(from, path, beginWord, endWord, ret);
        }
        return ret;
    }

    private void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String curWord, List<List<String>> res){
        if(curWord.equals(beginWord)){
            res.add(new ArrayList<>(path));//使用Deque初始化List
            return;
        }
        //依次遍历当前节点的前继节点，全排列的写法
        for (String precursor : from.get(curWord)) {
            path.offerFirst(precursor);
            dfs(from, path, beginWord, precursor, res);
            path.pollFirst();
        }
    }
}
