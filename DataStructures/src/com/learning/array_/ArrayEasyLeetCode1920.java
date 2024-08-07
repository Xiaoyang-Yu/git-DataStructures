package com.learning.array_;

public class ArrayEasyLeetCode1920 {

    /**
     * 给定一个从零开始的排列 nums（0 索引），为每个排列构建一个相同长度ans的数组并返回它。<br/>
     * ans[i] = nums[nums[i]]   0 <= i < nums.length<br/>
     * @param nums 数组
     * @return  新数组
     */
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
