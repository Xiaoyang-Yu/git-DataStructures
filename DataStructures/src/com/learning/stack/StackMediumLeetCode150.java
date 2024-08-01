package com.learning.stack;

import java.util.LinkedList;

public class StackMediumLeetCode150 {

    public static void main(String[] args) {
        String[] strings = {"4","13","5","*","+"};
        System.out.println(evalRPN(strings));


    }

    /**
     * 给定一个字符串数组，它表示逆波兰表示法tokens中的算术表达式。<br/>
     * 计算表达式的值。返回表示表达式值的整数。<br/>
     * 解释：逆波兰表达式，其实就是后缀表达式： 1 2 +   =3<br/>
     * 意思是： 1+ 2 ， 不过是把运算符放在数字后边<br/>
     * 例子：  4 13 5 / +  表示， 先运算13/5，然后运算 4+ 13/5.<br/>
     * 遇到的第一个符号，表示符号的两个数字跟这个符号计算，然后再看后边的符号<br/>
     * 例子：<br/>
     * 输入： tokens = ["2","1","+","3","*"]<br/>
     * 输出： 9<br/>
     * 解释： ((2 + 1) * 3) = 9<br/>
     * @param tokens  传入逆波兰表达式，字符串类型的数组
     * @return 计算结果
     */
    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();   //linkedList接口实现了栈，可以直接用对应的方法
        for (String token : tokens) {
            if (token.equals("+")){
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a + b);          //运算的时候，都用后弹出的a + 先弹出的b  这样能保证减法和除法正确。
            }else if (token.equals("-")){
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a - b);
            }else if (token.equals("*")){
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a * b);
            }else if (token.equals("/")){
                Integer b = stack.pop();
                Integer a = stack.pop();
                stack.push(a / b);
            }else {
                stack.push(Integer.parseInt(token));   //在这一个地方转换就行了。
            }
        }
        return stack.pop();
    }
}
