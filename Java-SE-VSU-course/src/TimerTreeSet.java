import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class TimerTreeSet implements Timer{

    TreeSet<Integer> treeSet = new TreeSet<Integer>();


    @Override
    public long timer_add(){
        long time;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(i);
        }
        long time2 = System.currentTimeMillis();
        time =time2 - time1;
        return  time;
    }
    @Override
    public long timer_remove(){
        long time;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            treeSet.remove(0);
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return  time;
    }
    @Override
    public long timer_set(){
        long time;
        Random rnd = new Random();
        if (treeSet.size()!=0) {
            long time1 = System.currentTimeMillis();
            treeSet.contains(rnd.nextInt(10000));
            long time2 = System.currentTimeMillis();
            time = time2 - time1;
            return time;
        }
        else {return -1;}
    }

    @Override
    public long timer_get() {
        long time;
        long time1 = System.currentTimeMillis();
        Iterator<Integer> itr = treeSet.iterator();
        while (itr.hasNext()) {
            itr.next();
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return time;
    }
}
