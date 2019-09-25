package com.kimizhang;

/**
 * 栈实现方法
 * @author Kimi
 * @date 2019/9/17
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 动态数组
     */
    Array<E> array;

    /**
     * 带参构造函数
     * @param capacity
     */
    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 容量
     * @return 容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
