/**
 * @author Kimi
 * @date 2019/11/4
 */
public class LinkedList<E> {
    private Node head;
    private int size;

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
     * 无参构造函数
     */
    public LinkedList(){
        head = null;
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 查看链表是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     * @param e 新的元素
     */
    public void addFirst(E e){
        head = new Node(e,head);
        size++;
    }

    /**
     * 在链表指定位置添加元素
     * @param index 指定位置
     * @param e 要添加的元素
     */
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        if (index == 0){
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e,prev.next);
            prev.next = node;

            size++;
        }
    }

    /**
     * 在链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }


}