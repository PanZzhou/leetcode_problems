package com.pan.leetcode.everyday;

import java.util.*;

public class P_699掉落的方块 {
    //忽略边界,记录每个方块的叠加高度,暴力搜索前面的方块
//        public List<Integer> fallingSquares(int[][] positions) {
//        List<Integer> ret = new ArrayList<>();
//        //越往后叠高度肯定只增不减
//        for (int i = 0; i < positions.length; i++) {
//            int left = positions[i][0], right = left + positions[i][1] -1, height = positions[i][1];
//            for (int j = 0; j < i; j++) {
//                int left1 = positions[j][0],  right1 = left1 + positions[j][1] - 1;
//                if(!(right < left1 || left > right1))
//                    height = Math.max(height, ret.get(j)+positions[i][1]);
//            }
//            ret.add(height);
//        }
//        //计算当前总共的最高高度
//        for (int i = 1; i < ret.size(); i++) {
//            ret.set(i, Math.max(ret.get(i), ret.get(i-1)));
//        }
//        return ret;
//    }

//    TreeMap和TreeSet的使用方法
//    使用有序集合记录高度有变化的边界和对应的高度.
//    public List<Integer> fallingSquares(int[][] positions) {
//        int n = positions.length;
//        List<Integer> ret = new ArrayList<>();
//        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
//        heightMap.put(0, 0);//高度从0开始
//        for (int i = 0; i < n; i++) {
//            int left = positions[i][0], right = positions[i][0] + positions[i][1] - 1;
//            int height =positions[i][1];
//            //找到靠后的边界点.
//            Integer lp = heightMap.higherKey(left);
//            Integer rp = heightMap.higherKey(right);
//            //确定右边界的高度
//            Integer prevRightKey  = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
//            int rHeight  = prevRightKey  != null ? heightMap.get(prevRightKey ) : 0;
//            //确定左边界并删除中间的点
//            Integer prevLeftKey  = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
//            Map<Integer, Integer> tail = prevLeftKey  != null ? heightMap.tailMap(prevLeftKey ) : heightMap;
//            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
//                if(entry.getKey() == rp) break;
//                height = Math.max(height, entry.getValue() + positions[i][1]);
//            }
//            //注意,这里用的是TreeSet!!!而不是HashSet
//            Set<Integer> keySet = new TreeSet<>(tail.keySet());
//            for (Integer tmp : keySet) {
//                if(lp==null ||tmp < lp)
//                    continue;
//                if(rp != null && tmp >= rp)
//                    break;
//                heightMap.remove(tmp);
//            }
//            heightMap.put(left, height);
//            if(rp == null || rp != right+1){
//                heightMap.put(right+1, rHeight );
//            }
//            ret.add(i>0?Math.max(height, ret.get(i-1)):height);
//        }
//        return ret;
//    }

    //线段树解法
    public class Node {
        int left;
        int right;
        int height;
        int maxRight;//最右边界
        Node l;
        Node r;

        public Node (int left, int right, int height, int maxRight) {
            this.left = left;
            this.right = right;
            this.height = height;
            this.maxRight = maxRight;
        }
    }
    public List<Integer> fallingSquares(int[][] positions) {
        Node root = null;
        List<Integer> ans = new ArrayList<>();
        int maxH = 0;
        for (int[] position : positions) {
            int left = position[0];
            int right = position[1] + left;
            int height = position[1];
            int curHeight = query(root, left, right);
            root = update(root, left, right, curHeight + height);
            maxH = Math.max(maxH, curHeight + height);
            ans.add(maxH);
        }
        return ans;
    }

    public Node update(Node root, int left, int right, int height) {
        if (root == null) {
            //新节点的最大边界都只到自己的右边界
            return new Node(left, right, height, right);
        }
        //只向其中一边插入新节点
        if (left < root.left) {
            root.l = update(root.l, left, right, height);
        } else {
            root.r = update(root.r, left, right, height);
        }
        //当前节点的最右边可能被新节点覆盖
        root.maxRight = Math.max(right, root.maxRight);
        return root;
    }
    //以root节点开始,查找高度
    public int query(Node root, int left, int right) {
        //大于最右边界了,直接返回0
        if (root == null || left >= root.maxRight) {
            return 0;
        }
        int ans = 0;
        //如果压到了这块砖,就记录这个高度
        if (right > root.left && left < root.right) {
            ans = root.height;
        }
        //看看压到左边的砖没
        ans = Math.max(ans, query(root.l, left, right));
        //有重合的话,证明可能在右节点叠加
        if (right > root.left) {
            ans = Math.max(ans, query(root.r, left, right));
        }
        return ans;
    }
}
