package com.learning.array_;

import java.util.HashMap;
import java.util.Map;

public class ArrayEasyLeetCode1512 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr));
    }

    /**
     * A pair (i, j) is called good if nums[i] == nums[j] and i < j.  <br/>
     * 例如：<br/>
     * Input: nums = [1,2,3,1,1,3]  <br/>
     * Output: 4<br/>
     * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.<br/>
     * @param nums 数组
     * @return  返回good pairs的数量
     */
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    //用 hash table 时间复杂度是O(n)
    public int numIdenticalPairs2(int[] nums) {
        // 创建一个哈希表来记录每个数出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;
        // 遍历数组
        for (int num : nums) {
            // 如果哈希表中已经存在这个数，则获取它的出现次数并累加到goodPairs
            if (countMap.containsKey(num)) {
                goodPairs += countMap.get(num);
            }
            // 更新哈希表中这个数的出现次数
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return goodPairs;
    }
}
