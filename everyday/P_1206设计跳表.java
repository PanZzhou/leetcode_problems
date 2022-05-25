package com.pan.leetcode.everyday;

public class P_1206设计跳表 {
    private static final int MAX_LEVEL = 32;
    private static double RATE = 0.25;
    private Node head = new Node(null, MAX_LEVEL);
    private int curLevel = 1;
    public P_1206设计跳表() {
    }

    public boolean search(int target){
        Node searchNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            searchNode = findCloset(searchNode, i, target);
            if(searchNode.next[i] != null && searchNode.next[i].value == target)
                return true;
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node searchNode = head, next;
        //都要从最高层开始找最好，不能从level开始找，那样丧失了跳表的优势，太慢了
        for (int i = curLevel-1; i >= 0; i--) {
            searchNode = findCloset(searchNode, i, num);
            if(i<level){
                if(searchNode.next[i] == null){
                    searchNode.next[i] = newNode;
                }else{
                    next = searchNode.next[i];
                    searchNode.next[i] = newNode;
                    newNode.next[i] = next;
                }
            }
        }
        if(level > curLevel){
            for (int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel = level;
        }
    }

    public boolean erase(int num) {
        Node searchNode = head;
        boolean exit = false;
        for (int i = curLevel-1; i >= 0; i--) {
            searchNode = findCloset(searchNode, i, num);
            if(searchNode.next[i] != null && searchNode.next[i].value == num){
                searchNode.next[i] = searchNode.next[i].next[i];
                if(!exit) exit = true;
            }
        }
        return exit;
    }

    //找到level层value大于node的节点
    private Node findCloset(Node cur, int level, int value){
        while(cur.next[level]!= null && cur.next[level].value < value)
            cur = cur.next[level];
        return cur;
    }

    //随机一个层数
    private static int randomLevel(){
        int level = 1;
        //当随机数大于预定阈值时就增加层数
        while(Math.random() < RATE && level<MAX_LEVEL)
            level++;
        return level;
    }

    class Node{
        Integer value;
        Node[] next;

        public Node(){
        }
        public Node(Integer v, int size){
            value = v;
            next = new Node[size];
        }
        @Override
        public String toString(){
            return String.valueOf(value);
        }
    }
}
