import java.lang.String;

/**
 * 链表
 * @author Kimi
 * @date 2019/11/4
 */
public class LinkedList<E> {
    /**
     * 第一个节点之前的虚拟节点
     */
    private Node dummyHead;
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
        dummyHead = new Node(null,null);
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
     * 在链表指定位置添加元素
     * @param index 指定位置
     * @param e 要添加的元素
     */
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            Node node = new Node(e,prev.next);
            prev.next = node;

            size++;
    }

    /**
     * 在链表头添加新的元素
     * @param e 新的元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在链表末尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获取链表的第 index 个元素。
     * 注：这是在链表中不常用的一个操作，用到索引的话，建议之际用数组而不是用链表
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，下标越界!");
        }
        // 从第一个元素遍历到 index 位置的元素
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取连边的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size -1);
    }

    /**
     * 更新 index 位置的元素为新传进来的 e
     * @param index
     * @param e
     */
    public void update(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("获取失败，下标越界!");
        }
        // 从第一个元素遍历到 index 位置的元素
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查看链表中是否存在元素 e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
