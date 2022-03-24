package com.pan.leetcode.搜索;

import java.util.ArrayList;
import java.util.List;

public class P_37解数独 {
    boolean done = false;
    public void solveSudoku(char[][] board) {
        int[] row = new int[9];//标记当前行已存在的数
        int[] col = new int[9];//标记当前列已存在的数
        int[] area = new int[9];//标记当前3*3区域已存在的数
        List<int[]> blank = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){//只处理非'.'
                    //初始化
                    int pos = getPos(i, j);
                    int bit = getMask(board[i][j] - '0');
                    row[i] = bit | row[i];//记录当前行已存在的数
                    col[j] = bit | col[j];//记录当前列
                    area[pos] = bit | area[pos];
                }else
                    //存下所有'.'的下标，用作以后对所有的'.'做递归
                    blank.add(new int[]{i, j});
            }
        }
        //是对blank递归，而非对board递归
        dfs(board, row, col, area, blank,0);
    }

    private void dfs(char[][] board, int[] row, int[] col, int[] area, List<int[]> blank, int order){
        if(order == blank.size()){//已处理完blank中所有的'.'
            done = true;
            return;
        }
        int[] orders = blank.get(order);//获取当前'.'递归对象的下标
        int i = orders[0];//行号
        int j = orders[1];//列号
        int inx = getPos(i, j);//区域号
        //获取当前'.'元素位置里可以填入的数字列表（用位来标记）
        int position = (1<<9)-1 & (~(row[i] | col[j] | area[inx]));
        //当前空无法再填入任何数字了，直接返回
        if(position == 0)
            return;
        //遍历完当前位置能够填入的所有侯选数
        while(!done && position!=0){
            int bit = position & (-position);//获取最低位（可参考n皇后问题中的题解）
            position = position & (position-1);//最低位置为1（同上）
            int candidate = Integer.bitCount(bit-1) + 1;//得到int形式的侯选数
            board[i][j] = (char) (candidate + '0');//填上候选数对应的字符；
            int pos = getPos(i, j);//获取area号
            row[i] |= bit;//记录当前行已存入这个候选数
            col[j] |= bit;//记录当前列已存入这个候选数
            area[pos] |= bit;//记录当前区域已存入填上的这个候选数
            //递归下一个'.'字符的位置
            dfs(board, row, col, area, blank, order+1);
            if(!done){
                //没找到的话，就还原递归前的状态
                board[i][j] = '.';
                row[i] -= bit;//bit的二进制中只有一个1，所以减去bit就可以抹去之前做的标记
                col[j] -= bit;//同上
                area[pos] -= bit;//同上
            }
        }
    }

    //根据下标找到对应的area下标
    private int getPos(int i, int j){
        int row = i/3;
        int col = j/3;
        return row*3+col;
    }
    //利用二进制的位标号来记录cur的大小
    private int getMask(int num){
        return 1<<(num-1);
    }
}
