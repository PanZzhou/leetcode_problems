package com.pan.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class P_133克隆图 {
    public Node cloneGraph(Node node) {
        Map<Node,Node> hash = new HashMap<>();
        return dfs(node,hash);
        // return bfs(node,new HashMap<Node,Node>(),new LinkedList<Node>());
    }
    private Node dfs(Node node,Map<Node,Node> hash){
        if(node==null)
            return node;
        if(hash.containsKey(node))
            return hash.get(node);
        Node copyCode = new Node(node.val,new ArrayList<>());
        hash.put(node,copyCode);
        for (Node neighbor : node.neighbors) {
            copyCode.neighbors.add(dfs(neighbor,hash));
        }
        return copyCode;
    }
    private Node bfs(Node node, Map<Node,Node> hash, Queue<Node> queue){
        if(node==null)
            return node;
        queue.offer(node);
        hash.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node top = queue.poll();
            for (Node neighbor : top.neighbors) {
                if(!hash.containsKey(neighbor)){
                    hash.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.offer(neighbor);
                }
                hash.get(top).neighbors.add(hash.get(neighbor));
            }
        }
        return hash.get(node);
    }
}
