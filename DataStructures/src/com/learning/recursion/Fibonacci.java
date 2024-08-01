package com.learning.recursion;

import java.util.Arrays;

/**
 * 斐波那契数列：
 * 数列前两个数是固定的 0 和 1
 * 当n>1的时候， n = (n-1) + (n-2)
 */
public class Fibonacci {

    public static void main(String[] args) {

        int result = result(30);
        System.out.println(result);
    }

    public static int fib(int n){

        //n等于0， 就是0
        if (n == 0){
            return 0;
        }
        //n等于1， 就是1
        if (n == 1){
            return 1;
        }
        //n的前一个数
        int x = fib(n - 1);
        //n的前一个数的 前一个数
        int y = fib(n - 2);
        //结果是，x+y
        return x + y;
    }

    public static int result(int n) {
        int[] cache = new int[n+1]; //定义数组，用于存放计算结果，数组长度是n+1
        Arrays.fill(cache, -1); //用 -1 填充满数组
        cache[0] = 0;
        cache[1] = 1;  //0 和 1 是固定的
        return fibEdit(n, cache);
    }
    /**
     * 改进版，原来的时间复杂度是Θ(1.618^n)  改进后是O(n)
     *        由于存在额外的数组，所以这里是空间换时间
     * @param n --
     * @param cache --数组，用于把计算结果存入数组
     * @return
     */
    public static int fibEdit(int n, int[] cache){

        if (cache[n] != -1){
            return cache[n];  //如果在递归中，结果不等于 -1 说明结果已经计算出来，不要计算第二次，直接从数组拿。
        }
        //n的前一个数
        int x = fib(n - 1);
        //n的前一个数的 前一个数
        int y = fib(n - 2);
        //
        int result = x + y;
        cache[n] = result;  //结果放入到数组中
        return cache[n];
    }
}
