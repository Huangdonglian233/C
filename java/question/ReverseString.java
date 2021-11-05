package com.huang.question;

public class ReverseString {
    public static void main(String[] args) {
        char[] s={'h','a','b','n','a','h'};
        System.out.println();
        String s1="Let's take LeetCode contest";
        reverseString(s);
        for (char c:s) {
            System.out.print(c+" ");
        }
        reverse(s1);
        System.out.println(s1);
    }
    public static String reverse(String s){
        String[] chars=s.split(" ");
        s=null;
        for(int i=0;i< chars.length;i++) {
            char[] temp=chars[i].toCharArray();
            reverseString(temp);
            if(s==null&&chars.length>1){
                s=String.valueOf(temp)+" ";
            }else if(chars.length<=1){
                s=String.valueOf(temp);
            }else if(i==chars.length-1) {
                s += String.valueOf(temp);
            }else{
                s += String.valueOf(temp)+" ";
            }
        }
        return s;
    }
    public static void reverseString(char[] s) {
        int low=0;
        int high=s.length-1;
        while (low<high){
            if(s[low]==s[high]) {
                low++;
                high--;
                continue;
            }
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }
}
