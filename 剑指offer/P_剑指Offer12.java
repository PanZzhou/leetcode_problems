package com.pan.leetcode.剑指offer;

public class P_剑指Offer12 {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(i+"  "+j);
                if(dfs(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int index){
        if(index>=word.length())
            return true;
        if(i>= board.length||i<0||j>=board[0].length||j<0)
            return false;
        char c = board[i][j];
        char s = word.charAt(index);
        if(c==' '||s!=c)
            return false;
        board[i][j]=' ';
        boolean ret = dfs(board,i+1,j,word,index+1)
                ||dfs(board,i-1,j,word,index+1)
                ||dfs(board,i,j+1,word,index+1)
                ||dfs(board,i,j-1,word,index+1);
        board[i][j]=c;
        return ret;
    }
}
