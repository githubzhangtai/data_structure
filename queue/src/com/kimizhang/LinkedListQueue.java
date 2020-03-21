package com.kimizhang;

/**
 * 用链表的方式实现队列
 * 在链表中加入尾节点（tail），链表的头部删除和增加都是O（1）的复杂度；尾部增加时O（1）
 * 所以链表头作为队列的头（出队的一方），链表尾作为队列的尾（入队的一方）
 * @author Kimi
 * @date 2020/3/22
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 节点内部类
     */
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 队列大小
     */
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;

    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("出队失败，队列中没有元素！");
        }
        // 队首的元素
        Node firstNode = head;
        head = head.next;
        firstNode.next = null;
        //如果队列中原来只有一个元素，出队后队列为空.
        if (head == null){
            tail = null;
        }
        size --;
        return firstNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("出队失败，队列中没有元素！");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue：front ");

        Node cur = head;
        while (cur != null){
            res.append(cur  + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

}
