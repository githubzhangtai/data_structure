package com.kimizhang.example;


import java.util.Stack;

/**
 * @author Kimi
 * @date 2019/9/19
 */
public class Solution3 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if (stack.empty()){
                    return  false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
