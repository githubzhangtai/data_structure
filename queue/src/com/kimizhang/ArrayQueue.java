package com.kimizhang;

/**
 * @author Kimi
 * @date 2019/9/25
 */
public class ArrayQueue<E> implements Queue<E> {

    /**
     * 初始化数组
     */
    private Array<E> array;

    /**
     *构造函数
     * @param capacity 队列初始容量
     */
    public ArrayQueue(int capacity){
        this.array = new Array<>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayQueue(){
        this.array = new Array<>();
    }


    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] font");
        return res.toString();
    }
}