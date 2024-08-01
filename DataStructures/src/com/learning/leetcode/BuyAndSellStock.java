package com.learning.leetcode;

import java.util.*;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // 如果价格数组为空或者只有一个价格，则无法获得利润
        }

        int minPrice = prices[0]; // 初始化最小买入价格为第一天的价格
        int maxProfit = 0; // 初始化最大利润为0

        for (int i = 1; i < prices.length; i++) {
            // 如果当前价格比之前的最小买入价格低，则更新最小买入价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 计算当前价格卖出时的利润，并与之前的最大利润比较
            int currentProfit = prices[i] - minPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }
}
