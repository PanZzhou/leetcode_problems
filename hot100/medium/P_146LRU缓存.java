package com.pan.leetcode.hot100.medium;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class P_146LRU缓存 {
    class DLinkedList{
        private int key;
        private int value;
        private DLinkedList pre;

        public DLinkedList() {
        }

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        private DLinkedList next;
    }
    private Map<Integer, DLinkedList> map;
    private DLinkedList head;
    private DLinkedList tail;
    private int capacity;
    public P_146LRU缓存(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        DLinkedList cur = map.getOrDefault(key,null);
        if(cur == null)
            return -1;
        DLinkedList pre = cur.pre;
        if(pre != head){
            removeNode(cur);
            addToHead(cur);
        }
        return cur.value;
    }

    public void put(int key, int value) {
        DLinkedList cur = map.getOrDefault(key, null);
        if(cur == null){
            DLinkedList node = new DLinkedList(key, value);
            addToHead(node);
            map.put(key, node);
            if(map.size()>capacity){
                DLinkedList del = tail.pre, prev = del.pre;
                prev.next = tail;
                tail.pre = prev;
                map.remove(del.key);
            }
        }else{
            cur.value = value;
            removeNode(cur);
            addToHead(cur);
        }
    }
    private void removeNode(DLinkedList cur){
        DLinkedList pre = cur.pre, next = cur.next;
        pre.next = next;
        next.pre = pre;
    }
    private void addToHead(DLinkedList cur){
        DLinkedList next = head.next;
        head.next = cur;
        cur.next = next;
        next.pre = cur;
        cur.pre = head;
    }
}
