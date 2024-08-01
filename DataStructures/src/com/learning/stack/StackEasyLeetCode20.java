package com.learning.stack;

import java.util.Stack;

public class StackEasyLeetCode20 {
    public static void main(String[] args) {

        System.out.println(isValid("([{}])"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println("-------------------------");

        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("([]"));
        System.out.println(isValid("("));
        System.out.println("-------------------------");

        System.out.println(isValid(")("));
        System.out.println(isValid("]"));


    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {   //循环获取字符串每个字符
            char c = s.charAt(i);       //获取第i个字符
            if (c == '('){              //如果拿到的是'('  就把对应的右括号放进栈中
                stack.push(')');   //把对应的右括号放进栈中
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else {                     //如果都不是左括号，那么就对比，栈顶元素和右括号是否相同，并且弹出右括号
                    if (!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else {
                    return false;       //不同就说明括号不是有效的，返回false
                }
            }
        }
        return stack.isEmpty();    //对比完成之后，如果所有左括号都匹配上了右括号，那么栈中应该是空的，就返回true，反之返回false
    }
}
