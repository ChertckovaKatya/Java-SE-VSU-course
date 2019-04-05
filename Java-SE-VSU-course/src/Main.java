
public class Main {

    public static void main(String[] args) {
        System.out.println("Название  "+" Добавление  " + " Удаление  "+ "  Просмотр "+ "  Перебор всех элементов  ");
    TimerArrayList object1= new TimerArrayList();
        long t1 = 0;
        long t2 = 0;
    for(int i=0;i<5;i++) {
       t1+= object1.timer_add();
       t2+= object1.timer_remove();
    }
    t1= t1/5;
    t2=t2/5;
    object1.timer_add();
    System.out.println("ArrayList    "+ t1+ "           "+ t2+ "            "+object1.timer_set()+ "            " + object1.timer_get() );
    TimerLinkedList linkedList = new TimerLinkedList();
    t1=0; t2=0;
        for(int i=0;i<5;i++) {
            t1+= linkedList.timer_add();
            t2+= linkedList.timer_remove();
        }
        t1=t1/5;
        t2=t2/5;
        linkedList.timer_add();
        System.out.println("LinkedList   "+ t1+ "            "+ t2+ "            "+linkedList.timer_set()+ "            " + linkedList.timer_get() );
        TimerHashSet hashSet = new TimerHashSet();
        t1=0; t2=0;
        for(int i=0;i<5;i++) {
            t1+= hashSet.timer_add();
            t2+= hashSet.timer_remove();
        }
        t1=t1/5;
        t2=t2/5;
        hashSet.timer_add();
        System.out.println("HashSet      "+ t1+ "           "+ t2+ "             "+hashSet.timer_set()+ "            " + hashSet.timer_get() );
        TimerTreeSet treeSet = new TimerTreeSet();
        t1=0; t2=0;
        for(int i=0;i<5;i++) {
            t1+= treeSet.timer_add();
            t2+= treeSet.timer_remove();
        }
        t1=t1/5;
        t2=t2/5;
        treeSet.timer_add();
        System.out.println("HashSet      "+ t1+ "           "+ t2+ "           "+treeSet.timer_set()+ "             " + treeSet.timer_get() );
        TimerHashMap hashMap = new TimerHashMap();
        t1=0; t2=0;
        for(int i=0;i<5;i++) {
            t1+= hashMap.timer_add();
            t2+= hashMap.timer_remove();
        }
        t1=t1/5;
        t2=t2/5;
        hashMap.timer_add();
        System.out.println("TimerHashMap "+ t1+ "           "+ t2+ "            "+hashMap.timer_set()+ "             " + hashMap.timer_get() );
        TimerTreeMap treeMap = new TimerTreeMap();
        t1=0; t2=0;
        for(int i=0;i<5;i++) {
            t1+= treeMap.timer_add();
            t2+= treeMap.timer_remove();
        }
        t1=t1/5;
        t2=t2/5;
        treeMap.timer_add();
        System.out.println("TimerTreeMap "+ t1+ "           "+ t2+ "           "+treeMap.timer_set()+ "             " + treeMap.timer_get() );

    }
}
