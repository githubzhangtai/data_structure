package com.kimizhang.example;

/**
 * 括号匹配算法解法一
 * 第一步：初始化一个长度为输入参数String的长度的数组，作为我们的栈.
 * 第二步：初始化栈顶为 -1.
 * 第三步：遍历我们的栈，如果元素为'('、'{'、'['入栈；如果为右括号，判断栈顶元素是否为与之匹配的左括号，是的话出栈，不是false.
 * 第四步：最后栈顶为为 -1，表示栈中元素全部出栈，返回 true
 * @author Kimi
 * @date 2019/9/18
 */
public class Solution1 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(' || currentChar == '{' || currentChar == '['){
                stack[++top] = currentChar;
            }else if (currentChar == ')'){
                if (top >= 0 && stack[top] == '('){
                    top--;
                }else {
                    return false;
                }
            }else if (currentChar == '}'){
                if (top >= 0 && stack[top] == '{'){
                    top--;
                }else {
                    return false;
                }
            }else if (currentChar == ']'){
                if (top >= 0 && stack[top] == '['){
                    top--;
                }else {
                    return false;
                }
            }
        }
        return top == -1;
    }
}