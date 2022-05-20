package com.pan.leetcode.剑指offerII.medium;

import java.util.HashMap;
import java.util.Map;

public class P_剑指Offer_II_031最近最少使用缓存 {
    private class BiNode{
        public int key;
        public int value;
        public BiNode pre;
        public BiNode next;
        public BiNode(){}
        public BiNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private BiNode head;
    private BiNode tail;
    private Map<Integer, BiNode> map;
    private int capacity;
    private int size;

    public P_剑指Offer_II_031最近最少使用缓存(int capacity) {
        head = new BiNode();
        tail = new BiNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
    }

    private void remove(BiNode root){
        BiNode p = root.pre, n = root.next;
        p.next = n;
        n.pre = p;
    }

    private void addToHead(BiNode root){
        BiNode n = head.next;
        head.next = root;
        root.pre = head;
        root.next = n;
        n.pre = root;
    }

    public int get(int key) {
        BiNode cur = map.getOrDefault(key, null);
        if(cur == null) return -1;
        if(cur.pre != head){
            remove(cur);
            addToHead(cur);
        }
        return cur.value;
    }

    public void put(int key, int value) {
        BiNode cur = map.getOrDefault(key, null);
        if(cur == null){
            cur = new BiNode(key, value);
            addToHead(cur);
            map.put(key, cur);
            if(size == capacity){
                BiNode Del = tail.pre;
                remove(Del);
                map.remove(Del.key);
            }else
                size++;
        }else{
            cur.value = value;
            remove(cur);
            addToHead(cur);
        }
    }
}
