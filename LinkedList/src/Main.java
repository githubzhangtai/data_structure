

public class Main {

    public static void main(String[] args) {



        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0;i < 5 ; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(3,666);
        System.out.println(linkedList);

        System.out.printf("--------- 删除%s------------\n",linkedList.delete(3));
        System.out.println(linkedList);

        System.out.printf("---------删除%s--------------\n",linkedList.delete(0));
        System.out.println(linkedList);

        System.out.printf("---------删除0--------------\n",linkedList.delete(linkedList.getSize()-1));
        System.out.println(linkedList.getSize());
        System.out.println(linkedList);

        System.out.printf("全部删除\n");
        linkedList.deleteAll();
        System.out.printf("还剩：%s\n",linkedList);
        System.out.println(linkedList.getSize());
    }
}
