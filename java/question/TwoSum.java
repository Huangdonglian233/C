package com.huang.question;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers={2,7,11,15};
        int[] results=twoSum(numbers,18);
        for (int result:results) {
            System.out.print(result+" ");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< numbers.length;i++){
            int temp=target-numbers[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)};
            }
            map.put(numbers[i],i);
        }
        return new int[0];
    }
}
/*
方法一：
int[] result=new int[2];
        int i=0;
        int j= numbers.length - 1;
        while (i<j) {
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                } else {
                    j--;
                }
            }
            i++;
            j= numbers.length - 1;
        }
        return result;
方法二：
int[] result=new int[2];
        int i=0;
        for(i=0;i< numbers.length;i++) {
            int temp = target - numbers[i];
            int j = numbers.length - 1;
            while (i < j) {
                if (numbers[j] == temp) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                } else {
                    j--;
                }
            }
        }
        return result;
    }
 */