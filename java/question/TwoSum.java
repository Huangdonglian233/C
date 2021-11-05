package com.huang.question;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers={3,24,50,79,88,150,345};
        int[] results=twoSum(numbers,200);
        for (int result:results) {
            System.out.print(result+" ");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        int i=0;
        int j= numbers.length - 1;
        while (i< j){
            if(numbers[i]+numbers[j]==target){
                result[0]=i+1;
                result[1]=j+1;
                return result;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else {
                j--;
            }
        }
        return result;
    }
}
