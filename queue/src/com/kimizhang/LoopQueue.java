package com.kimizhang;

/**
 * 数组循环队列
 * @author Kimi
 * @date 2019/10/9
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    /**
     * 队列头部，第一个元素所在的位置
     */
    private int front;
    /**
     * 队列尾部，新元素将要添加的位置
     */
    private int tail;
    /**
     * 元素个数
     */
    private int size;

    /**
     * 带参构造函数：循环队列中会有意浪费一个空间，这是因为规定了 front == tail 时表示数组为空；
     * 如果让数组满的话，也会使得 front == tail ，不符合 front == tail 为空的规定。
     * @param capacity 传入的参数，容量。由于会刻意浪费一个空间，所以 new的空间大小应为 capacity + 1，
     *                 这样才会使实际容量为capacity.
     */
    public LoopQueue(int capacity){
        this.data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // tail++;本应是tail++，但是由于循环，所以应该取余↓
        tail = (tail +1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Dequeue failed. The dequeue is empty");
        }
        E res = data[front];
        data[front] = null;
        //front++;本应是front++,但是由于循环，所以应该取余
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("The dequeue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1 ];
        for (int i = 0; i < size; i++) {
            //data[0] 对应循环队列newData[front],由于需要循环，所以取余.
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", this.size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
