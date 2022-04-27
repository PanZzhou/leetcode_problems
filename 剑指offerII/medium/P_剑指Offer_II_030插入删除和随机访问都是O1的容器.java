package com.pan.leetcode.剑指offerII.medium;

import javax.print.DocFlavor;
import java.util.*;

public class P_剑指Offer_II_030插入删除和随机访问都是O1的容器 {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public P_剑指Offer_II_030插入删除和随机访问都是O1的容器() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
