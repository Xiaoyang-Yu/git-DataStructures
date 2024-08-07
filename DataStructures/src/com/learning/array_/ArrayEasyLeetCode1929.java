package com.learning.array_;

public class ArrayEasyLeetCode1929 {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int[] ints = getConcatenation(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    /**
     * 给定一个长度n为 的整数数组nums，您想要创建一个长度为2n的数组ans，<br/>
     * 其中ans[i] == nums[i]和ans[i + n] == nums[i] 为0 <= i < n（从 0 开始索引）。<br/>
     * 具体来说，ans是两个数组的串联nums。<br/>
     * 返回数组ans。<br/>
     * 示例 1：<br/>
     * 输入： nums = [1,2,1]<br/>
     * 输出： [1,2,1,1,2,1]<br/>
     * 解释：数组 ans 的形成如下：<br/>
     * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]<br/>
     * - 答案 = [1,2,1,1,2,1]<br/>
     * @param nums 数组
     * @return  新数组
     */
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
