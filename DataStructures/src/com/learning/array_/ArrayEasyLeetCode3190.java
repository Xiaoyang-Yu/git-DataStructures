package com.learning.array_;

public class ArrayEasyLeetCode3190 {

    /**
     * 给定一个数组，能对数组中的元素进行 +1 或者 -1 <br/>
     * 使得所有元素都能被三整除<br/>
     * 求进行几次 加减操作，才能使得整个数组都能被3整除<br/>
     * @param nums 数组
     * @return 操作数
     */
    public int minimumOperations(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0){
                count++;
            }
        }
        return count;
        /* for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 1){
                nums[i] = nums[i] - 1;
                count++;
            }
            if (nums[i] % 3 == 2){
                nums[i] = nums[i] + 1;
                count++;
            }
        }*/
    }
}
