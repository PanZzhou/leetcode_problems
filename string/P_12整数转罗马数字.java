package com.pan.leetcode.string;

public class P_12整数转罗马数字 {
    public String intToRoman(int num) {
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();
        int index=0;
        while(num!=0&&index<value.length){
            if(value[index]>num)
                index++;
            else{
                sb.append(symbol[index]);
                num -= value[index];
            }
        }
        return sb.toString();
    }
}
