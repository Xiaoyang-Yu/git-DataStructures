package com.learning.leetcode;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int[] arr2 = twoSum(arr, 6);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
    //暴力法，先找第一个元素， 再找第二个元素。
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j <= nums.length - 1; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
