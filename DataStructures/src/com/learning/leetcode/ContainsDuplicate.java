package com.learning.leetcode;

import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(arr));

    }
    // set中的元素，不允许有重复的。所以判断set的size和数组的length是否相同，可以得出，是否存在重复元素
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (nums.length == set.size()){
            return false;
        }
        return true;
    }
}
