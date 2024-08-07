package com.learning.array_;

public class ArrayEasyLeetCode2011 {

    /**
     * There is a programming language with only four operations and one variable X:<br/>
     * ++X and X++ increments the value of the variable X by 1.<br/>
     * --X and X-- decrements the value of the variable X by 1.<br/>
     * Initially, the value of X is 0.<br/>
     * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.<br/>
     * 例如：<br/>
     * Input: operations = ["--X","X++","X++"]  <br/>
     * Output: 1 <br/>
     * Explanation: The operations are performed as follows: <br/>
     * Initially, X = 0. <br/>
     * --X: X is decremented by 1, X =  0 - 1 = -1.<br/>
     * X++: X is incremented by 1, X = -1 + 1 =  0.<br/>
     * X++: X is incremented by 1, X =  0 + 1 =  1.<br/>
     * @param operations 数组
     * @return final value
     */
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;
        for (String operation : operations) {
            if (operation.equals("X++") || operation.equals("++X")) {
                x += 1;
            }
            if (operation.equals("X--") || operation.equals("--X")) {
                x -= 1;
            }
        }
        return x;
    }
}
