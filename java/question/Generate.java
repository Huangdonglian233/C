package com.huang.question;
/*
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(5);
        for (List list:lists) {
            for (Object num:list) {
                System.out.print(num.toString());
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<Integer> list;
        List<List<Integer>> listList = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list = new ArrayList<>();
            if(i==0) {
                list.add(1);
                listList.add(list);
                continue;
            }
            list.add(1);
            if(i>1){
                for (int j = 1; j <=i-1 ; j++) {
                    list.add(listList.get(i-1).get(j-1) +listList.get(i-1).get(j));
                }
            }
            list.add(1);
            listList.add(list);
        }
        return listList;

    }
}
