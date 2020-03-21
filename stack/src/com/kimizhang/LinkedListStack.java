package com.kimizhang;

/**
 * 用链表的方式实现栈
 * 数组栈（ArrayStack）和链表栈的时间复杂度均为 O(1)
 * @author Kimi
 * @date 2020/3/22
 */
public class LinkedListStack<E> implements Stack<E> {
    private  LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.deleteFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(list);
        return res.toString();
    }

    /**
     * 测试 Main 方法
     * @param args
     */
    public static void main(String[] args) {
        Stack stack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
