package com.pan.leetcode.hot100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
//        int[] temp;
//        for (int i = 1; i < n; i++) {
//            int cnt = i - people[i][1];
//            temp = people[i];
//            for (int j = i-1; j >= i - cnt; j--) {
//                people[j+1] = people[j];
//            }
//            people[i-cnt] = temp;
//        }
//        return people;
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
