package com.kimizhang;

/**
 * @author Kimi
 * @date 2019/9/8
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * 无参构造函数,默认容量为 10
     */
    public Array(){
        this(10);
    }

    /**
     * 构造函数，传入容量构造数组
     * @param capacity 容量
     */
    public Array(int capacity){
        this.data = new int[capacity];
        this.size = 0;
    }

    /**
     * 获取数组中元素的个数
     * @return size
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return 数组定义的长度
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组最后添加一个新元素
     * ps：数组的size实质上就是指向第一个为空的元素的下标，在数组最后添加一个新元素实质就是在data[size]的位置添加元素
     * @param e 要添加的元素
     */
    public void addLast(int e){
        add(size,e);
    }

    /**
     * 在所有元素之前添加一个新元素
     * @param e 新元素
     */
    public void addFirst(int e){
        add(0,e);
    }

    /**
     * 向数组中指定位置插入一个元素
     * @param index 指定位置
     * @param e 要插入的元素
     */
    public void add(int index,int e){
        if (size == data.length){
            throw new IllegalArgumentException("Add failed. Array is full");
        }
        if (index <0 || index > size){
            throw new IllegalArgumentException("Add failed. 数组下标越界");
        }
        for (int i = size-1;i >= index ;i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 获取 index 索引位置的元素
     * @param index 小标索引
     * @return
     */
    public int get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index,int e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public  String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",this.size,data.length));
        res.append("[");
        for (int i = 0; i < size ; i++) {
            res.append(data[i]);
            if (i != size -1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }


}
