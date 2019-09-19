package com.kimizhang.example;

import java.util.Stack;

/**
 * @author Kimi
 * @date 2019/9/19
 */
public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length() ; i++) {
            chars[i] = s.charAt(i);
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '('){
                stack.push(chars[i]);
                top++;
            }else if (chars[i] == ')'){
                if (top >= 0 && stack.peek() == '('){
                    stack.pop();
                    top--;
                }else {
                    return false;
                }
            }else if (chars[i] == '}'){
                if (top >= 0 && stack.peek() == '{'){
                    stack.pop();
                    top--;
                }else {
                    return false;
                }
            }else if (chars[i] == ']'){
                if (top >= 0 && stack.peek() == '['){
                    stack.pop();
                    top--;
                }else {
                    return false;
                }
            }
        }
        return top == -1;
    }


}
