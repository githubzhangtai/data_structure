package com.kimizhang;

/**
 * @author Kimi
 * @date 2019/9/8
 */
public class Array<E> {
    private E[] data;
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
        this.data = (E[])new Object[capacity];
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
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在所有元素之前添加一个新元素
     * @param e 新元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 向数组中指定位置插入一个元素
     * @param index 指定位置
     * @param e 要插入的元素
     */
    public void add(int index,E e){
        if (index <0 || index > size){
            throw new IllegalArgumentException("Add failed. 数组下标越界");
        }
        /*如果数组满了，扩容为原来的2倍*/
        if (size == data.length){
            resize(2 * data.length);
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
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index,E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否存在元素 e
     * @param e 元素e
     * @return boolean
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查看第一个元素 e 的索引,如果不存在，则返回 -1
     * @param e 元素 e
     * @return 索引的位置
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return i;
            }
        }
        return Constants.NEGATIVE_ONE;
    }

    public Array findAll(E e){
        if (find(e) == Constants.NEGATIVE_ONE){
            throw new IllegalArgumentException("没有找到元素");
        }
        Array array = new Array(size);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                array.addLast(i);
            }
        }
        return array;
    }

    /**
     * 删除一个元素
     * @param index 待删除的元素的索引
     * @return 被删除的元素
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E res = data[index];
        for (int i = index + 1; i < size ; i++) {
            data[i - 1] = data[i];
        }
        size--;
        /*loitering objects 此句没有实际业务作用；用于java垃圾回收*/
        data[size] = null;
        /*190916_当数组删除了一半，数组的容量自动减少（请继续看下一行注释）
        * 190917_避免复杂度震荡，实现lazy机制：
        *                        ①数组size变为原来的一半的时候不要着急缩容；
        *                        ②当size变为原来的 1/4 的时候才缩容；
        * */
        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除第一个元素
     * @return 被删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return 被删除的元素
     */
    public E removeLast(){
        return remove(size -1);
    }

    /**
     * 移除数组中第一个 e 元素
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != Constants.NEGATIVE_ONE) {
            remove(index);
        }
    }

    /**
     * 移除数组中所有元素 e
     * @param e
     */
    public void removeAllElement(E e){
        Array all = findAll(e);
        for (int i = 0 ; i < all.size ; i ++){
            removeElement(e);
        }

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

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
