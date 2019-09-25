package com.kimizhang;

/**
 * 栈方法接口
 * @author Kimi
 * @date 2019/9/25
 */
public interface Queue<E> {

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return 出对的元素
     */
    E dequeue();

    /**
     * 查看队首的元素
     * @return 队首的元素
     */
    E getFront();

    /**
     * 获取队列的size
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();
}
