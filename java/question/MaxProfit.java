package com.huang.question;
/*
给定一个数组 prices ，它的第i个元素prices[i]表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices={2,4,1};
        int profit=maxProfit2(prices);
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int i=0;
        int j=prices.length-1;
        while (i<j) {
            while (i < j) {
                if (prices[i] < prices[j]) {
                    if ((prices[j] - prices[i]) > profit) {
                        profit = prices[j] - prices[i];
                    }
                }
                j--;
            }
            i++;
            j=prices.length-1;
        }
        return profit;
    }

    public static int maxProfit1(int[] prices){
        int profit=0;
        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if(prices[j] - prices[i] > profit){
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] prices){
        int minPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else {
                if(prices[i] - minPrice > profit){
                    profit = prices[i] - minPrice;
                }
            }
        }
        return profit;
    }
}
