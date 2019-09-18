package com.kimizhang;

/**
 * 栈方法接口
 * @author Kimi
 * @date 2019/9/17
 */
public interface Stack<E> {
    /**
     * 获取栈的size
     * @return size
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return true / false
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return 出栈的元素
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    E peek();
}
