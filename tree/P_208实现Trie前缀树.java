package com.pan.leetcode.tree;

public class P_208实现Trie前缀树 {
    private P_208实现Trie前缀树[] trie;
    private boolean isEnd;
    public P_208实现Trie前缀树() {
        trie = new P_208实现Trie前缀树[26];
        isEnd = false;
    }

    public void insert(String word) {
        int len = word.length();
        P_208实现Trie前缀树 node = this;
        for (int i = 0; i < len; i++) {
            int inx = word.charAt(i) - 'a';
            if(node.trie[inx] == null){
                node.trie[inx] = new P_208实现Trie前缀树();
            }
            node = node.trie[inx];
        }
        node.isEnd = true;//单词结尾标记放在下一个节点
    }

    public boolean search(String word) {
        P_208实现Trie前缀树 node = this;
        for (int i = 0; i < word.length(); i++) {
            int inx = word.charAt(i) - 'a';
            if(node.trie[inx] == null)
                return false;
            node = node.trie[inx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        P_208实现Trie前缀树 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int inx = prefix.charAt(i) - 'a';
            if(node.trie[inx] == null)
                return false;
            node = node.trie[inx];
        }
        return true;
    }
}
